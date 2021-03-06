/*
 * This file is generated by jOOQ.
*/
package com.platform.chorus.jooq.tables.daos;


import com.platform.chorus.jooq.tables.Entity;
import com.platform.chorus.jooq.tables.records.EntityRecord;

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
public class EntityDao extends DAOImpl<EntityRecord, com.platform.chorus.jooq.tables.pojos.Entity, Integer> {

    /**
     * Create a new EntityDao without any configuration
     */
    public EntityDao() {
        super(Entity.ENTITY, com.platform.chorus.jooq.tables.pojos.Entity.class);
    }

    /**
     * Create a new EntityDao with an attached configuration
     */
    public EntityDao(Configuration configuration) {
        super(Entity.ENTITY, com.platform.chorus.jooq.tables.pojos.Entity.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getId(com.platform.chorus.jooq.tables.pojos.Entity object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.platform.chorus.jooq.tables.pojos.Entity> fetchById(Integer... values) {
        return fetch(Entity.ENTITY.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.platform.chorus.jooq.tables.pojos.Entity fetchOneById(Integer value) {
        return fetchOne(Entity.ENTITY.ID, value);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<com.platform.chorus.jooq.tables.pojos.Entity> fetchByName(String... values) {
        return fetch(Entity.ENTITY.NAME, values);
    }

    /**
     * Fetch records that have <code>type IN (values)</code>
     */
    public List<com.platform.chorus.jooq.tables.pojos.Entity> fetchByType(String... values) {
        return fetch(Entity.ENTITY.TYPE, values);
    }

    /**
     * Fetch records that have <code>creator IN (values)</code>
     */
    public List<com.platform.chorus.jooq.tables.pojos.Entity> fetchByCreator(String... values) {
        return fetch(Entity.ENTITY.CREATOR, values);
    }

    /**
     * Fetch records that have <code>associate IN (values)</code>
     */
    public List<com.platform.chorus.jooq.tables.pojos.Entity> fetchByAssociate(Integer[]... values) {
        return fetch(Entity.ENTITY.ASSOCIATE, values);
    }

    /**
     * Fetch records that have <code>tags IN (values)</code>
     */
    public List<com.platform.chorus.jooq.tables.pojos.Entity> fetchByTags(String[]... values) {
        return fetch(Entity.ENTITY.TAGS, values);
    }

    /**
     * Fetch records that have <code>grade IN (values)</code>
     */
    public List<com.platform.chorus.jooq.tables.pojos.Entity> fetchByGrade(Integer... values) {
        return fetch(Entity.ENTITY.GRADE, values);
    }

    /**
     * Fetch records that have <code>create_time IN (values)</code>
     */
    public List<com.platform.chorus.jooq.tables.pojos.Entity> fetchByCreateTime(Long... values) {
        return fetch(Entity.ENTITY.CREATE_TIME, values);
    }

    /**
     * Fetch records that have <code>update_time IN (values)</code>
     */
    public List<com.platform.chorus.jooq.tables.pojos.Entity> fetchByUpdateTime(Long... values) {
        return fetch(Entity.ENTITY.UPDATE_TIME, values);
    }

    /**
     * Fetch records that have <code>description IN (values)</code>
     */
    public List<com.platform.chorus.jooq.tables.pojos.Entity> fetchByDescription(String... values) {
        return fetch(Entity.ENTITY.DESCRIPTION, values);
    }
}
