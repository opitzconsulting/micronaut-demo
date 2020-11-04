package com.opitzconsulting.demo.micronaut.genre;

import com.opitzconsulting.demo.micronaut.model.Technology;
import javax.inject.Singleton;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;
import javax.validation.constraints.NotNull;

@Singleton
public class TechnologyRepositoryImpl implements TechnologyRepository {

    public final TechnologyMapper technologyMapper;

    public TechnologyRepositoryImpl(TechnologyMapper technologyMapper) {

        this.technologyMapper = technologyMapper;
    }

    @Override
    public Optional<Technology> getTechnology(@NotNull int id) {
        return Optional.ofNullable(technologyMapper.getTechnology(id));
    }

    @Override
    public Technology insertTechnology(@NotEmpty String name, String description, Integer relevance, Integer recommendation, Integer complexity, String url,String tags) {
        Technology technology= new Technology(name,description,relevance,recommendation,complexity,url,tags);
        technologyMapper.insertTechnology(technology);
        return technology;
    }

    @Override
    public void removeTechnology(@NotNull int id) {
        getTechnology(id).ifPresent(technology ->technologyMapper.removeTechnology(id));
    }
    @Override
    public int update(@NotNull Integer id, String name, String description, Integer relevance, Integer recommendation, Integer complexity, String url,String tags) {
        Technology technology= new Technology(id,name,description,relevance,recommendation,complexity,url,tags);
        technologyMapper.update(id, name, description, relevance, recommendation, complexity, url, tags);
        return -1;
    }

    @Override
    public List<Technology> getTechnologies() {
        return technologyMapper.getTechnologies();
    }


}

