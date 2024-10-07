package duma.api;


import duma.model.Parameter;
import duma.repository.ParameterRepository;
//import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;
import java.util.Objects;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class RestApiControllerTest {

    @Autowired
     WebTestClient webTestClient;

    @Autowired
    ParameterRepository repository;


    @Test
    public void testParameterAll(){

        List<Parameter> expected = repository.findAll();

        List<Parameter> responseBody = webTestClient.get()
                .uri("/parameter")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(new ParameterizedTypeReference<List<Parameter>>(){})
                .returnResult()
                .getResponseBody();

                /*.exchange()
                .expectStatus().isOk()
                .expectBody(new ParameterizedTypeReference<List<Parameter>>(){})
                .returnResult()
                .getResponseBody();*/

        Assertions.assertEquals(expected.size(), responseBody.size());

        for (Parameter customerResponse : responseBody){
            boolean found = expected.stream()
                    .filter(it -> Objects.equals(it.getId(), customerResponse.getId()))
                    .anyMatch(it -> Objects.equals(it.getParameter(), customerResponse.getParameter()));
            Assertions.assertTrue(found);
        }
    }
}
