/*
 * This file is generated by jOOQ.
*/
package com.platform.chorus.jooq.tables.records;


import com.platform.chorus.jooq.tables.Entity;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record10;
import org.jooq.Row10;
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
public class EntityRecord extends UpdatableRecordImpl<EntityRecord> implements Record10<Integer, String, String, String, Integer[], String[], Integer, Long, Long, String> {

    private static final long serialVersionUID = 1854268595;

    /**
     * Setter for <code>public.entity.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.entity.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.entity.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.entity.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.entity.type</code>.
     */
    public void setType(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.entity.type</code>.
     */
    public String getType() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.entity.creator</code>.
     */
    public void setCreator(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.entity.creator</code>.
     */
    public String getCreator() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.entity.associate</code>.
     */
    public void setAssociate(Integer... value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.entity.associate</code>.
     */
    public Integer[] getAssociate() {
        return (Integer[]) get(4);
    }

    /**
     * Setter for <code>public.entity.tags</code>.
     */
    public void setTags(String... value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.entity.tags</code>.
     */
    public String[] getTags() {
        return (String[]) get(5);
    }

    /**
     * Setter for <code>public.entity.grade</code>.
     */
    public void setGrade(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.entity.grade</code>.
     */
    public Integer getGrade() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>public.entity.create_time</code>.
     */
    public void setCreateTime(Long value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.entity.create_time</code>.
     */
    public Long getCreateTime() {
        return (Long) get(7);
    }

    /**
     * Setter for <code>public.entity.update_time</code>.
     */
    public void setUpdateTime(Long value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.entity.update_time</code>.
     */
    public Long getUpdateTime() {
        return (Long) get(8);
    }

    /**
     * Setter for <code>public.entity.description</code>.
     */
    public void setDescription(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.entity.description</code>.
     */
    public String getDescription() {
        return (String) get(9);
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
    // Record10 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row10<Integer, String, String, String, Integer[], String[], Integer, Long, Long, String> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row10<Integer, String, String, String, Integer[], String[], Integer, Long, Long, String> valuesRow() {
        return (Row10) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Entity.ENTITY.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Entity.ENTITY.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Entity.ENTITY.TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Entity.ENTITY.CREATOR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer[]> field5() {
        return Entity.ENTITY.ASSOCIATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String[]> field6() {
        return Entity.ENTITY.TAGS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return Entity.ENTITY.GRADE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field8() {
        return Entity.ENTITY.CREATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field9() {
        return Entity.ENTITY.UPDATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return Entity.ENTITY.DESCRIPTION;
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
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getCreator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer[] component5() {
        return getAssociate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] component6() {
        return getTags();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component7() {
        return getGrade();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component8() {
        return getCreateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component9() {
        return getUpdateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component10() {
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
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getCreator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer[] value5() {
        return getAssociate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] value6() {
        return getTags();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getGrade();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value8() {
        return getCreateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value9() {
        return getUpdateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityRecord value3(String value) {
        setType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityRecord value4(String value) {
        setCreator(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityRecord value5(Integer... value) {
        setAssociate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityRecord value6(String... value) {
        setTags(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityRecord value7(Integer value) {
        setGrade(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityRecord value8(Long value) {
        setCreateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityRecord value9(Long value) {
        setUpdateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityRecord value10(String value) {
        setDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityRecord values(Integer value1, String value2, String value3, String value4, Integer[] value5, String[] value6, Integer value7, Long value8, Long value9, String value10) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached EntityRecord
     */
    public EntityRecord() {
        super(Entity.ENTITY);
    }

    /**
     * Create a detached, initialised EntityRecord
     */
    public EntityRecord(Integer id, String name, String type, String creator, Integer[] associate, String[] tags, Integer grade, Long createTime, Long updateTime, String description) {
        super(Entity.ENTITY);

        set(0, id);
        set(1, name);
        set(2, type);
        set(3, creator);
        set(4, associate);
        set(5, tags);
        set(6, grade);
        set(7, createTime);
        set(8, updateTime);
        set(9, description);
    }
}
