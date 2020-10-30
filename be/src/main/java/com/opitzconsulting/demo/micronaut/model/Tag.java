package com.opitzconsulting.demo.micronaut.model;

import io.micronaut.core.annotation.Introspected;


@Introspected
public class Tag {
    private Integer id;
    private String tag;

    public Tag() {
    }

    public Tag(String tag) {
        this.tag = tag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id + "tag=" + tag +'}';
    }



}