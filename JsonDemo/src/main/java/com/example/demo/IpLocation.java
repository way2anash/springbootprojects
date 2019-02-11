package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"as",
"city",
"country",
"countryCode",
"isp",
"lat",
"lon",
"org",
"query",
"region",
"regionName",
"status",
"timezone",
"zip"
})

public class IpLocation {

	@JsonProperty("as")
	private String as;
	@JsonProperty("city")
	private String city;
	@JsonProperty("country")
	private String country;
	@JsonProperty("countryCode")
	private String countryCode;
	@JsonProperty("isp")
	private String isp;
	@JsonProperty("lat")
	private Double lat;
	@JsonProperty("lon")
	private Double lon;
	@JsonProperty("org")
	private String org;
	@JsonProperty("query")
	private String query;
	@JsonProperty("region")
	private String region;
	@JsonProperty("regionName")
	private String regionName;
	@JsonProperty("status")
	private String status;
	@JsonProperty("timezone")
	private String timezone;
	@JsonProperty("zip")
	private String zip;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("as")
	public String getAs() {
	return as;
	}

	@JsonProperty("as")
	public void setAs(String as) {
	this.as = as;
	}

	@JsonProperty("city")
	public String getCity() {
	return city;
	}

	@JsonProperty("city")
	public void setCity(String city) {
	this.city = city;
	}

	@JsonProperty("country")
	public String getCountry() {
	return country;
	}

	@JsonProperty("country")
	public void setCountry(String country) {
	this.country = country;
	}

	@JsonProperty("countryCode")
	public String getCountryCode() {
	return countryCode;
	}

	@JsonProperty("countryCode")
	public void setCountryCode(String countryCode) {
	this.countryCode = countryCode;
	}

	@JsonProperty("isp")
	public String getIsp() {
	return isp;
	}

	@JsonProperty("isp")
	public void setIsp(String isp) {
	this.isp = isp;
	}

	@JsonProperty("lat")
	public Double getLat() {
	return lat;
	}

	@JsonProperty("lat")
	public void setLat(Double lat) {
	this.lat = lat;
	}

	@JsonProperty("lon")
	public Double getLon() {
	return lon;
	}

	@JsonProperty("lon")
	public void setLon(Double lon) {
	this.lon = lon;
	}

	@JsonProperty("org")
	public String getOrg() {
	return org;
	}

	@JsonProperty("org")
	public void setOrg(String org) {
	this.org = org;
	}

	@JsonProperty("query")
	public String getQuery() {
	return query;
	}

	@JsonProperty("query")
	public void setQuery(String query) {
	this.query = query;
	}

	@JsonProperty("region")
	public String getRegion() {
	return region;
	}

	@JsonProperty("region")
	public void setRegion(String region) {
	this.region = region;
	}

	@JsonProperty("regionName")
	public String getRegionName() {
	return regionName;
	}

	@JsonProperty("regionName")
	public void setRegionName(String regionName) {
	this.regionName = regionName;
	}

	@JsonProperty("status")
	public String getStatus() {
	return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
	this.status = status;
	}

	@JsonProperty("timezone")
	public String getTimezone() {
	return timezone;
	}

	@JsonProperty("timezone")
	public void setTimezone(String timezone) {
	this.timezone = timezone;
	}

	@JsonProperty("zip")
	public String getZip() {
	return zip;
	}

	@JsonProperty("zip")
	public void setZip(String zip) {
	this.zip = zip;
	}

	@JsonSetter
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}

	@JsonSetter
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}
}
