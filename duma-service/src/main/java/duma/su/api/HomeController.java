package duma.su.api;

import duma.su.model.Dum;
import duma.su.model.Parameter;
import duma.su.services.StandartDumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping(path = "/home")
public class HomeController {
    @Autowired
    private final StandartDumService services;

    public HomeController(StandartDumService services) {
        this.services = services;
    }

    /*@GetMapping(path = "/dum")
    public String list(Model model){
        List<Dum> dum = this.services.getAllDum();
        model.addAttribute("items", dum);
        log.info("Список моделей" + dum);
        return "index";
    }*/

    @GetMapping(path = "/index")
    public String admin(Model model){
        Parameter parameter = this.services.createParameter();
        model.addAttribute("Model", parameter);
        return "index";
    }
}
