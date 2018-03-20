package com.infitymaze.application.posts;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infitymaze.application.types.Type;
import com.infitymaze.application.types.TypeRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/post")
public class PostRestController {

	private final PostRepository postRepository;

	private final TypeRepository typeRepository;

	private static final Logger logger = LogManager.getLogger(PostRestController.class);
	
	@Autowired
	PostRestController(PostRepository postRepository, TypeRepository typeRepository) {
		this.postRepository = postRepository;
		this.typeRepository = typeRepository;
	}

	@GetMapping
	@CrossOrigin(origins = { "http://localhost:3000" })
	public ResponseEntity<List<Post>> getAllPosts() {

		List<Post> posts = (List<Post>) postRepository.findAll();

		if (posts == null)
			return new ResponseEntity<List<Post>>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
	}

	@DeleteMapping
	@CrossOrigin(origins = { "http://localhost:3000" })
	public ResponseEntity<Void> deleteAllPosts() {

		postRepository.deleteAll();

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping
	@CrossOrigin(origins = { "http://localhost:3000" })
	public ResponseEntity<Void> insertPost(@RequestBody Post post) {

		Type type = post.getType();

		if ((type = typeRepository.findByName(type.getName())) != null)
			post.setType(type);

		typeRepository.save(post.getType());
		postRepository.save(post);
		return new ResponseEntity<Void>(HttpStatus.CREATED);

	}

	@GetMapping("/{id}")
	@CrossOrigin(origins = { "http://localhost:3000" })
	public ResponseEntity<Post> getPost(@PathVariable Long id) {
		Post post = postRepository.findOne(id);

		if (post == null)
			return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<Post>(post, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@CrossOrigin(origins = { "http://localhost:3000" })
	public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post) {
		Post currentPost = postRepository.findOne(id);

		if (currentPost == null)
			return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);

		currentPost.setContent(post.getContent());
		currentPost.setType(post.getType());
		currentPost.setTitle(post.getTitle());
		currentPost.setImage(post.getImage());
		
		postRepository.save(currentPost);

		return new ResponseEntity<Post>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	@CrossOrigin(origins = { "http://localhost:3000" })
	public ResponseEntity<Void> deletePost(@PathVariable Long id) {

		Post post = postRepository.findOne(id);

		if (post == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

		postRepository.delete(post);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// Types if only the id works but if only the name don't work
	@PostMapping("/filter")
	@CrossOrigin(origins = { "http://localhost:3000" })
	public ResponseEntity<List<Post>> filterPosts(@RequestParam String name,@RequestBody Type [] types) {
		
		logger.info(name);
		List<Post> posts = (List<Post>) postRepository.filterPosts(name,types);

		if (posts.size() < 0)
			return new ResponseEntity<List<Post>>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
	}
}
