package com.multipledoc;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepo extends MongoRepository<Person,String> {
	

}
