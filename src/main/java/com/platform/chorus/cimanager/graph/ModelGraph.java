package com.platform.chorus.cimanager.graph;

import com.platform.chorus.jooq.tables.pojos.Model;
import com.platform.chorus.neo4j.GraphService;
import org.apache.logging.log4j.util.Strings;
import org.neo4j.driver.v1.StatementResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by A.T on 2019/4/30
 */
@Component
public class ModelGraph implements Graph<Model> {
    private GraphService graph;

    @Autowired
    public ModelGraph(GraphService graph) {
        this.graph = graph;
    }

    @Override
    public void create(Model model) {
        String domain = model.getDomain();
        String name = model.getName();
        String extend = model.getExtend();

        graph.createNode(getId(domain, name),
                String.format("{ domain: '%s', name: '%s'}", domain, name));

        if (Strings.isNotEmpty(extend)) {
            graph.createRelation(getId(domain, name),
                    getId(extend), EXTEND);
        }
    }

    @Override
    public void delete(Model model) {
        String nodeId = getId(model.getDomain(), model.getName());
        graph.deleteNode(nodeId);
    }

    /**
     *  get all related models by specific model type
     *
     * @param type equals domain.name
     * @return type List
     */
    public List<String> getRelatedType(String type) {
        StatementResult result = graph.query(String.format("match (a:%s)-[r:%s|%s *1..5]->(b) return b.domain, b.name", buildClassNodeId(type), EXTEND, REFERENCE));

        List<String> types = result.stream().map(r -> r.get(0).asString() + "." + r.get(1).asString()).collect(Collectors.toList());
        types.add(type);

        return types;
    }

    private String getId(String domain, String name) {
        return String.format("%s:%s:%s", "class", buildCommonId(domain), name);
    }

    private String getId(String classPath) {
        return String.format("%s:%s", "class", buildCommonId(classPath));
    }

}
