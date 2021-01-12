package com.spring.rests.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
		try {
			userMgmtRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
