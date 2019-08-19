package com.mytaxi.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mytaxi.Repository.CarRepository;

import com.mytaxi.Model.Car;

@Service
public class CarService {

	@Autowired
	private CarRepository carsRepository;

	public List<Car> getAllCars() {
		// TODO Auto-generated method stub
		return carsRepository.findAll();
	}

	public Car save(Car car) {
		// TODO Auto-generated method stub
		return carsRepository.save(car);
	}

	public Optional<Car> findById(Long id) {
		// TODO Auto-generated method stub
		return carsRepository.findById(id);
	}

	public ResponseEntity<String> updateCarById(Car updateCar, Long id) {
		Optional<Car> tempCar = carsRepository.findById(id);
		if(tempCar.isPresent()) {
			updateCar.setId(id);
			carsRepository.save(updateCar);
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		 return new ResponseEntity<String>(HttpStatus.NOT_FOUND); 
	}

	public ResponseEntity<Car> deleteById(Long id) {
		Optional<Car> car = carsRepository.findById(id);
		if(car.isPresent()) {
			carsRepository.deleteById(id);
			return new ResponseEntity<Car>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
	}
	
	
}
