package pl.strefakursow.springadvanced.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.strefakursow.springadvanced.entity.User;
import pl.strefakursow.springadvanced.repository.UserRepository;

import java.util.Optional;
@Service
public class JpaUserDetailsService implements UserDetailsService {

    UserRepository userRepository;

    @Autowired
    JpaUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> usernameOptional = userRepository.findByUsername(username);
        if (!usernameOptional.isPresent()) {
            throw new UsernameNotFoundException("Username " + username + " does not exist!");
        }
        return usernameOptional.get();
    }
}
