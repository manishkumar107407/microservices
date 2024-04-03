package com.example.authserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.authserver.entities.User;
import com.example.authserver.repo.UserRepo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
 

@Service
public class UserServiceImp implements UserService  
{
 
    @Autowired
	UserRepo repo;
    
    @Autowired
    PasswordEncoder encoder;
    
    @Autowired
    JwtTokenService jwtTokenService;
    
     
  
    
    @Override
	public User createUser(User user) 
    {
    	user.setPass(encoder.encode(user.getPass()));
		return repo.save(user);
		  
	}
    
    public String generateToken(String email)
    {
		return jwtTokenService.generateToken(email);   	
    }
    
    
    public Jws<Claims> validateToken(String token)
    {
    	return jwtTokenService.validateToken(token);
    	
    }

 

	

}

