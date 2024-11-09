package duma.api;


import duma.model.Parameter;
import duma.repository.ParameterRepository;
//import org.junit.Test;
import duma.services.StandartParameterService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.client.MockMvcWebTestClient;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class RestApiControllerTest {

    private WebApplicationContext context;

    private MockMvc mvc;

    public RestApiControllerTest(WebApplicationContext context) {

        this.context = context;
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }
    //@Autowired
    private WebTestClient webTestClient;

    @Autowired
    private ParameterRepository repository;

    @Autowired
    private StandartParameterService service;


    @BeforeEach
    public void setup() {
        this.webTestClient = MockMvcWebTestClient.bindToApplicationContext(context)
                .apply(springSecurity())
                //.defaultRequest(get("/").with(csrf()))
                .configureClient()
                //.filter(basicAuthentication("admin", "pass"))
                .build();
    }


    @Test
    public void ParameterId() throws Exception{

        Optional<Parameter> parameter = repository.findById(1L);

        Assertions.assertTrue(parameter.get().id == 1);
    }


    @Test
    @WithUserDetails("admin")
    public void ParameterAll() throws Exception{

        /*this.webTestClient
                .get()
                .uri("/home/index")
                .exchange()
                .expectStatus().isOk();*/

        List<Parameter> expected = repository.findAll();

        List<Parameter> responseBody = webTestClient.get()
                .uri("/parameter")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(new ParameterizedTypeReference<List<Parameter>>(){})
                .returnResult()
                .getResponseBody();

        Assertions.assertEquals(expected.size(), responseBody.size());

        for (Parameter customerResponse : responseBody){
            boolean found = expected.stream()
                    .filter(it -> Objects.equals(it.getId(), customerResponse.getId()))
                    .anyMatch(it -> Objects.equals(it.getParameter(), customerResponse.getParameter()));
            Assertions.assertTrue(found);
        }
    }

}
