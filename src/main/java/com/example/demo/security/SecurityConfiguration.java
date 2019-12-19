package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import tools.Hash;

/**
 * Security configuration file.
 * @author Cedrick Pennec
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  /**
 *
 */
@Autowired
  UserDetailsService userDetailsService;

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  /**
   * Cors configuration.
 * @param http HttpSecurity
 */
@Override
  public void configure(final HttpSecurity http) throws Exception {
    http.cors().and()
      .antMatcher("/")
      .authorizeRequests()
      .anyRequest().authenticated()
      .and().formLogin()
      .and().logout()
      .and().csrf().disable();

  }

  /**
   * Security configuration.
 * @param auth AuthenticationManagerBuilder
 */
@Override
  protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(Hash.hash());
  }


  /**
   * Open routes for non authenticated user.
 * @param web WebSecurity
 */
@Override
  public void configure(final WebSecurity web) throws Exception {
    web.ignoring()
      .antMatchers(HttpMethod.OPTIONS, "/**")
      .antMatchers(HttpMethod.POST, "/api/v1/user")
      .antMatchers(HttpMethod.GET, "/api/v1/*/public**")
      .antMatchers(HttpMethod.GET, "/api/v1/*/public/**");
  }


  /**
   * Cors configuration
 * @return CorsFilter
 */
@Bean
  public CorsFilter corsFilter() {

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration config = new CorsConfiguration();
    config.setAllowCredentials(true);
    config.addAllowedOrigin("*");
    config.addAllowedHeader("*");
    config.addAllowedMethod("*");
    source.registerCorsConfiguration("/**", config);
    return new CorsFilter(source);
  }
}
