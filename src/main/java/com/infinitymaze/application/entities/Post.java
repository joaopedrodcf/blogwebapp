package com.infinitymaze.application.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
public class Post {

	@Id
	@GeneratedValue
	@Setter(lombok.AccessLevel.PROTECTED)
	private long id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false,length = 3000)
	private String content;
	
	@Column(nullable = false)
	private String image;
	
	@Column(nullable = false)
	private long likes;

	@ManyToOne
	private Type type;
	
	public Post(String title, String content,Type type,String image,String description) {
		this.title = title;
		this.content = content;
		this.type = type;
		this.image = image;
		this.description=description;
		this.likes=0;
	}

}
