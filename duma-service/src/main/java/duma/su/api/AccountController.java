package duma.su.api;

import duma.su.model.User;
import duma.su.services.StandartAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping(path = "/account")
public class AccountController {


    @Autowired
    private final StandartAccountService service;

    public AccountController(StandartAccountService service) {
        this.service = service;
    }

    @GetMapping(path = "/all")
    public String userAll(Model model){
        List<User> user = service.getUserAll();
        model.addAttribute("items", user);
        return "allUser";
    }

    @GetMapping(path = "/register")
    public String registerUser(){
        return "registerUser";
    }

    @PostMapping
    public String registerUserPost(@RequestBody User user){
        this.service.registerUser(user);
        return "allUser";
    }
}
