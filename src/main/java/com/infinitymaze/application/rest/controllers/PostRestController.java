package com.infinitymaze.application.rest.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

import com.infinitymaze.application.entities.Post;
import com.infinitymaze.application.entities.Type;
import com.infinitymaze.application.repositories.PostRepository;
import com.infinitymaze.application.repositories.TypeRepository;

@RestController
@RequestMapping("/post")
@CrossOrigin(origins = { "http://localhost:3000", "https://blog-react-demo.herokuapp.com"  })
public class PostRestController {

	private final PostRepository postRepository;

	private final TypeRepository typeRepository;

	@Autowired
	PostRestController(PostRepository postRepository, TypeRepository typeRepository) {
		this.postRepository = postRepository;
		this.typeRepository = typeRepository;
	}

	@GetMapping
	public ResponseEntity<List<Post>> getAllPosts() {

		List<Post> posts = (List<Post>) postRepository.findAll();

		if (posts == null)
			return new ResponseEntity<List<Post>>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<Void> deleteAllPosts() {

		postRepository.deleteAll();

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> insertPost(@RequestBody Post post) {

		Type type = post.getType();

		if ((type = typeRepository.findByName(type.getName())) != null)
			post.setType(type);

		typeRepository.save(post.getType());
		postRepository.save(post);
		return new ResponseEntity<Void>(HttpStatus.CREATED);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Post> getPost(@PathVariable Long id) {
		Post post = postRepository.findOne(id);

		if (post == null)
			return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<Post>(post, HttpStatus.OK);
	}

	@PutMapping("/{id}")
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
	public ResponseEntity<Void> deletePost(@PathVariable Long id) {

		Post post = postRepository.findOne(id);

		if (post == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

		postRepository.delete(post);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// Types if only the id works but if only the name don't work
	@PostMapping("/filter")
	public ResponseEntity<List<Post>> filterPosts(@RequestParam String name,@RequestBody String [] types) {
		
		List<Post> posts = new ArrayList<Post>();
		if(types.length == 0) {
			posts = (List<Post>) postRepository.filterPostsByName(name);
		}else{
			posts = (List<Post>) postRepository.filterPostByNameAndType(name,types);
		}

		if (posts.size() < 0)
			return new ResponseEntity<List<Post>>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
	}
	
	@GetMapping("/page")
	public ResponseEntity<Page<Post>> findPaginatedPost(@RequestParam int page, @RequestParam int size){
		Page<Post> posts = postRepository.findAll(new PageRequest(page, size));
		
		if (posts.getSize() < 0)
			return new ResponseEntity<Page<Post>>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Page<Post>>(posts,HttpStatus.OK);
		
	}
	
	@PutMapping("like/{id}")
	public ResponseEntity<Post> updatelikePost(@PathVariable Long id) {
		Post currentPost = postRepository.findOne(id);

		if (currentPost == null)
			return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);

		currentPost.setLikes(currentPost.getLikes()+1);
		
		postRepository.save(currentPost);

		return new ResponseEntity<Post>(HttpStatus.OK);
	}
	
}
