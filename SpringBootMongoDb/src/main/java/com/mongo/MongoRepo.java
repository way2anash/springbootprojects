package com.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoRepo extends MongoRepository<MongoUser, String> {

	
}
