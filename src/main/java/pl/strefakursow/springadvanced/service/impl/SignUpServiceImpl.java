package pl.strefakursow.springadvanced.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.strefakursow.springadvanced.component.mailer.SignUpMailer;
import pl.strefakursow.springadvanced.entity.User;
import pl.strefakursow.springadvanced.repository.UserRepository;
import pl.strefakursow.springadvanced.service.SignUpService;

@Service
public class SignUpServiceImpl implements SignUpService {

    public static final String THIS_ID_IS_ALREADY_IN_USE = "This id is already in use!";

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    SignUpMailer signUpMailer;

    @Autowired
    SignUpServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, SignUpMailer signUpMailer) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.signUpMailer = signUpMailer;
    }


    @Override
    public User signUpUser(User user) {
        Assert.isNull(user.getIdUser(), "Can't sing up user. It already has set id. User " + user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        signUpMailer.sendConfirmationLink(user.getEmail(),"212SS$$");
        return user;
//                userRepository.save(user);
    }

}
