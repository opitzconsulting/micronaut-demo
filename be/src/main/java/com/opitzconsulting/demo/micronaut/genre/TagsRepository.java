package com.opitzconsulting.demo.micronaut.genre;

import com.opitzconsulting.demo.micronaut.model.Tags;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public interface TagsRepository {

    Optional<Tags> getTag(@NotNull int id);

    Tags insertTag(@NotEmpty String tag);

    List<Tags> getTags();
}
