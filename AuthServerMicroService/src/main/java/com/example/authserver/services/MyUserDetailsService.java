package com.example.authserver.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.authserver.entities.User;
import com.example.authserver.repo.UserRepo;
 


public class MyUserDetailsService implements UserDetailsService
{
	
	@Autowired
	UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
	Optional<User> user =repo.findByEmail(username);
	 return user.map(MyUserDetails::new)
			 .orElseThrow(()->new UsernameNotFoundException("user not found="+username));
	}


}