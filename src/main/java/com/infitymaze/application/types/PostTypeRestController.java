package com.infitymaze.application.types;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/type")
public class PostTypeRestController {

	private final PostTypeRepository postTypeRepository;

	@Autowired
	PostTypeRestController(PostTypeRepository postTypeRepository) {
		this.postTypeRepository = postTypeRepository;
	}

	// Get all posts
	@GetMapping
	@CrossOrigin(origins = { "http://localhost:3000" })
	public ResponseEntity<List<PostType>> getAllPosts() {

		List<PostType> posts = postTypeRepository.findAll();

		if (posts == null)
			return new ResponseEntity<List<PostType>>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<PostType>>(posts, HttpStatus.OK);
	}
}
