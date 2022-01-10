package pl.strefakursow.springadvanced.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.strefakursow.springadvanced.entity.User;
import pl.strefakursow.springadvanced.service.impl.SignUpServiceImpl;

@RestController
public class SignUpController {

    SignUpServiceImpl signUpService;

    @Autowired
    SignUpController(SignUpServiceImpl signUpService) {
        this.signUpService = signUpService;
    }

    @GetMapping("/api/test")
    public String apiTest() {
        return "Hello from api Test";
    }

    @PostMapping("/api/sign_up")
    public String signUp(String username, String password) {
        User userToSignUp = new User(username, password);
        signUpService.signUpUser(userToSignUp);
        return "Username " + username + " signed up";
    }
}
