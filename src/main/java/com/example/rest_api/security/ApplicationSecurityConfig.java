package com.example.rest_api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.example.rest_api.security.ApplicationUserRole.ADMIN;
import static com.example.rest_api.security.ApplicationUserRole.CLIENT;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public  ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails ruslan = User.builder()
                .username("ruslan")
                .password(passwordEncoder.encode("P@$$w0rd"))
                .roles(ADMIN.name())
                .build();

        UserDetails linda = User.builder()
                .username("linda")
                .password(passwordEncoder.encode("password"))
                .roles(CLIENT.name())
                .build();

        return new InMemoryUserDetailsManager(ruslan, linda);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
               .authorizeRequests()
               .antMatchers(HttpMethod.POST, "/api/v1/clients")
               .hasRole(ADMIN.name())
               .anyRequest()
               .authenticated()
               .and()
               .httpBasic()
               .and()
               .csrf()
               .disable();
    }
}
