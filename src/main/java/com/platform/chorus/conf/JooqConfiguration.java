package com.platform.chorus.conf;

import com.platform.chorus.jooq.tables.daos.*;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Create by A.T on 2019/4/30
 */
@Configuration
public class JooqConfiguration {
    private org.jooq.Configuration configuration;

    @Autowired
    public JooqConfiguration(org.jooq.Configuration configuration) {
        this.configuration = configuration;
    }

    @Bean
    CollectorDao getCollectorDao() {
        return new CollectorDao(configuration);
    }

    @Bean
    ModelDao getModelDao() {
        return new ModelDao(configuration);
    }

    @Bean
    FieldDao getFieldDao() {
        return new FieldDao(configuration);
    }

    @Bean
    EntityDao getEntityDao() {
        return new EntityDao(configuration);
    }

    @Bean
    ValueDao getValueDao() {
        return new ValueDao(configuration);
    }

    @Bean
    RelationDao getRelationDao() {
        return new RelationDao(configuration);
    }
}
