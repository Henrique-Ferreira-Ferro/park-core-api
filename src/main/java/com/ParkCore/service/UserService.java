package com.ParkCore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ParkCore.model.User;
import com.ParkCore.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//Create a user with encrypted password
	public User CreateUser(User user) {
		var userCreate = new User();
		
		userCreate.setName(user.getName());
		String encrypt = passwordEncoder.encode(user.getPassword());
		userCreate.setPassword(encrypt);
		userCreate.setRole(user.getRole());
		return userRepository.save(userCreate);
	}
	
	
	public User updateUser(User user, Long id) {
		var userFind = userRepository.findById(id);
		
		if(!userFind.isPresent()) {
			throw new RuntimeException("Can´t find a user with this id");
		}
		
		User userMod = userFind.get();
		userMod.setName(user.getName());
		String encrypt = passwordEncoder.encode(user.getPassword());
		userMod.setPassword(encrypt);
		userMod.setRole(user.getRole());
		return userRepository.save(userMod);
	}
	
	
	public List<User> findAllUsers(){
		return userRepository.findAll();
	}
	
	
	
}
