/*
 * This file is generated by jOOQ.
*/
package com.platform.chorus.jooq.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


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
public class Relation implements Serializable {

    private static final long serialVersionUID = -1175062733;

    private Integer id;
    private String  name;
    private String  creator;
    private String  description;

    public Relation() {}

    public Relation(Relation value) {
        this.id = value.id;
        this.name = value.name;
        this.creator = value.creator;
        this.description = value.description;
    }

    public Relation(
        Integer id,
        String  name,
        String  creator,
        String  description
    ) {
        this.id = id;
        this.name = name;
        this.creator = creator;
        this.description = description;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return this.creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Relation (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(creator);
        sb.append(", ").append(description);

        sb.append(")");
        return sb.toString();
    }
}
