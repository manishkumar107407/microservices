package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;

@Service
public class UserDaoImpl implements UserDao
{ 
	@Autowired
	private UserRepo repo;

	@Transactional
	@Override
	public String register(User user)
	{
		User user2=repo.save(user);
		if(user2!=null)
		{
			return "Registration Successfull";
		}
		else
		{
			return "Failed";
		}
	}


}
