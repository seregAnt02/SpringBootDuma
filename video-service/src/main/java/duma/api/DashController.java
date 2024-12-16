package main.java.duma.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/player")
public class DashController {

    @GetMapping("video")
    String dash(){
        return "dashPages/content";
    }
}
