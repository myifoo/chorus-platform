package com.platform.chorus.cimanager.graph;

import com.platform.chorus.jooq.tables.daos.EntityDao;
import com.platform.chorus.jooq.tables.pojos.Entity;
import com.platform.chorus.neo4j.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Create by A.T on 2019/4/30
 */
@Component
public class EntityGraph implements Graph<Entity> {
    private GraphService graph;
    private EntityDao entityDao;

    @Autowired
    public EntityGraph(GraphService graph, EntityDao entityDao) {
        this.graph = graph;
        this.entityDao = entityDao;
    }

    @Override
    public void create(Entity entity) {
        String itemId = buildItemNodeId(entity.getType(), entity.getName());

        graph.createNode(itemId,
                String.format("{name:'%s', type:'%s', creator:'%s'}",
                        entity.getName(),
                        entity.getType(),
                        entity.getCreator())
        );

        graph.createRelation(buildClassNodeId(entity.getType()), itemId, INSTANCE);

        entityDao.fetchById(entity.getAssociate()).forEach(e->{
            graph.createRelation(
                    buildItemNodeId(entity.getType(), entity.getName()),
                    buildItemNodeId(e.getType(), e.getName()),
                    CONTAIN);
        });
    }

    @Override
    public void delete(Entity entity) {

    }

    private String buildItemNodeId(String type, String name) {
        return String.format("%s:%s:%s", "item", buildCommonId(type), name);
    }
}
