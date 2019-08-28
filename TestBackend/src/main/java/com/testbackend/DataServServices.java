package com.testbackend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataServServices {
	
	@Autowired
	DataServiceRepository dataServiceRepository;

	public List<DataService> findAll() {
		// TODO Auto-generated method stub
		return dataServiceRepository.findAll();
	}

	public void saveData(DataService dataService) {
	      
		DataService ds =dataServiceRepository.findByData(dataService.getData())  ;
		
		if(ds==null) {
			dataServiceRepository.save(dataService);
		}
		
	}
	

}
