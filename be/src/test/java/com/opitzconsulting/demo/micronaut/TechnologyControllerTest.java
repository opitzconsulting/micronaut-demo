package com.opitzconsulting.demo.micronaut;

import com.opitzconsulting.demo.micronaut.genre.TechnologyRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

class TechnologyControllerTest {

    static TechnologyController technologyController;

    @Test
    void message() {
        String request = technologyController.message();
        assertThat(request).isNotNull();
        assertThat(request).isEqualTo("Hello World using micronaut");

    }
    @BeforeAll
    static void test(){
        technologyController=new TechnologyController(Mockito.mock(TechnologyRepository.class));

    }


}
