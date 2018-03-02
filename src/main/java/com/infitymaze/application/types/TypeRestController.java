package com.infitymaze.application.types;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/type")
public class TypeRestController {

	private final TypeRepository TypeRepository;

	@Autowired
	TypeRestController(TypeRepository postTypeRepository) {
		this.TypeRepository = postTypeRepository;
	}

	// insert post
	@PostMapping
	@CrossOrigin(origins = { "http://localhost:3000" })
	public ResponseEntity<Void> insertPostType(@RequestBody Type type) {

		TypeRepository.saveAndFlush(type);
		return new ResponseEntity<Void>(HttpStatus.CREATED);

	}
	
	// Get all posts
	@GetMapping
	@CrossOrigin(origins = {"http://localhost:3000"})
	public ResponseEntity<List<Type>> getAllPostTypes() {

		List<Type> types = (List<Type>) TypeRepository.findAll();

		if (types == null)
			return new ResponseEntity<List<Type>>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Type>>(types, HttpStatus.OK);
	}
}
