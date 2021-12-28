package pl.strefakursow.springadvanced.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.strefakursow.springadvanced.entity.Item;
import pl.strefakursow.springadvanced.service.impl.JpaAdvancedImplementation;

import java.util.List;
import java.util.Optional;

@RestController
public class MainController {

    @Autowired
    JpaAdvancedImplementation jai;

    @GetMapping("/")
    public List<Item> home() {
        return jai.getItemsWithQuantityOverTwenty();
    }

    @GetMapping("/quantity")
    public List<Item> quantity(@RequestParam(name = "q") Optional<Integer> quantity) {
        int q = 50;
        if (quantity.isPresent()) {
            q = quantity.get();
        }
        return jai.getItemsWithQuantityOver(q);
    }

    @GetMapping("/name")
//    public List<Item> names(@RequestParam(name = "n") String name) {
//        return jai.getItemsWithNameLike(name);
    public List<Item> findNames() {
        String regex = "s%";
        return jai.getItemsWithNameLike(regex);
    }


}

