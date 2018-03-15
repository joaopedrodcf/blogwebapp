package com.infitymaze.application.posts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.infitymaze.application.types.Type;

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
	private String content;
	
	@Column(nullable = false)
	private String image;

	@ManyToOne
	private Type type;
	
	public Post(String title, String content,Type type,String image) {
		this.title = title;
		this.content = content;
		this.type = type;
		this.image = image;
	}

}
