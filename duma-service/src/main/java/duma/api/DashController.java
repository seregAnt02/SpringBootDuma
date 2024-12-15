package duma.api;

import duma.Application;
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
        /*String path = Application.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        log.info("path -> " + path);*/
        return "dashPages/content";
    }
}
