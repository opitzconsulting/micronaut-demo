package com.opitzconsulting.demo.micronaut.genre;
import com.opitzconsulting.demo.micronaut.model.Technology;
import com.sun.istack.NotNull;


import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

//Create an interface to define the high level operations exposed to the application:
public interface TechnologyRepository {

    Optional<Technology> getTechnology(@NotNull int id);

    Technology insertTechnology(@NotEmpty String name, String description, Integer relevance,
                                Integer recommendation, Integer complexity, String url, String tags);

    void removeTechnology(@NotNull int id) ;

    int update(@NotNull Integer id, String name, String description, Integer relevance,
               Integer recommendation, Integer complexity, String url, String tags);

    List<Technology> getTechnologies();

}
