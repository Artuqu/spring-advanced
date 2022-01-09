package pl.strefakursow.springadvanced.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

    @GetMapping("/user_panel")
    public ModelAndView userPanel(ModelAndView mav) {
        mav.setViewName("userPanel");
        return mav;
    }
    @GetMapping("/admin_panel")
    public ModelAndView adminPanel(ModelAndView mav) {
        mav.setViewName("adminPanel");
        return mav;
    }
    @GetMapping("/login")
    public ModelAndView login(ModelAndView mav) {
        mav.setViewName("login");
        return mav;
    }



}
