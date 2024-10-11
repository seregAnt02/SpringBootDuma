package duma.api;


import duma.model.Parameter;
import duma.repository.ParameterRepository;
//import org.junit.Test;
import duma.services.StandartParameterService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
//@WebMvcTest
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
    @Autowired
     WebTestClient webTestClient;

    @Autowired
    ParameterRepository repository;

    @Autowired
    private StandartParameterService service;

    @Test
    public void testParameterId() throws Exception{

        //StandartParameterService mockDataService = Mockito.mock(StandartParameterService.class);
        Parameter model = service.getParameterById(1L);
        //Mockito.when(1).thenReturn(1);
        //Assertions.assertTrue(service.getParameterById(1L).id == getParameterId(1L).id);

        Optional<Parameter> parameter = repository.findById(1L);

        Assertions.assertTrue(parameter.get().id == 1);
    }

    @Test
    @WithUserDetails("admin")
    public void givenAuthRequestOnPrivateService_shouldSucceedWith200() throws Exception {
        mvc.perform(get("/parameter").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    @WithUserDetails("admin")
    //@WithMockUser(username = "admin")
    public void testParameterAll(){

        List<Parameter> expected = repository.findAll();

        List<Parameter> responseBody = webTestClient.get()
                .uri("/parameter")
                .accept(MediaType.APPLICATION_JSON)
                .exchange() // выполнение без тела запроса
                .expectStatus().isOk() // Утверждения о статусе ответа -> Подтвердите, что код статуса ответа — HttpStatus.OK (200).
                .expectBody(new ParameterizedTypeReference<List<Parameter>>(){})
                .returnResult() // Выйти из связанного API и вернуть ExchangeResult с декодированным содержимым ответа.
                .getResponseBody(); // Верните сущность, извлеченную из тела ответа.

        Assertions.assertEquals(expected.size(), responseBody.size());

        for (Parameter customerResponse : responseBody){
            boolean found = expected.stream()
                    .filter(it -> Objects.equals(it.getId(), customerResponse.getId()))
                    .anyMatch(it -> Objects.equals(it.getParameter(), customerResponse.getParameter()));
            Assertions.assertTrue(found);
        }
    }

}
