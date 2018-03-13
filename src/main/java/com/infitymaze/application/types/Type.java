package com.infitymaze.application.types;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
public class Type {

	@Id
	@GeneratedValue
	@Setter(lombok.AccessLevel.PROTECTED)
	private long id;

	@Column(nullable = false)
	private String name;

	public Type(long id, String name) {
		this.id = id;
		this.name = name;
	}

}