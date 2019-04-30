/*
 * This file is generated by jOOQ.
*/
package com.platform.chorus.jooq.tables.daos;


import com.platform.chorus.jooq.tables.Field;
import com.platform.chorus.jooq.tables.records.FieldRecord;

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
public class FieldDao extends DAOImpl<FieldRecord, com.platform.chorus.jooq.tables.pojos.Field, Integer> {

    /**
     * Create a new FieldDao without any configuration
     */
    public FieldDao() {
        super(Field.FIELD, com.platform.chorus.jooq.tables.pojos.Field.class);
    }

    /**
     * Create a new FieldDao with an attached configuration
     */
    public FieldDao(Configuration configuration) {
        super(Field.FIELD, com.platform.chorus.jooq.tables.pojos.Field.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getId(com.platform.chorus.jooq.tables.pojos.Field object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.platform.chorus.jooq.tables.pojos.Field> fetchById(Integer... values) {
        return fetch(Field.FIELD.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.platform.chorus.jooq.tables.pojos.Field fetchOneById(Integer value) {
        return fetchOne(Field.FIELD.ID, value);
    }

    /**
     * Fetch records that have <code>owner IN (values)</code>
     */
    public List<com.platform.chorus.jooq.tables.pojos.Field> fetchByOwner(String... values) {
        return fetch(Field.FIELD.OWNER, values);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<com.platform.chorus.jooq.tables.pojos.Field> fetchByName(String... values) {
        return fetch(Field.FIELD.NAME, values);
    }

    /**
     * Fetch records that have <code>type IN (values)</code>
     */
    public List<com.platform.chorus.jooq.tables.pojos.Field> fetchByType(String... values) {
        return fetch(Field.FIELD.TYPE, values);
    }

    /**
     * Fetch records that have <code>label IN (values)</code>
     */
    public List<com.platform.chorus.jooq.tables.pojos.Field> fetchByLabel(String... values) {
        return fetch(Field.FIELD.LABEL, values);
    }

    /**
     * Fetch records that have <code>collector IN (values)</code>
     */
    public List<com.platform.chorus.jooq.tables.pojos.Field> fetchByCollector(String... values) {
        return fetch(Field.FIELD.COLLECTOR, values);
    }

    /**
     * Fetch records that have <code>relation IN (values)</code>
     */
    public List<com.platform.chorus.jooq.tables.pojos.Field> fetchByRelation(String... values) {
        return fetch(Field.FIELD.RELATION, values);
    }

    /**
     * Fetch records that have <code>constraints IN (values)</code>
     */
    public List<com.platform.chorus.jooq.tables.pojos.Field> fetchByConstraints(String... values) {
        return fetch(Field.FIELD.CONSTRAINTS, values);
    }

    /**
     * Fetch records that have <code>description IN (values)</code>
     */
    public List<com.platform.chorus.jooq.tables.pojos.Field> fetchByDescription(String... values) {
        return fetch(Field.FIELD.DESCRIPTION, values);
    }
}
