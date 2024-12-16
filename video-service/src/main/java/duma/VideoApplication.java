package main.java.duma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class VideoApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(VideoApplication.class, args);
        //System.out.println("Hello world");
    }
}
