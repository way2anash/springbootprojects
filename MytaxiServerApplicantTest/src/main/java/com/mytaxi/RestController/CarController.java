package com.mytaxi.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import com.mytaxi.Model.Car;
import com.mytaxi.Service.CarService;

@RestController
public class CarController {

	@Autowired
	private CarService carService;
	
	@GetMapping("/cars")
	public List<Car> getAllCarsList() {
		
		return carService.getAllCars();
	}
	
	@PostMapping("/cars")
	public Car saveCars( Car car) {
		
		return carService.save(car);
	}
	

	//Get car by id
	@GetMapping("/cars/{id}")
	public ResponseEntity<Car> getCarById(@PathVariable("id") Long id) {
		
		Optional<Car> car= carService.findById(id);
		
		if (car.isPresent()) {
			return new ResponseEntity<Car>(car.get(),HttpStatus.OK);
            
        }
		return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/cars/{id}")
	public ResponseEntity<String> updateStudentById(@RequestBody Car updateCar, @PathVariable("id") Long id) {
		
		return carService.updateCarById(updateCar, id);
		
	}
	
	@DeleteMapping("/cars/{id}")
	public ResponseEntity<Car> deleteStudent(@PathVariable Long id) {
		
		 return carService.deleteById(id);
	}
}
