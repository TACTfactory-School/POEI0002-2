package com.example.demo.security;

import com.example.demo.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()

                //.headers().frameOptions().disable().and()
        .antMatcher("/*").anonymous().and()
        .antMatcher("/api/**").authorizeRequests().and().httpBasic();

        // Les points accessibles à tout le monde
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/v1/user").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/event").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/user").permitAll()
                // Disallow everything else..
                ;//.anyRequest().authenticated();
        super.configure(http);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl);
        super.configure(auth);
    }

}
