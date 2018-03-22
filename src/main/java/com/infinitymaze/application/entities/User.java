package com.infinitymaze.application.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter 
@Setter 
@NoArgsConstructor
@ToString
public class User {

	@Id
	@GeneratedValue
	@Setter(lombok.AccessLevel.PROTECTED)
	private long id;
	
	private String username;
	
	@JsonIgnore
	private String password;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
}
