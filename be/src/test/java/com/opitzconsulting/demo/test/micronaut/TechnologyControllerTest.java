package com.opitzconsulting.demo.test.micronaut;

import com.opitzconsulting.demo.micronaut.TechnologyController;
import com.opitzconsulting.demo.micronaut.genre.TechnologyRepository;
import com.opitzconsulting.demo.micronaut.model.Technology;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import io.micronaut.test.annotation.MockBean;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
public class TechnologyControllerTest {
    @Inject
    TechnologyController technologyController;
    @Inject
    Technology technology;
    @Inject
    TechnologyRepository technologyRepository;
    @Inject
    ObjectMapper mapper;


    Technology technology1;
    Technology technology2;
    String tech1JsonString;
    String tech2JsonString;
    String requestUri = "/technologies";

    @Inject
    @Client("/")
    RxHttpClient client;

    @Test
    public void testHello() {
        HttpRequest<String> request = HttpRequest.GET("/");
        String body = client.toBlocking().retrieve(request);

        assertNotNull(body);
        assertEquals("welcome to micronaut", body);
    }


    @Before
    void setup(){
        technology1=new Technology(1, "tech1",  "description",1,
                1, 1, "url","tags");
        technology2=new Technology(2, "tech2",  "description",1,
                1, 1, "url","tags");
        try {
            tech1JsonString=mapper.writeValueAsString(technology1);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            tech2JsonString=mapper.writeValueAsString(technology2);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
    @Test
    void findAllReturnsAllTechnologies(){
        //given
        // Mockito.when(technologyRepository.getTechnologies()).thenReturn( [technology1,technology2] );
        //Technology[] techArray= {technology1, technology2};
        //String response= Arrays.toString(techArray);
        //when
        // Properties properties = mock(Properties.class);
        //
        // then
        //        //Mockito.verify(technologyRepository).getTechnologies();

        when(technologyRepository.getTechnologies()).thenReturn((List<Technology>) Stream.of(new Technology(1, "tech1",  "description",1,
                1, 1, "url","tags"),new Technology(2, "tech2",  "description",1,
                1, 1, "url","tags")));
        assertEquals(2,technologyController.getTechnologies().size());

    }

    @Test
    void getTechnologyReturnsTechnology(){

    }
    @Test
    void deleteTechnology(){

    }
    @Test
    void updateTechnology(){

    }
    @Test
    void updateTechnologyFailsIfCustomerNotExist(){

    }



    @MockBean(TechnologyRepository.class)
    TechnologyRepository technologyRepository() {
        return mock(TechnologyRepository.class);
    }

}