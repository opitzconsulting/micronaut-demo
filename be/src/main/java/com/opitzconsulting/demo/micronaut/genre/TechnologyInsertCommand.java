package com.opitzconsulting.demo.micronaut.genre;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.core.annotation.Introspected;

import java.util.ArrayList;
import java.util.List;

@Introspected
public class TechnologyInsertCommand {

    private  String name;

    private String description;

    private Integer relevance ;

    private Integer recommendation ;

    private Integer complexity;

    private String url;

    private List<String> tags;

    public TechnologyInsertCommand(){
    }

    public TechnologyInsertCommand(String name, String description, Integer relevance,
                                   Integer recommendation, Integer complexity, String url, List<String> tags) {
        this.name = name;
        this.description = description;
        this.relevance = relevance;
        this.recommendation = recommendation;
        this.complexity = complexity;
        this.url = url;
        this.tags = tags;
    }

    public void setTags(List<String> tags) {
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

    public List<String> getTags() {
        ObjectMapper objectMapper=new ObjectMapper();
        tags=objectMapper.convertValue(tags, ArrayList.class);
        return tags;
    }


}
