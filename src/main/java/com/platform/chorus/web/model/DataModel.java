package com.platform.chorus.web.model;

import java.util.List;

/**
 * Create by A.T on 2019/5/1
 */
public class DataModel {
    private String    name;
    private String    type;
    private String[]  tags;
    private String    creator;
    private Integer   grade;
    private String    description;
    private Integer[] associate;
    private List<String[]> values;
    private List<DataModel> refs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer[] getAssociate() {
        return associate;
    }

    public void setAssociate(Integer[] associate) {
        this.associate = associate;
    }

    public List<String[]> getValues() {
        return values;
    }

    public void setValues(List<String[]> values) {
        this.values = values;
    }

    public List<DataModel> getRefs() {
        return refs;
    }

    public void setRefs(List<DataModel> refs) {
        this.refs = refs;
    }
}
