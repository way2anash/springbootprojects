package com.restful.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	
	@Autowired
 private UserDao userService;
	
	@GetMapping("/users")
	public List<User> retriveAllUser(){
		
		return userService.findAll();
	}
 
	@GetMapping("/users/{id}")
	public User findById(@PathVariable int id) {
		
	      User user= userService.findOne(id);
	      if(user==null) {
	    	  throw new UserNotFoundException("id-" +id);
	      }
	      return user;
	}
	
	@PostMapping("/users")
	public User saveUser(@RequestBody User user) {
		User savedUser= userService.save(user);
		return savedUser;
	}
	
	@DeleteMapping("/users/{id}")
	public User deleteById(@PathVariable int id) {
		
	      User user= userService.deleteUser(id);
	      if(user==null) {
	    	  throw new UserNotFoundException("id-" +id);
	      }
	      return user;
	}
	

}






