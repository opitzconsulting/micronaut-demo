package com.opitzconsulting.demo.micronaut;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import com.opitzconsulting.demo.micronaut.genre.TagInsertCommand;
import com.opitzconsulting.demo.micronaut.genre.TagsRepository;
import com.opitzconsulting.demo.micronaut.genre.TechnologyInsertCommand;
import com.opitzconsulting.demo.micronaut.genre.TechnologyRepository;
import com.opitzconsulting.demo.micronaut.model.Tags;
import com.opitzconsulting.demo.micronaut.model.Technology;

import javax.swing.text.html.HTML;
import javax.validation.Valid;
import java.net.URI;

@Controller
public class TagsController {
    protected final TagsRepository tagsRepository;

    public TagsController(TagsRepository tagsRepository) {

        this.tagsRepository = tagsRepository;
    }

    @Get("/message")
    public String message() {
        return "welcome to micronaut's controller";
    }

    @Get("/tags/{id}")
    public Tags getTag(@PathVariable int id) {
        return tagsRepository.getTag(id).orElse(null);
    }


    @Post("/tags")
    public HttpResponse insertTag(@Body @Valid TagInsertCommand tagInsertCommand) {

        Tags tag1=tagsRepository.insertTag(tagInsertCommand.getTag());
        return HttpResponse
                .created(tag1)
                .headers(headers -> headers.location(location(tag1.getId())));
    }
    protected URI location(int id) {
        return URI.create("/hello/" + id);
    }

    protected URI location(Technology technology) {
        return location(technology.getId());
}
}
