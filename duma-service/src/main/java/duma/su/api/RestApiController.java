package duma.su.api;

import duma.su.model.Parameter;
import duma.su.services.StandartParameterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/parameter")
public class RestApiController {
    @Autowired
    private final StandartParameterService services;

    public RestApiController(StandartParameterService services) {
        this.services = services;
    }

    @GetMapping(path = "/create")
    public void Create(){

    }

}
