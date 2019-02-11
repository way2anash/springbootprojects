package com.multipledoc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

	@Autowired
	private CityRepo cityRepo;
	
	@GetMapping("/city")
	public List<City> getAllCities(){
		 
		return cityRepo.findAll();
	}
	
	@PostMapping("/city")
	public City saveCity(@RequestBody City city){
		 
		return cityRepo.save(city);
	}
}
