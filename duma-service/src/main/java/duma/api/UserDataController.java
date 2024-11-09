package duma.api;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(path = "/video")
public class UserDataController {

    String Dash(){
        return "/video/dash";
    }

    String VideoDash(){
        return "/video/videoDash";
    }
}
