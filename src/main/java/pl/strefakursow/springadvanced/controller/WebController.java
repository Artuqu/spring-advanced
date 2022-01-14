package pl.strefakursow.springadvanced.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.strefakursow.springadvanced.event.UserPanelPublisher;
import pl.strefakursow.springadvanced.profile.ProfileBean;

@Controller
public class WebController {

    UserPanelPublisher userPanelPublisher;
    private String greetings;
    ProfileBean profileBean;

    @Autowired
    WebController(UserPanelPublisher userPanelPublisher, @Value("${user.panel.greetings}") String greetings, ProfileBean profileBean) {
        this.userPanelPublisher = userPanelPublisher;
        this.greetings = greetings;
        this.profileBean = profileBean;
    }

    @GetMapping("/user_panel")
    public ModelAndView userPanel(ModelAndView mav) {
        mav.setViewName("userPanel");
//        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        userPanelPublisher.publish(principal.getUsername());
        mav.addObject("greetings", greetings);
        System.out.println(profileBean.showMessage());
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
