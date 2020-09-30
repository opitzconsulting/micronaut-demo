package com.opitzconsulting.demo.micronaut;

import com.opitzconsulting.demo.micronaut.genre.TechnologyRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

class TechnologyControllerTest {

    static TechnologyController technologyController;

    @Test
    void message() {
        String request = technologyController.message();

        assertNotNull(request);
        assertEquals("Hello World using micronaut", request);

    }
    @BeforeAll
    static void test(){
        technologyController=new TechnologyController(Mockito.mock(TechnologyRepository.class));

    }


}
