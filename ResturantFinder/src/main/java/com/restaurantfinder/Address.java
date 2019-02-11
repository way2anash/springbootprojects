package com.restaurantfinder;

public class Address {

	private String street1;
	
	private String steet2;
	
	private String city;
	
	private String state;
	
	private int zipcode;
	
	private Location geoLocation;

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getSteet2() {
		return steet2;
	}

	public void setSteet2(String steet2) {
		this.steet2 = steet2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public Location getGeoLocation() {
		return geoLocation;
	}

	public void setGeoLocation(Location geoLocation) {
		this.geoLocation = geoLocation;
	}
	
	
	
}
