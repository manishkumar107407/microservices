package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.User;
import com.example.demo.service.UserDao;

@Controller
public class MyController 
{
@Autowired
private UserDao dao;	
	
 @GetMapping(value = "/")
 public String registerUi()
 {
	return "register"; 
 }
 
 @ModelAttribute
 public User validationMethod()
 {
	return new User();
	 
 }
 
 
 @PostMapping(value = "/register")
 public String register(@Valid @ModelAttribute User user, BindingResult result,Model model)
 {
	if(result.hasErrors())
	 {  
		    model.addAttribute("user1", user);
			System.out.println("My Control in try = "+user.getMobile());
			System.out.println(result);
			return "register"; 
	 }
	else
	{
    String msg=dao.register(user);
    if(msg.equals("Registration Successfull"))
    {
    	model.addAttribute("msg1", msg);
    	return "login";
    }
    else
    {
    	model.addAttribute("msg1", msg);
    	return "register";
    }
	 
 }
 }
}
