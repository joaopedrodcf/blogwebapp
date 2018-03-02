package com.infitymaze.application.types;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
public class Type {

	@Id
	@Setter(lombok.AccessLevel.PROTECTED)
	private long id;

	@Column(nullable = false)
	private String type;

	public Type(long id, String type) {
		this.id = id;
		this.type = type;
	}

}