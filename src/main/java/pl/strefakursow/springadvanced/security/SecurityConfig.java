package pl.strefakursow.springadvanced.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import pl.strefakursow.springadvanced.component.CustomDaoAuthenticationProvider;
import pl.strefakursow.springadvanced.service.impl.JpaUserDetailsService;

@Configuration
@EnableWebSecurity(debug = false)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    JpaUserDetailsService jpaUserDetailsService;
    CustomDaoAuthenticationProvider customDaoAuthenticationProvider;

    @Autowired
    SecurityConfig(JpaUserDetailsService jpaUserDetailsService, CustomDaoAuthenticationProvider customDaoAuthenticationProvider) {
        this.jpaUserDetailsService = jpaUserDetailsService;
        this.customDaoAuthenticationProvider = customDaoAuthenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jpaUserDetailsService);
        auth.authenticationProvider(customDaoAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/admin_panel").hasAuthority("ADMIN")
                .antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/user_panel", true);

    }
}
