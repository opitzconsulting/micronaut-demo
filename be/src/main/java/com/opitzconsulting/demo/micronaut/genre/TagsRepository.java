package com.opitzconsulting.demo.micronaut.genre;

import com.sun.istack.NotNull;
import com.opitzconsulting.demo.micronaut.model.Tags;
import com.opitzconsulting.demo.micronaut.model.Technology;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

public interface TagsRepository {

    Optional<Tags> getTag(@NotNull int id);

    Tags insertTag(@NotEmpty String tag);


}
