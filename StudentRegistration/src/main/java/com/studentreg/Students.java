package com.studentreg;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "Students")
public class Students {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String email;
	private Long mobileNumber;
	private String gender;
	private Address address;
	private List<String> hobbies;
	private List<Qualification> qualification;
	private String courseAppliedFor;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	public List<Qualification> getQualification() {
		return qualification;
	}
	public void setQualification(List<Qualification> qualification) {
		this.qualification = qualification;
	}
	public String getCourseAppliedFor() {
		return courseAppliedFor;
	}
	public void setCourseAppliedFor(String courseAppliedFor) {
		this.courseAppliedFor = courseAppliedFor;
	}
	
	@Override
	public String toString() {
		return "Students [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", email=" + email + ", mobileNumber=" + mobileNumber + ", gender=" + gender
				+ ", address=" + address + ", hobbies=" + hobbies + ", qualification=" + qualification
				+ ", courseAppliedFor=" + courseAppliedFor + "]";
	}	
	
}
