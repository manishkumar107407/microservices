package com.example.authserver.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.authserver.services.MyUserDetailsService;

 

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class MySecuirtyConfi 
{	
	 
	
    @Bean
	PasswordEncoder passwordEncoder()
	{
	return new BCryptPasswordEncoder();	
	}
    
    @Bean
    UserDetailsService userDetails()
    {
    return  new MyUserDetailsService();	
    }

    @Bean  			
    AuthenticationProvider  authenticationProvider()
    {
  	  DaoAuthenticationProvider  authenticationProvider=new DaoAuthenticationProvider();
  	  authenticationProvider.setUserDetailsService(userDetails());
  	  authenticationProvider.setPasswordEncoder(passwordEncoder());
  	  return authenticationProvider;	  
    }
    
    
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception
    {
  	return authenticationConfiguration.getAuthenticationManager();
  	  
    }
	
    @Bean
     SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
    {
    	return httpSecurity.csrf().disable()
    			.authorizeHttpRequests()
    			.requestMatchers("/auth/register","/auth/login","/auth/validate")
    			.permitAll()
    			.and()
    			.build();
    }
       
    	
    }
    
	
