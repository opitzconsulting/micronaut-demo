/*package com.opitzconsulting.demo.test.micronaut;

import com.opitzconsulting.demo.micronaut.genre.TechnologyRepository;
import com.sun.istack.NotNull;
import io.micronaut.test.annotation.MicronautTest;
import io.micronaut.test.annotation.MockBean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import javax.inject.Inject;

import static org.mockito.Mockito.*;

@MicronautTest
public class TechnologyRepositoryTest {

    @Inject
    TechnologyRepository technologyRepository;

    @ParameterizedTest
    @CsvSource({"1","testName","test","test","1","1","1","1","www.google.com","testTag"})
    void testComputeNumToSquare(@NotNull Integer id, String name, String description, Integer relevance,
                                Integer recommendation, Integer complexity, String url, String tags) {

        when(technologyRepository.update(id,name, description, relevance, recommendation, complexity, url, tags))
                .then(invocation -> Long.valueOf(technologyRepository().update(id,name, description, relevance, recommendation, complexity, url, tags)).intValue());

        final Integer result = technologyRepository.update(id,name, description, relevance, recommendation, complexity, url, tags);

        Assertions.assertEquals(
                result,
                -1
        );
        verify(technologyRepository).update(id,name, description, relevance, recommendation, complexity, url, tags);
    }

    @MockBean(TechnologyRepository.class)
    TechnologyRepository technologyRepository() {
        return mock(TechnologyRepository.class);
    }

}*/