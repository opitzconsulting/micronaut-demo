package com.opitzconsulting.demo.micronaut.genre;

import com.opitzconsulting.demo.micronaut.model.Tag;
import java.util.Optional;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public interface TagsRepository {

    Optional<Tag> getTag(@NotNull int id);

    Tag insertTag(@NotEmpty String tag);


}
