package com.infitymaze.application.posts;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long>{

	Optional<Post> findByTitle(String title);
	
	Optional<Post> findByPostType(EnumPostType postType);
	
	Post findById(long id);
	
}
