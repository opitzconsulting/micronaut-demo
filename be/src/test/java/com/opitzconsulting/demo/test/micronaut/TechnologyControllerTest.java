package com.opitzconsulting.demo.test.micronaut;

import com.opitzconsulting.demo.micronaut.model.Technology;
import io.micronaut.context.ApplicationContext;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import java.net.http.HttpClient;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@MicronautTest
public class TechnologyControllerTest {

    private static EmbeddedServer server;
    private static HttpClient client;

    @BeforeClass
    public static void setupServer() {
        server = ApplicationContext.run(EmbeddedServer.class);
        client = server .getApplicationContext() .createBean(HttpClient.class, server.getURL());
    }

    @AfterClass
    public static void stopServer() {
        if (server != null) {
            server.stop();
        }
        if (client != null) {
            client.stop();
        }
    }

    @Test
    public void retrieveBooks() {
        HttpRequest request = HttpRequest.GET("/technologies");
        List<Technology> technologies = client.toBlocking().retrieve(request, Argument.of(List.class, Technology.class));
        assertNotNull(technologies);
        assertEquals(1, technologies.size());
    }
}
