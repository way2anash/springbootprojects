/*
package com.rating;

import java.text.DecimalFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


@Service
public class MoviesRepobak {

	@Autowired 
	private MongoTemplate mongoTemplate;

	public Movies findByName(String name) {
		Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return mongoTemplate.findOne(query, Movies.class);
	
	}

	public void saveMovie(Movies movie) {
	
		mongoTemplate.save(movie);
		
		
	}

	//calculating rating value
	public String findRatingvalue(ArrayList<Integer> ratingNumbers) {
		int maxRatings ,avgRatings=0,totalRatings=0;
		
		for (int rating : ratingNumbers) {
			totalRatings= totalRatings + rating;
		
		}
		
		maxRatings = totalRatings*5;
		
		for(int i=0;i<5;i++) {
			avgRatings = avgRatings + (ratingNumbers.get(i) * (i+1));
			
		}
		float rating = (float) (avgRatings *5)/ maxRatings;
		DecimalFormat df = new DecimalFormat(".##");
		return df.format(rating);
	}
	
	
}
                   */