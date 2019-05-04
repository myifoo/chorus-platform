package com.platform.chorus.web.model;

import com.platform.chorus.jooq.tables.pojos.Collector;
import com.platform.chorus.jooq.tables.pojos.Field;
import com.platform.chorus.jooq.tables.pojos.Model;

import java.util.List;

/**
 * Create by A.T on 2019/4/30
 */
public class MetaModel {
    private List<Model> models = null;
    private List<Collector> collectors = null;
    private List<Field> fields = null;

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }

    public List<Collector> getCollectors() {
        return collectors;
    }

    public void setCollectors(List<Collector> collectors) {
        this.collectors = collectors;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }
}
