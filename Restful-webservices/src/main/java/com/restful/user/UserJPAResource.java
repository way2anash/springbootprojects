package com.restful.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserJPAResource {
	
	@Autowired
 private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	
	@GetMapping("/jpa/users")
	public List<User> retriveAllUser(){
		
		return userRepository.findAll();
	}
 
	@GetMapping("/jpa/users/{id}")
	public Optional<User> findById(@PathVariable int id) {
		
	      Optional<User> user= userRepository.findById(id);
	      if(!user.isPresent()) {
	    	  throw new UserNotFoundException("id-" +id);
	      }
	      return user;
	}
	
	@PostMapping("/jpa/users")
	public User saveUser(@RequestBody User user) {
		User savedUser= userRepository.save(user);
		return savedUser;
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteById(@PathVariable int id) {
		
	       userRepository.deleteById(id);
	    
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retriveAllUser(@PathVariable int id){
		
		Optional<User> user =  userRepository.findById(id);
		
		if(!user.isPresent()) {
	    	  throw new UserNotFoundException("id-" +id);
	      }
		return user.get().getPost();
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public Post createPost(@PathVariable int id,@RequestBody Post post) {
		
      Optional<User> userOptional =  userRepository.findById(id);
		
		if(!userOptional.isPresent()) {
	    	  throw new UserNotFoundException("id-" +id);
	      }
		User user = userOptional.get(); 
		post.setUser(user);
		
	  return postRepository.save(post);
		
	}

}






