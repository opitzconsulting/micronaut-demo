package com.opitzconsulting.demo.micronaut.model;

import io.micronaut.core.annotation.Introspected;

//Domain
@Introspected
public class Technology {

    private Integer id;

    private  String name;

    private String description;

    private Integer relevance ;

    private Integer recommendation ;

    private Integer complexity;

    private String url;

    private String tags ;


    protected Technology(){

    }

    public Technology(String name, String description, Integer recommendation, Integer relevance, Integer complexity, String url, String tags){
        this.name = name;
        this.description = description;
        this.recommendation = recommendation;
        this.relevance = relevance;
        this.complexity = complexity;
        this.url = url;
        this.tags = tags;
    }

    public Technology(Integer id, String nameOfTechnology, String description, Integer recommendation, Integer relevance, Integer complexity, String url, String tags) {
        super();
        this.id = id;
        this.name = nameOfTechnology;
        this.description = description;
        this.recommendation = recommendation;
        this.relevance = relevance;
        this.complexity = complexity;
        this.url = url;
        this.tags = tags;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(Integer recommendation) {
        this.recommendation = recommendation;
    }

    public Integer getRelevance() {
        return relevance;
    }

    public void setRelevance(Integer relevance) {
        this.relevance = relevance;
    }

    public Integer getComplexity() {
        return complexity;
    }

    public void setComplexity(Integer complexity) {
        this.complexity = complexity;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }



    @Override
    public String toString() {
        return "Technology{" +
                "id=" + id +
                ", name='" + name +
                ", description=" + description +
                ", recommendation=" +recommendation+
                ", relevance=" + relevance +
                ", complexity=" + complexity +
                ", url=" + url +
                ", tags=" + tags +'}';
    }



}
