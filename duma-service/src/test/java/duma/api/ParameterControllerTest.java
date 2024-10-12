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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithUserDetails;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class ParameterControllerTest {

    @Mock
    ParameterRepository repository;

    @Spy // mock it partially
    @InjectMocks
    @Autowired
    /*@MockBean*/
    StandartParameterService service;



    @Test
    @WithUserDetails("admin")
    public void testParameterId() throws Exception{

        Mockito.when(service.getParameterById(1L).id).thenReturn(getParameterId(1l).id);
    }

    private Parameter getParameterId(long id){
        Parameter parameter = new Parameter();
        parameter.setId(id);

        return parameter;
    }
}
