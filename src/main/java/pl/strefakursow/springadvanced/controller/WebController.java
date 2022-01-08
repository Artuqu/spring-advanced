package pl.strefakursow.springadvanced.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

    @GetMapping("/user_panel")
    public ModelAndView mav(ModelAndView mav) {
        mav.setViewName("userPanel");
        return mav;
    }
    @GetMapping("/login")
    public ModelAndView form(ModelAndView mav) {
        mav.setViewName("login");
        return mav;
    }



}
