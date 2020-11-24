package com.opitzconsulting.demo.micronaut;


import com.opitzconsulting.demo.micronaut.genre.TechnologyInsertCommand;
import com.opitzconsulting.demo.micronaut.genre.TechnologyRepository;
import com.opitzconsulting.demo.micronaut.genre.TechnologyUpdateCommand;
import com.opitzconsulting.demo.micronaut.model.Technology;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@Controller("/")
public class TechnologyController {

    protected final TechnologyRepository technologyRepository;

    public TechnologyController(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    @Get("/message")
    @Produces(MediaType.TEXT_PLAIN)
    public String message() {
        return "Hello World using micronaut";
    }

    @Get("/technologies")
    public List<Technology> getTechnologies() {
        return technologyRepository.getTechnologies();
    }


    @Get("/technologies/{id}")
    public Technology getTechnology(@PathVariable int id) {
        return technologyRepository.getTechnology(id).orElse(null);
    }

    @Post("/technologies")
    public void insertTechnology(@Body @Valid TechnologyInsertCommand insertCommand) {
        Technology technology1=technologyRepository.insertTechnology(insertCommand.getName(),insertCommand.getDescription(),insertCommand.getRecommendation(),
                insertCommand.getRelevance(),insertCommand.getComplexity(), insertCommand.getUrl());

    }

    @Put("/technologies")
    public void updateTechnology(@Body @Valid TechnologyUpdateCommand updateCommand){

        technologyRepository.update(updateCommand.getId(), updateCommand.getName(),updateCommand.getDescription(),updateCommand.getRecommendation(),
                updateCommand.getRelevance(),updateCommand.getComplexity(), updateCommand.getUrl());

    }

    @Delete("/technologies/{id}")
    public void removeTechnology(@PathVariable int id) {
        technologyRepository.removeTechnology(id);
    }

    protected URI location(int id) {
        return URI.create("/hello/" + id);
    }


}

