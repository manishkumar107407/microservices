package com.org.validation.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.validation.entity.User;
import com.org.validation.servercies.UserService;

@RestController
@RequestMapping(value = "/api")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/finduser")
	public List<User> findByUser() {
		List<User> findByUser = userService.findByUser();
		System.out.println(findByUser);

		return findByUser;

	}

	@PostMapping(value = "/register")
	public String register(@Valid @RequestBody User user, BindingResult result) {
		if (result.hasErrors()) {
			return "invalid";
		} else {
			String register = userService.register(user);
			return "sucess";
		}

	}

	@PostMapping(value = "/login")
	public String login(@RequestBody User user) {
		String login = userService.login(user);
		return login;
	}

	@GetMapping(value = "getuser/{id}")
	public User getByuser(@PathVariable int id) {

		User findById = userService.findById(id);
		return findById;

	}

	@GetMapping(value = "/getAllUser")
	public List<User> getAllUser() {

		List<User> findall = userService.findByAll();

		return findall;

	}

	@PutMapping(value = "updateUser")
	public User updateUser(@RequestBody User user) {
		User update = userService.update(user);
		return update;
	}

	@DeleteMapping(value = "delete/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable int id) {
		try {
			userService.deleteUser(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

}