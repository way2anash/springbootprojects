package com.multipledoc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	@Autowired
	private PersonRepo personRepo;
	
	@GetMapping("/person")
	public List<Person> getAllPersons(){
		 
		return personRepo.findAll();
	}
	
	@PostMapping("/person")
	public Person savePersons(@RequestBody Person person){
		 
		return personRepo.save(person);
	}
	

	
	
}
