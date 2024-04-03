package com.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.security.filters.JwtAuthFilter;
import com.security.service.MyUserDetailsService;
import com.security.service.UserServiceImp;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class MySecuirtyConfi 
{	
	@Autowired
	private JwtAuthFilter authFilter;
	
	
    @Bean
    public UserDetailsService userDetails()
    {
    return  new MyUserDetailsService();	
    }
	
	
    @Bean
	public PasswordEncoder passwordEncoder()
	{
	return new BCryptPasswordEncoder();	
	}
	
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
    {
    	return httpSecurity.csrf().disable()
    			.authorizeHttpRequests()
    			.requestMatchers("/api/register","/api/authenticat")
    			.permitAll()
    			.and()
    			.authorizeHttpRequests()
    			.requestMatchers("/api/**")
    			.authenticated()
    			.and()
    			.sessionManagement()
    			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    			.and()
    			.authenticationProvider(authenticationProvider())
    			.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
    			.build();
    }
    			
  @Bean  			
  public AuthenticationProvider  authenticationProvider()
  {
	  DaoAuthenticationProvider  authenticationProvider=new DaoAuthenticationProvider();
	  authenticationProvider.setUserDetailsService(userDetails());
	  authenticationProvider.setPasswordEncoder(passwordEncoder());
	return authenticationProvider;	  
  }
  

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception
  {
	return authenticationConfiguration.getAuthenticationManager();
	  
  }
  
  
    }
    
	
