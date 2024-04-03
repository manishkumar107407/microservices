package com.example.authserver.controllers;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.authserver.dto.AuthRequest;
import com.example.authserver.entities.User;
import com.example.authserver.services.UserService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

 
@RestController
@RequestMapping("/auth")
public class MyContollers 
{

	@Autowired
	UserService service;
	

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/register")
	public User registerUser(@RequestBody User user)
	{		
	 return	service.createUser(user);
	}
	
	@PostMapping("/login")
	public String getToken(@RequestBody AuthRequest authRequest)
	{
		Authentication  authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPass()));
		if(authentication.isAuthenticated())
		{
			return service.generateToken(authRequest.getEmail());		
		}
		else
		{	
			throw new UsernameNotFoundException("invalid user name or password");
		}	
		
	 
	}
	
	@GetMapping("/validate")
	public String validateToken(@RequestParam("token") String token)
	{
		 Jws<Claims> validateToken = service.validateToken(token);
		 if(validateToken!=null)
		 return "token is valid";
		 else
		 return "token is In valid";
					 
		 
		 }
 
	
	
	 
	
	
	
}
