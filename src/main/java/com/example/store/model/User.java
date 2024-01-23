package com.example.store.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(name = "username")
	@JsonProperty("username")
	String username;
	
	@Column(name = "first_name")
	@JsonProperty("first_name")
	String firstName;
	
	@Column(name = "last_name")
	@JsonProperty("last_name")
	String lastName;
	
	@Column(name = "email")
	@JsonProperty("email")
	String email;
	
	@Column(name = "pword")
	@JsonProperty("pword")
	String password;
	
	@Column(name = "acc_type")
	@JsonProperty("acc_type")
	Integer accType;
	
	public User() {
		
	}
	
	public User(UnverifiedUser unvUser) {
		this.username = unvUser.getUsername();
		this.firstName = unvUser.getFirstName();
		this.lastName = unvUser.getLastName();
		this.email = unvUser.getEmail();
		this.password = unvUser.getPassword();
		this.accType = unvUser.getAccType();
	}
	
	public User(String username, String firstName, String lastName, String email, String password, Integer accType) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.accType = accType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Integer getAccType() {
		return accType;
	}

	public void setAccType(Integer accType) {
		this.accType = accType;
	}
}
