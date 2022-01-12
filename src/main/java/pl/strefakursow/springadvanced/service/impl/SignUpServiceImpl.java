package pl.strefakursow.springadvanced.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.strefakursow.springadvanced.component.mailer.RandomStringFactory;
import pl.strefakursow.springadvanced.component.mailer.SignUpMailer;
import pl.strefakursow.springadvanced.entity.User;
import pl.strefakursow.springadvanced.repository.UserRepository;
import pl.strefakursow.springadvanced.service.SignUpService;

import java.util.Random;

@Service
public class SignUpServiceImpl implements SignUpService {

    public static final String THIS_ID_IS_ALREADY_IN_USE = "Can't sing up user. It already has set id. User ";
    public static final int TOKEN_LENGTH = 15;

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
        Assert.isNull(user.getIdUser(), THIS_ID_IS_ALREADY_IN_USE + user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        String token = RandomStringFactory.getRandomString(TOKEN_LENGTH);
        user.setConfirmationToken(token);
        signUpMailer.sendConfirmationLink(user.getEmail(), token);
        return userRepository.save(user);
    }
}
