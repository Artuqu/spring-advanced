package pl.strefakursow.springadvanced.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.strefakursow.springadvanced.entity.User;
import pl.strefakursow.springadvanced.service.impl.SignUpServiceImpl;

@Controller
public class SignUpController {

    SignUpServiceImpl signUpService;

    @Autowired
    SignUpController(SignUpServiceImpl signUpService) {
        this.signUpService = signUpService;
    }


    @GetMapping("/sign_up")
    public ModelAndView signUp(ModelAndView mav) {
        mav.setViewName("signUp");
        return mav;
    }

    @PostMapping("/sign_up")
    public ModelAndView singUpPost(ModelAndView mav, User user) {
        mav.setViewName("redirect:/login");
        mav.addObject(signUpService.signUpUser(user));
        return mav;
    }
}
