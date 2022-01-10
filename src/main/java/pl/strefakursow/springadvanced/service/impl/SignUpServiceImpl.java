package pl.strefakursow.springadvanced.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.strefakursow.springadvanced.entity.User;
import pl.strefakursow.springadvanced.repository.UserRepository;
import pl.strefakursow.springadvanced.service.SignUpService;

@Service
public class SignUpServiceImpl implements SignUpService {

    UserRepository userRepository;
    public static final String THIS_ID_IS_ALREADY_IN_USE = "This id is already in use!";

    @Autowired
    SignUpServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User signUpUser(User user) {
        Assert.isNull(user.getIdUser(), "Can't sing up user. It already has set id. User " + user);
        return userRepository.save(user);
    }
}
