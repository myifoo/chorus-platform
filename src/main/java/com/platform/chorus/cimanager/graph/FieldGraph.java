package com.platform.chorus.cimanager.graph;

import com.platform.chorus.jooq.tables.pojos.Field;
import com.platform.chorus.neo4j.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Create by A.T on 2019/4/30
 */
@Component
public class FieldGraph implements Graph<Field>{
    private final static String[] PRIMITIVE_TYPES = {"string", "integer", "float", "boolean", "long", "double"};

    private GraphService graph;

    @Autowired
    public FieldGraph(GraphService graph) {
        this.graph = graph;
    }

    @Override
    public void create(Field field) {
        String owner = field.getOwner();
        String name = field.getName();
        String type = field.getType();
        String label = field.getLabel();

        graph.createNode(getId(owner, name),
                String.format("{ type: '%s', name: '%s', label: '%s'}", type, name, label));

        graph.createRelation(
                buildClassNodeId(owner),
                getId(owner, name),
                OWN);

        if (Arrays.stream(PRIMITIVE_TYPES).noneMatch(t -> t.equals(type))) {
            graph.createRelation(
                    buildClassNodeId(owner),
                    buildClassNodeId(type),
                    REFERENCE);
        }
    }

    @Override
    public void delete(Field field) {
        String nodeId = getId(field.getOwner(), field.getName());
        graph.deleteNode(nodeId);
    }



    private String getId(String owner, String name) {
        return String.format("%s:%s:%s", "field", buildCommonId(owner), name);
    }
}
