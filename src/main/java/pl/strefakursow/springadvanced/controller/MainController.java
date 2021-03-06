package pl.strefakursow.springadvanced.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.strefakursow.springadvanced.component.mailer.SignUpMailer;
import pl.strefakursow.springadvanced.entity.Item;
import pl.strefakursow.springadvanced.entity.User;
import pl.strefakursow.springadvanced.repository.UserRepository;
import pl.strefakursow.springadvanced.service.impl.JpaAdvancedImplementation;

import java.util.List;
import java.util.Optional;

@RestController
public class MainController {

    public static final int pageSize = 3;

    JpaAdvancedImplementation jai;
    SignUpMailer signUpMailer;
    UserRepository userRepository;

    @Autowired
    MainController(JpaAdvancedImplementation jai, SignUpMailer signUpMailer, UserRepository userRepository) {
        this.jai = jai;
        this.signUpMailer = signUpMailer;
        this.userRepository = userRepository;
    }

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

    @GetMapping("/main")
    public List<Item> main() {
        return jai.findByQuantity(20);
    }

    @GetMapping("/min")
//    public List<Item> min (){
//        return jai.findByQuantityBetween(4,30);
//    }
    public List<Item> min() {
        return jai.findByQuantityGreaterThanEqualOrderByQuantityDesc(5);
    }

    @GetMapping("/items")
    public List<Item> items(@RequestParam(defaultValue = "0") String page) {
        int currentPage = Integer.parseInt(page);
        PageRequest pageRequest = PageRequest.of(currentPage, pageSize);
        Page<Item> itemPages = jai.findAll(pageRequest);

        return itemPages.getContent();
    }

    @GetMapping("send")
    public String sendMail(String to, String subject, String text) {
        signUpMailer.sendMessage("springpoczta@gmail.com", "First mail", "Works properly!");
        return "Mail was sent";
    }

    @GetMapping("confirm_email")
    public String confirmEmail(@RequestParam(name = "token") String token) {
        Optional<User> optionalUser = userRepository.findByConfirmationToken(token);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setEnabled(true);
            userRepository.save(user);
            return "Your account has been activated.";
        } else {
            return "Given token does not exist.";
        }
    }
}

