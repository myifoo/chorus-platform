/*
 * This file is generated by jOOQ.
*/
package com.platform.chorus.jooq.tables.daos;


import com.platform.chorus.jooq.tables.Collector;
import com.platform.chorus.jooq.tables.records.CollectorRecord;

import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CollectorDao extends DAOImpl<CollectorRecord, com.platform.chorus.jooq.tables.pojos.Collector, Integer> {

    /**
     * Create a new CollectorDao without any configuration
     */
    public CollectorDao() {
        super(Collector.COLLECTOR, com.platform.chorus.jooq.tables.pojos.Collector.class);
    }

    /**
     * Create a new CollectorDao with an attached configuration
     */
    public CollectorDao(Configuration configuration) {
        super(Collector.COLLECTOR, com.platform.chorus.jooq.tables.pojos.Collector.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getId(com.platform.chorus.jooq.tables.pojos.Collector object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.platform.chorus.jooq.tables.pojos.Collector> fetchById(Integer... values) {
        return fetch(Collector.COLLECTOR.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.platform.chorus.jooq.tables.pojos.Collector fetchOneById(Integer value) {
        return fetchOne(Collector.COLLECTOR.ID, value);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<com.platform.chorus.jooq.tables.pojos.Collector> fetchByName(String... values) {
        return fetch(Collector.COLLECTOR.NAME, values);
    }

    /**
     * Fetch a unique record that has <code>name = value</code>
     */
    public com.platform.chorus.jooq.tables.pojos.Collector fetchOneByName(String value) {
        return fetchOne(Collector.COLLECTOR.NAME, value);
    }

    /**
     * Fetch records that have <code>result IN (values)</code>
     */
    public List<com.platform.chorus.jooq.tables.pojos.Collector> fetchByResult(String... values) {
        return fetch(Collector.COLLECTOR.RESULT, values);
    }

    /**
     * Fetch records that have <code>injects IN (values)</code>
     */
    public List<com.platform.chorus.jooq.tables.pojos.Collector> fetchByInjects(String[]... values) {
        return fetch(Collector.COLLECTOR.INJECTS, values);
    }

    /**
     * Fetch records that have <code>args IN (values)</code>
     */
    public List<com.platform.chorus.jooq.tables.pojos.Collector> fetchByArgs(String[]... values) {
        return fetch(Collector.COLLECTOR.ARGS, values);
    }

    /**
     * Fetch records that have <code>description IN (values)</code>
     */
    public List<com.platform.chorus.jooq.tables.pojos.Collector> fetchByDescription(String... values) {
        return fetch(Collector.COLLECTOR.DESCRIPTION, values);
    }
}
