package com.spring.rests.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rests.models.User;
import com.spring.rests.repositories.UserMgmtRepo;

@RestController
@RequestMapping(value = "/usrs")
public class UserController {

	@Autowired
	private UserMgmtRepo userMgmtRepo;

	@PostMapping(value = "/add")
	public User add(@RequestBody User reqUser) {
		User user = new User();
		user.setName(reqUser.getName());
		user.setLocation(reqUser.getLocation());
		userMgmtRepo.save(user);
		return user;
	}

	@GetMapping(value = "/findAll")
	public List<User> findAll() {
		Optional<List<User>> data = Optional.ofNullable(userMgmtRepo.findAll());
		return data.get();
	}

}
