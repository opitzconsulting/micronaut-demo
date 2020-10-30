package com.opitzconsulting.demo.micronaut.genre;

import com.opitzconsulting.demo.micronaut.model.Tag;
import com.opitzconsulting.demo.micronaut.model.Technology;

import javax.inject.Singleton;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;
import javax.validation.constraints.NotNull;

@Singleton
public class TagsRepositoryImpl implements TagsRepository{
    public final TagMapper tagMapper;

    public TagsRepositoryImpl(TagMapper tagMapper) {
        this.tagMapper = tagMapper;
    }

    @Override
    public Optional<Tag> getTag(@NotNull int id) {
        return Optional.ofNullable(tagMapper.getTag(id));
    }

    @Override
    public Tag insertTag( String tag) {
        Tag tags1= new Tag(tag);
        tagMapper.insertTag(tags1);
        return tags1;
    }





}
