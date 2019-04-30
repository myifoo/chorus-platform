package com.platform.chorus.neo4j;

import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

/**
 * Create by A.T on 2019/4/30
 */
public class GraphServiceImpl implements GraphService {
    Driver driver;

    public GraphServiceImpl(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void execute(String clause) {
        try (Session session = driver.session()) {
            session.writeTransaction((t)->t.run(clause));
        }
    }

    @Override
    public StatementResult query(String clause) {
        try (Session session = driver.session()) {
            return session.readTransaction((t)->t.run(clause));
        }
    }

    @Override
    public void createNode(String labels, String properties) {
        execute(String.format("CREATE (node:%s %s)", labels, properties));
    }

    @Override
    public void deleteNode(String labels) {
        execute(String.format("MATCH (a:%s)-[r]-(n) delete r", labels)); // delete all relationship of matched nodes
        execute(String.format("MATCH (n:%s) delete (n)", labels));
    }

    @Override
    public void createRelation(String node1, String node2, String relation) {
        execute(String.format("MATCH (a:%s), (b:%s) CREATE (a)-[r:%s]->(b)", node1, node2, relation));
    }
}
