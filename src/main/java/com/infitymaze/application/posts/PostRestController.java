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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostRestController {

	private final PostRepository postRepository;

	@Autowired
	PostRestController(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	// Get all posts
	@GetMapping
	@CrossOrigin(origins = {"http://localhost:3000"})
	public ResponseEntity<List<Post>> getAllPosts() {

		List<Post> posts = (List<Post>) postRepository.findAll();

		if (posts == null)
			return new ResponseEntity<List<Post>>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
	}

	// Delete all posts
	@DeleteMapping
	@CrossOrigin(origins = {"http://localhost:3000"})
	public ResponseEntity<Void> deleteAllPosts() {

		postRepository.deleteAll();

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// insert post
	@PostMapping
	@CrossOrigin(origins = {"http://localhost:3000"})
	public ResponseEntity<Void> insertPost(@RequestBody Post post) {

		postRepository.save(post);
		return new ResponseEntity<Void>(HttpStatus.CREATED);

	}

	// get post by id
	@GetMapping("/{id}")
	@CrossOrigin(origins = {"http://localhost:3000"})
	public ResponseEntity<Post> getPost(@PathVariable Long id) {
		Post post = postRepository.findById(id);

		if (post == null)
			return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<Post>(post, HttpStatus.OK);
	}

	// update post info
	@PutMapping("/{id}")
	@CrossOrigin(origins = {"http://localhost:3000"})
	public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post) {
		Post currentPost = postRepository.findById(id);

		if (currentPost == null)
			return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);

		currentPost.setContent(post.getContent());
		currentPost.setPostType(post.getPostType());
		currentPost.setTitle(post.getTitle());

		postRepository.save(currentPost);

		return new ResponseEntity<Post>(HttpStatus.OK);
	}

	// delete post
	@DeleteMapping("/{id}")
	@CrossOrigin(origins = {"http://localhost:3000"})
	public ResponseEntity<Void> deletePost(@PathVariable Long id) {

		Post post = postRepository.findById(id);

		if (post == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

		postRepository.delete(post);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
