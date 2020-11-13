package com.opitzconsulting.demo.micronaut.genre;

import com.opitzconsulting.demo.micronaut.model.Tags;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

public interface TagsRepository {

    Optional<Tags> getTag(int id);

    Tags insertTag(@NotEmpty String tag);

    List<Tags> getTags();
}
