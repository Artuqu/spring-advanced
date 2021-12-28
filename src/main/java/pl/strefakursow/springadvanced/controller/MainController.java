package pl.strefakursow.springadvanced.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.strefakursow.springadvanced.entity.Item;
import pl.strefakursow.springadvanced.service.impl.JpaAdvancedImplementation;

import javax.servlet.http.HttpServletResponse;

@RestController
public class MainController {

    @Autowired
   JpaAdvancedImplementation jai;

    @GetMapping("/")
    public String home(HttpServletResponse response){
        response.addHeader("Spring", "is awesome");
        Item item = new Item();
        item.setName("Orzechy");
        item.setPrice(22.2);
        jai.saveItem(item);
        return "First page";
    }
}
