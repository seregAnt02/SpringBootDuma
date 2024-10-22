package duma.api;

import duma.model.Parameter;
import duma.services.StandartParameterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/parameter")
public class RestApiController {
    @Autowired
    private final StandartParameterService services;

    public RestApiController(StandartParameterService services) {
        this.services = services;
    }


    @GetMapping(path = "/{id}")
    public Parameter ParameterId(@PathVariable long id){
        return services.getParameterById(id);
    }


    @GetMapping
    public List<Parameter> getAllParameters(){
        return services.getAll();
    }

    @GetMapping(path = "/create")
    public RedirectView create(RedirectAttributes attributes){
        Parameter parameter = services.add("modbus #3");
        log.info("create #" + parameter.getId());
        return new RedirectView("/home/index");
    }

    @PostMapping(path = "/edit")
    public RedirectView edit(@RequestBody Parameter parameter){
        //Parameter parameter = services.getParameterById(id);
        if(parameter != null) services.update(parameter);
        return new RedirectView("/home/index");
    }

    @DeleteMapping(path = "/{id}")
    public RedirectView deleteParameter(@PathVariable long id){
        Parameter parameter = this.services.deleteParameter(id);
        if(parameter != null){
            log.info("Удаление параметра:" + id);
        }
        return new RedirectView("/home/index");
    }

}
