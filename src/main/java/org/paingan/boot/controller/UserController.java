package org.paingan.boot.controller;

import org.paingan.boot.domain.UserAccount;
import org.paingan.boot.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	private UserRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	public UserController(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@PostMapping("/sign-up")
	public void signUp(@RequestBody UserAccount applicationUser) {
		applicationUser.setPassword(bCryptPasswordEncoder.encode(applicationUser.getPassword()));
		userRepository.save(applicationUser);
	}
}
