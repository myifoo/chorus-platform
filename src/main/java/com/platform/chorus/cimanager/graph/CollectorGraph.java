package com.platform.chorus.cimanager.graph;

import com.platform.chorus.jooq.tables.pojos.Collector;
import com.platform.chorus.neo4j.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Create by A.T on 2019/4/30
 */
@Component
public class CollectorGraph implements Graph<Collector> {
    private GraphService graph;

    @Autowired
    public CollectorGraph(GraphService graph) {
        this.graph = graph;
    }

    @Override
    public void create(Collector collector) {
        String collectorId = getId(collector.getName());

        graph.createNode(collectorId, String.format("{ result: %s}", collector.getResult()));
        graph.createRelation(collectorId, buildClassNodeId(collector.getResult()), COLLECT);
    }

    @Override
    public void delete(Collector collector) {
        String id = getId(collector.getName());
        graph.deleteNode(id);
    }

    private String getId(String name) {
        return String.format("%s:%s", "collector", name);
    }
}
