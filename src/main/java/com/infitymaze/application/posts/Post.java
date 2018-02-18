package com.infitymaze.application.posts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter 
@Setter 
@NoArgsConstructor
@ToString
public class Post {
	
	@Id
	@GeneratedValue
	@Setter(lombok.AccessLevel.PROTECTED)
	private long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String content;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private EnumType type;
	
	public Post(String title, String content, EnumType type) {
		this.title = title;
		this.content = content;
		this.type = type;
	}

}
