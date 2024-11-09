package duma.api;


import duma.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.client.MockMvcWebTestClient;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class HomeControllerTest {

    private WebApplicationContext context;

    private MockMvc mvc;

    private WebTestClient webTestClient;

    public HomeControllerTest(WebApplicationContext context) {
        this.context = context;
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

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
    @WithUserDetails("admin")
    public void indexStatusOk() throws Exception{

        webTestClient.get()
                .uri("/home/index")
                .accept(MediaType.TEXT_HTML)
                .exchange()
                .expectStatus().isOk();

    }
}
