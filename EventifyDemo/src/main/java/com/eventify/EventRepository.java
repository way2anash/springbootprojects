package com.eventify;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends MongoRepository<EventsDemo,String> {

	@Query("{ 'city' : ?0, 'type' : ?1}")
	List<EventsDemo> findByType(String city,String type, Sort sort);

	@Query("{ 'city' : ?0}")
	List<EventsDemo> findByCity(String city, Sort sort);
	
	@Query("{ 'id' : ?0}")
	EventsDemo findByObjectId(String id);

	@Query("{ 'tags' : { $regex: ?0 } }")
	List<EventsDemo> findByTag(String query, Sort sort);
 
	
	

	

}
