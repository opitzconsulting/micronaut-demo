package com.opitzconsulting.demo.micronaut.genre;


import io.micronaut.core.annotation.Introspected;

@Introspected
public class TechnologyInsertCommand {

    private  String name;

    private String description;

    private Integer relevance ;

    private Integer recommendation ;

    private Integer complexity;

    private String url;

    private String tags;


    public TechnologyInsertCommand(){
    }

    public TechnologyInsertCommand( String name, String description, Integer relevance,
                                    Integer recommendation, Integer complexity, String url, String tags) {
        this.name = name;
        this.description = description;
        this.relevance = relevance;
        this.recommendation = recommendation;
        this.complexity = complexity;
        this.url = url;
        this.tags = tags;
    }

    public String getName() {
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

    public Integer getRelevance() {
        return relevance;
    }

    public void setRelevance(Integer relevance) {
        this.relevance = relevance;
    }

    public Integer getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(Integer recommendation) {
        this.recommendation = recommendation;
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
}
