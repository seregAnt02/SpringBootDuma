package duma.api;

import duma.model.User;
import duma.services.StandartAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String allUsers(Model model){
        List<User> user = service.getUserAll();
        model.addAttribute("items", user);
        return "accountPages/allUser";
    }

    /*@GetMapping(path = "/register")
    public String registerUser(){
        return "accountPages/registerUser";
    }*/

    @PostMapping
    public String addUser(@RequestBody User user){
        this.service.registerUser(user);
        return "accountPages/allUser";
    }
}
