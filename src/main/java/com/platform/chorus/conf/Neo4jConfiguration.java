package com.platform.chorus.conf;

import com.platform.chorus.neo4j.GraphService;
import com.platform.chorus.neo4j.GraphServiceImpl;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Create by A.T on 2019/4/30
 */
@Configuration
public class Neo4jConfiguration {
    @Value("${server.neo4j.url}")
    String url;

    @Value("${server.neo4j.username}")
    String username;

    @Value("${server.neo4j.password}")
    String password;

    @Bean
    GraphService getGraphService() {
        Driver driver = GraphDatabase.driver(url, AuthTokens.basic(username, password));
        return new GraphServiceImpl(driver);
    }
}
