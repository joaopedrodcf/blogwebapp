package com.infitymaze.application.posts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Post {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String content;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	public EnumPostType postType;
	
	public long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getContent() {
		return content;
	}
	
	public EnumPostType getPostType() {
		return postType;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setPostType(EnumPostType postType) {
		this.postType = postType;
	}

	public Post(String title, String content, EnumPostType postType) {
		super();
		this.title = title;
		this.content = content;
		this.postType = postType;
	}

	protected Post() {
		super();
	}

}
