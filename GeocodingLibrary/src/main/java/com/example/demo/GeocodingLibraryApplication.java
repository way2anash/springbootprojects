package com.example.demo;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;


@SpringBootApplication
public class GeocodingLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeocodingLibraryApplication.class, args);

		GeoApiContext context = new GeoApiContext.Builder()
			    .apiKey("AIzaSyCEEjHbw3KL5WJAIJhBBh4gBBScheFHJ5c")
			    .build();
			GeocodingResult[] results=null;
			try {
				results = GeocodingApi.geocode(context,
				    "Telecom Nagar Gachibowli Hyderabad").await();
			} catch (ApiException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			System.out.println(gson.toJson(results[0].addressComponents));
		System.out.println("....................................");
			System.out.println("Lattitude");
			System.out.println(gson.toJson(results[0].geometry.location.lat));
			System.out.println("....................................");
			System.out.println("longitude");
			System.out.println(gson.toJson(results[0].geometry.location.lng));	    
		

	}
}
