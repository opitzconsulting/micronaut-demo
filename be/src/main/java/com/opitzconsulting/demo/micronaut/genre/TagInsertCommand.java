package com.opitzconsulting.demo.micronaut.genre;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class TagInsertCommand {
    private Integer id;
    private  String tag;

    public TagInsertCommand() {
    }

    public TagInsertCommand(Integer id, String tag) {
        this.id = id;
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
}
