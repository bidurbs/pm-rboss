/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.rbossf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;

//@Configuration
//@EnableWebMvcSecurity
//@ComponentScan("com.mycompany.rbossf")
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
//@Autowired
private PasswordEncoder passwordEncoder;
    
    
    
    
    
    
    
    
    
   // @Bean
    public BCryptPasswordEncoder getpasswordEncoder(){    
        return new BCryptPasswordEncoder();
    }
}
