package com.opitzconsulting.demo.micronaut.genre;

import com.sun.istack.NotNull;
import com.opitzconsulting.demo.micronaut.model.Tags;
import com.opitzconsulting.demo.micronaut.model.Technology;

import javax.inject.Singleton;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;
@Singleton
public class TagsRepositoryImpl implements TagsRepository{
    public final TagMapper tagMapper;

    public TagsRepositoryImpl(TagMapper tagMapper) {
        this.tagMapper = tagMapper;
    }

    @Override
    public Optional<Tags> getTag(@NotNull int id) {
        return Optional.ofNullable(tagMapper.getTag(id));
    }

    @Override
    public Tags insertTag( String tag) {
        Tags tags1= new Tags(tag);
        tagMapper.insertTag(tags1);
        return tags1;
    }





}
