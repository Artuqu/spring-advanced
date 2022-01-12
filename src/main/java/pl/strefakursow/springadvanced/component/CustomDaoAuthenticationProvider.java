package pl.strefakursow.springadvanced.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import pl.strefakursow.springadvanced.service.impl.JpaUserDetailsService;

@Component
public class CustomDaoAuthenticationProvider implements AuthenticationProvider {

    public static final String USERNAME_CANNOT_BE_NULL = "Username cannot be null";
    public static final String CREDENTIALS_CANNOT_BE_NULL = "Credentials cannot be null!";
    public static final String WRONG_PASSWORD = "Wrong password!";

    PasswordEncoder passwordEncoder;
    JpaUserDetailsService jpaUserDetailsService;

    @Autowired
    CustomDaoAuthenticationProvider(JpaUserDetailsService jpaUserDetailsService, PasswordEncoder passwordEncoder) {
        this.jpaUserDetailsService = jpaUserDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        Object credentials = authentication.getCredentials();

        Assert.notNull(name, USERNAME_CANNOT_BE_NULL);
        Assert.notNull(credentials, CREDENTIALS_CANNOT_BE_NULL);

        if (!(credentials instanceof String)) {
            return null;
        }
        String password = credentials.toString();
        UserDetails loadUserByUsername = jpaUserDetailsService.loadUserByUsername(name);
        String getPassword = loadUserByUsername.getPassword();

        if (!passwordEncoder.matches(password, getPassword)) {
            throw new BadCredentialsException(WRONG_PASSWORD);
        }
        return new UsernamePasswordAuthenticationToken(name, password, loadUserByUsername.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
