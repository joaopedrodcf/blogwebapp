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

@Entity
@Getter 
@Setter 
@NoArgsConstructor
public class Post {
	
	@Id
	@GeneratedValue
	@Setter(lombok.AccessLevel.PROTECTED)
	private long id;
	
	@Column(nullable = false)
	@Setter
	private String title;
	
	@Column(nullable = false)
	private String content;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private EnumPostType postType;
	
	public Post(String title, String content, EnumPostType postType) {
		this.title = title;
		this.content = content;
		this.postType = postType;
	}

}
