package com.example.authserver.services;

import com.example.authserver.entities.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

public interface UserService {
	 
public User createUser(User user);

public String generateToken(String email);
public Jws<Claims> validateToken(String token);
	
}
