package com.rating;

import java.util.ArrayList;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Movies")
public class Movies {

	private String id;
	private String name;
	private String releasedYear;
	private String genre;
	private ArrayList<Integer> ratingNumbers;
	private String rating;
	private ArrayList<Reviews> reviews;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReleasedYear() {
		return releasedYear;
	}
	public void setReleasedYear(String releasedYear) {
		this.releasedYear = releasedYear;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}

	public ArrayList<Reviews> getReviews() {
		return reviews;
	}
	public void setReviews(ArrayList<Reviews> reviews) {
		this.reviews = reviews;
	}
	public ArrayList<Integer> getRatingNumbers() {
		return ratingNumbers;
	}
	public void setRatingNumbers(ArrayList<Integer> ratingNumbers) {
		this.ratingNumbers = ratingNumbers;
	}
	
	
	@Override
	public String toString() {
		return "Movies [id=" + id + ", name=" + name + ", releasedYear=" + releasedYear + ", genre=" + genre
				+ ", rating=" + rating + ", review=" + reviews + "]";
	}
	
	

	
}
