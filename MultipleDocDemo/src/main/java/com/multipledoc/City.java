package com.multipledoc;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class City {

	private String  city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
