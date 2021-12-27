package pl.strefakursow.springadvanced.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class MainController {

    @GetMapping("/")
    public String home(HttpServletResponse response){
        response.addHeader("Spring", "is awesome");
        System.out.println("Home");
        return "First page";
    }
}
