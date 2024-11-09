package duma.api;


import duma.model.Parameter;
import duma.repository.ParameterRepository;
import duma.services.StandartParameterService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class InjectMocksInParameterControllerTest {

    private WebApplicationContext context;

    private MockMvc mvc;


    public InjectMocksInParameterControllerTest(WebApplicationContext context) {
        this.context = context;
        this.mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }


    @Mock
    ParameterRepository repository;

    @Spy // mock it partially
    @InjectMocks
    @Autowired
    /*@MockBean*/
    StandartParameterService service;



    @Test
    @WithUserDetails("admin")
    public void MockitoParameterId() throws Exception{

        Mockito.when(service.getParameterById(1L).id).thenReturn(getParameterId(1l).id);
    }

    @Test
    @WithUserDetails("admin")
    public void jsonRequestOnCountValues() throws Exception {
        mvc.perform(get("/parameter").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }


    private Parameter getParameterId(long id){
        Parameter parameter = new Parameter();
        parameter.setId(id);

        return parameter;
    }
}
