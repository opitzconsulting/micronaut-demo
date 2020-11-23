package com.opitzconsulting.demo.micronaut.genre;


import io.micronaut.core.annotation.Introspected;

import javax.validation.constraints.NotNull;

@Introspected
public class TechnologyUpdateCommand {
    @NotNull
    private Integer id;

    private  String name;

    private String description;

    private Integer relevance ;

    private Integer recommendation ;

    private Integer complexity;

    private String url;


    public TechnologyUpdateCommand() {
    }

    public TechnologyUpdateCommand(@NotNull Integer id, String name, String description,
                                   Integer relevance, Integer recommendation, Integer complexity, String url) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.relevance = relevance;
        this.recommendation = recommendation;
        this.complexity = complexity;
        this.url = url;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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


}
