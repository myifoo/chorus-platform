/*
 * This file is generated by jOOQ.
*/
package com.platform.chorus.jooq.tables.records;


import com.platform.chorus.jooq.tables.Model;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


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
public class ModelRecord extends UpdatableRecordImpl<ModelRecord> implements Record6<Integer, String, String, String, String, String> {

    private static final long serialVersionUID = -2050550764;

    /**
     * Setter for <code>public.model.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.model.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.model.domain</code>.
     */
    public void setDomain(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.model.domain</code>.
     */
    public String getDomain() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.model.name</code>.
     */
    public void setName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.model.name</code>.
     */
    public String getName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.model.extend</code>.
     */
    public void setExtend(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.model.extend</code>.
     */
    public String getExtend() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.model.label</code>.
     */
    public void setLabel(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.model.label</code>.
     */
    public String getLabel() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.model.description</code>.
     */
    public void setDescription(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.model.description</code>.
     */
    public String getDescription() {
        return (String) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Integer, String, String, String, String, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Integer, String, String, String, String, String> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Model.MODEL.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Model.MODEL.DOMAIN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Model.MODEL.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Model.MODEL.EXTEND;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Model.MODEL.LABEL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Model.MODEL.DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getDomain();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getExtend();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getLabel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getDomain();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getExtend();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getLabel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelRecord value2(String value) {
        setDomain(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelRecord value3(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelRecord value4(String value) {
        setExtend(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelRecord value5(String value) {
        setLabel(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelRecord value6(String value) {
        setDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelRecord values(Integer value1, String value2, String value3, String value4, String value5, String value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ModelRecord
     */
    public ModelRecord() {
        super(Model.MODEL);
    }

    /**
     * Create a detached, initialised ModelRecord
     */
    public ModelRecord(Integer id, String domain, String name, String extend, String label, String description) {
        super(Model.MODEL);

        set(0, id);
        set(1, domain);
        set(2, name);
        set(3, extend);
        set(4, label);
        set(5, description);
    }
}
