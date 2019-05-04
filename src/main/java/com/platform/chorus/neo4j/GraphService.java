package com.platform.chorus.neo4j;

import org.neo4j.driver.v1.StatementResult;

/**
 * Create by A.T on 2019/4/30
 */
public interface GraphService {
    void execute(String clause);
    StatementResult query(String clause);
    void createNode(String labels, String properties);
    void deleteNode(String labels);
    void createRelation(String node1, String node2, String relation);
    void clear();
}
