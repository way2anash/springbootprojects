package com.restaurantfinder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class RestaurantFinderRepository {

	@Autowired
	private MongoOperations mongoOperations;
	
	public void createRestaurants(RestaurantRepresentation restaurant) {
		Restaurant restaurantPersist = new Restaurant();
		restaurantPersist.setName(restaurant.getName());
		restaurantPersist.setAddress(restaurant.getAddress());
		mongoOperations.save(restaurantPersist);
			
	}
	
	public List<Restaurant> findAll(){
		
		return mongoOperations.findAll(Restaurant.class);
	}
	
	public List<Restaurant> findByDistance(float longitude,float lattitude,int distance){
		Point basePoint = new Point(longitude,lattitude);
		Distance radius = new Distance(distance,Metrics.MILES);
		Circle area = new Circle(basePoint,radius);
		Query query = new Query();
		query.addCriteria(Criteria.where("address.geoLocation").withinSphere(area));
		
		return mongoOperations.find(query, Restaurant.class);
	}
}
