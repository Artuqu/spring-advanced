package pl.strefakursow.springadvanced.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.strefakursow.springadvanced.entity.Item;
import pl.strefakursow.springadvanced.service.impl.JpaAdvancedImplementation;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    JpaAdvancedImplementation jai;

    @GetMapping("/")
    public List<Item> home(HttpServletResponse response) {

        return jai.getItemsWithQuantityOverTwenty();
    }
}
