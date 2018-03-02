package com.infitymaze.application.types;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.infitymaze.application.posts.Post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "type")
public class PostType {

	@Id
	@Setter(lombok.AccessLevel.PROTECTED)
	private long id;

	@Column(nullable = false)
	private String type;

	// important for bidirectional relationship
	@OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Post> posts = new ArrayList<>();

	public PostType(long id, String type) {
		this.id = id;
		this.type = type;
	}

	public void addPost(Post post) {
		posts.add(post);
		post.setType(this);
	}

	public void removePost(Post post) {
		posts.add(post);
		post.setType(null);
	}

	@Override
	public String toString() {
		return "PostType [id=" + id + ", type=" + type + "]";
	}

}