package duma.su.api;

import duma.su.model.Parameter;
import duma.su.services.StandartParameterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

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
    public RedirectView Create(RedirectAttributes attributes){
        Parameter parameter = services.createParameter("modbus #3");
        log.info("create #" + parameter.getId());
        return new RedirectView("/home/index");
    }

    /*@GetMapping("/redirectWithRedirectView")
    public RedirectView redirectWithUsingRedirectView(
            RedirectAttributes attributes) {
        attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
        attributes.addAttribute("attribute", "redirectWithRedirectView");
        return new RedirectView("redirectedUrl");
    }*/

}
