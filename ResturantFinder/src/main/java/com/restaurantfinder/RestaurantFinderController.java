package com.restaurantfinder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurants")
public class RestaurantFinderController {

	@Autowired 
	private RestaurantFinderRepository services;
	
	@PostMapping()
	public void create(@RequestBody RestaurantRepresentation restaurantRep) {
		services.createRestaurants(restaurantRep);
	}

	@GetMapping("/all")
	public List<Restaurant> findAll() {
		
		return services.findAll();
	}
	
	@GetMapping("/findByDistance")
	public List<Restaurant> findByDistance(@RequestParam("lng") float longitude,
			@RequestParam("lat") float lattitude, @RequestParam("dist") int distance){
		
		
		return services.findByDistance(longitude,lattitude,distance);
	}
}










