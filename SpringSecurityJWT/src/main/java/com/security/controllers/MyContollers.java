package com.security.controllers;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.dto.AuthRequest;
import com.security.entites.User;
import com.security.service.JwtService;
import com.security.service.UserService;

@RestController
@RequestMapping("/api")
public class MyContollers 
{

	@Autowired
	private UserService service;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	
	@PostMapping("/register")
	public User registerUser(@RequestBody User user)
	{		
	 return	service.createUser(user);
	}
	

	
	
	@GetMapping("/home")
	@PreAuthorize("hasAuthority('USER')")
	public String homePage()
	{	
		return "homepage";
	}
	
	

	@GetMapping("/admin")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String adminPage()
	{	
		return "adminPage";
	}
	
	
	@PostMapping("/authenticat")
	public String authenticatAndGetToken(@RequestBody AuthRequest authRequest)
	{
	Authentication  authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPass()));
	if(authentication.isAuthenticated())
	{
		return jwtService.getnerateToken(authRequest.getEmail());		
	}
	else
	{
		
		throw new UsernameNotFoundException("invalid user name or password");
	}
	
	}
	
	
	
}
