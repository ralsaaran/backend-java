package com.ralsaaran.backendJava.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private RestAuthenticationEntryPoint entryPoint;

  @Value("admin.username")
  private String username;

  @Value("admin.password")
  private String password;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().withUser(username).password(password).authorities("ROOT");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.antMatcher("/seatrip/**")
            .csrf().disable()
            .authorizeRequests().anyRequest().authenticated().and()
            .httpBasic().authenticationEntryPoint(entryPoint);
  }
//
//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    http.antMatcher("/appointment/**").csrf().disable().authorizeRequests()
//            .antMatchers("/teacher/all/**").permitAll()
//            .antMatchers("/teacher/admin/**","*/create/**").hasRole("ADMIN")
//            .antMatchers("/teacher/user/**").hasRole("USER")
//            .and().httpBasic();
//  }

}