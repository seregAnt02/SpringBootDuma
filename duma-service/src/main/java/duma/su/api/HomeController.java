package duma.su.api;

import duma.su.model.Parameter;
import duma.su.services.StandartParameterService;
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
    private final StandartParameterService services;

    public HomeController(StandartParameterService services) {
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
    public String index(Model model){
        /*List<Parameter> parameter = this.services.getAllParameter();
        model.addAttribute("Models", parameter);*/
        return "index";
    }

    @GetMapping(path = "/vue")
    public String vue(){
        return "vueTest";
    }
}
