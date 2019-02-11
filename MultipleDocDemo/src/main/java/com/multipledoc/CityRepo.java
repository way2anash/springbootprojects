package com.multipledoc;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepo extends MongoRepository<City,String> {
	

}
