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
    protected final StandartParameterService services;

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

    @GetMapping(path = "/coordinate-page")
    public String getCoordinate(){ return "homePages/coordinate"; }

    @GetMapping(path = "/price-page")
    public String getPrice(){ return "homePages/price"; }

    @GetMapping(path = "/company-page")
    public String getCompanyPage(){return "homePages/company"; }

    @GetMapping(path = "/services-page")
    public String getServicesPage(){ return "homePages/service"; }

    @GetMapping(path = "/start-page")
    public String startPage(){
        return "homePages/startPage";
    }

    @GetMapping(path = "/index")
    public String index(Model model){
        return "homePages/index";
    }

    @GetMapping(path = "/formParameter")
    public String getFormParameter(){
        return "parameterForm";
    }

    @GetMapping(path = "/layOut")
    public String getLayOut(){
        return "homePages/layOut";
    }
}
