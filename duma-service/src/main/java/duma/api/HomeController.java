package duma.api;

import duma.services.StandartParameterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "index";
    }

    @GetMapping(path = "/formParameter")
    public String formParameter(){
        return "parameterForm";
    }

    @GetMapping(path = "/vue")
    public String vue(){
        return "vueTest";
    }
}
