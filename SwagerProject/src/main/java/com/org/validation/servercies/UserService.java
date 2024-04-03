package com.org.validation.servercies;

import java.util.List;

import com.org.validation.entity.User;

public interface UserService {
	
	public List<User> findByUser();
	public String register(User user);
	public User findExitUser(User user);
	public String login(User user);
	public User findById(int id);
	public List<User> findByAll();
	public User update(User user);
	public void deleteUser(int id);
	
	          
	
	
	
	

}
