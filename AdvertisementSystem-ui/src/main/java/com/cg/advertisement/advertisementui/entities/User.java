package com.cg.advertisement.advertisementui.entities;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
	
	private long userId;
	
	@Size(min=1, max=32, message="First name must be between 1 and 32 characters")
	private String firstName;
	
	@Size(min=1, max=32, message="Last name must be between 1 and 32 characters")
	private String lastName;
	
	@NotNull
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message="Email address is invalid")
	private String email;
	
	@Size(min=6,max=10, message="Password must be between 6 and 10 characters")
	private String password;
	
	@Size(min=4,max=6, message="Please choose a gender")
	private String gender;
	
	@Size(min=10, max=12,message="Contact cannot be less than 10 digits")
	private String contact;
	
	@Size(min=3, max=12,message="Location must be between 3 and 12 characters")
	private String location;
	
	@Size(min=4,max=5, message="Please choose a user role")
	private String userRole;
	
	
	//getters and setters
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	//Default Constructor
	public User() {
		super();
	}
	
	//parameterized constructor
	public User(long userId,String firstName,String lastName,String email,String password,String gender,String contact,String location,String userRole) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.contact = contact;
		this.location = location;
		this.userRole = userRole;
	}
	
	//toString method
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", gender=" + gender + ", contact=" + contact + ", location=" + location
				+ ", userRole=" + userRole + "]";
	}
	
	
}
