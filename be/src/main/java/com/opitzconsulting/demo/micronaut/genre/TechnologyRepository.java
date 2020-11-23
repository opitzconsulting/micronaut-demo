package com.opitzconsulting.demo.micronaut.genre;

import com.opitzconsulting.demo.micronaut.model.Technology;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

//Create an interface to define the high level operations exposed to the application:
public interface TechnologyRepository {

    Optional<Technology> getTechnology(@NotNull int id);

    Technology insertTechnology(@NotEmpty String name, String description, Integer relevance,
                                Integer recommendation, Integer complexity, String url);

    void removeTechnology(@NotNull int id) ;

    int update(@NotNull Integer id, String name, String description, Integer relevance,
               Integer recommendation, Integer complexity, String url);

    List<Technology> getTechnologies();

}
