package com.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ServiceProviders")
public class ServiceProviders {

	private String id;
	private String username;
	private String email;
	private String password;
	private String cnfpassword;
	private String role;
	
	@Id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCnfpassword() {
		return cnfpassword;
	}
	public void setCnfpassword(String cnfpassword) {
		this.cnfpassword = cnfpassword;
	}
	@Override
	public String toString() {
		return "ServiceProviders [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", cnfpassword=" + cnfpassword + ", role=" + role + "]";
	}
	
	
	
}                           

