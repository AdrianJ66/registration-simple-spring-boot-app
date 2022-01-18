package com.demo.application.registrationsimplewebapp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}test").roles("ADMIN");
    }

    protected void configure(HttpSecurity security) throws Exception {
        security.httpBasic().and().authorizeRequests()
                .anyRequest()
                .permitAll()
                .and()
                .csrf()
                .disable()
                .formLogin();

        security.headers()
                .frameOptions()
                .disable();
    }
}
