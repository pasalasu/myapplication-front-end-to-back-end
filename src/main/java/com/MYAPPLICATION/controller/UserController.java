package com.MYAPPLICATION.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.MYAPPLICATION.exception.UserNotFoundException;
import com.MYAPPLICATION.model.application;
import com.MYAPPLICATION.repository.UserRepository;
import java.util.List;
@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
	 @Autowired
	    private UserRepository userRepository;

	    @PostMapping("/user")
	    application newUser(@RequestBody application newUser) {
	        return userRepository.save(newUser);
	    }

	    @GetMapping("/users")
	    List<application> getAllUsers() {
	        return userRepository.findAll();
	    }

	    @GetMapping("/user/{id}")
	    application getUserById(@PathVariable Long id) {
	        return userRepository.findById(id)
	                .orElseThrow(() -> new UserNotFoundException(id));
	    }

	    @PutMapping("/user/{id}")
	    application updateUser(@RequestBody application newUser, @PathVariable Long id) {
	        return userRepository.findById(id)
	                .map(user -> {
	                    user.setUsername(newUser.getUsername());
	                    user.setName(newUser.getName());
	                    user.setEmail(newUser.getEmail());
	                    return userRepository.save(user);
	                }).orElseThrow(() -> new UserNotFoundException(id));
	    }

	    @DeleteMapping("/user/{id}")
	    String deleteUser(@PathVariable Long id){
	        if(!userRepository.existsById(id)){
	            throw new UserNotFoundException(id);
	        }
	        userRepository.deleteById(id);
	        return  "User with id "+id+" has been deleted success.";
	    }



	}
