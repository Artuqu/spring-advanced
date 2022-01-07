package pl.strefakursow.springadvanced.service.impl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.strefakursow.springadvanced.entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class InMemoryUserDetailsServiceImpl implements UserDetailsService {

    public static final String USERNAME_CAN_T_BE_NULL = "Username can't be null!";
    public static final String USER_WITH_USERNAME_S_DOES_NOT_EXIST = "User with username %s does not exist!";
    private List<UserDetails> users;

    public InMemoryUserDetailsServiceImpl (){
        users = new ArrayList<UserDetails>();
        users.add(new User("user", "user", Arrays.asList("USER")));
        users.add(new User("foo", "bar", Arrays.asList("USER")));
        users.add(new User("admin", "admin", Arrays.asList("USER", "ADMIN")));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Assert.notNull(username, USERNAME_CAN_T_BE_NULL);
        Optional<UserDetails> first = users.stream().filter(u -> username.equals(u.getUsername())).findFirst();
        if(!first.isPresent()){
            throw new UsernameNotFoundException(String.format(USER_WITH_USERNAME_S_DOES_NOT_EXIST, username));
        }
        return first.get();
    }
}
