package com.infitymaze.application.types;

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
@RequestMapping("/type")
public class TypeRestController {

	private final TypeRepository typeRepository;

	@Autowired
	TypeRestController(TypeRepository postTypeRepository) {
		this.typeRepository = postTypeRepository;
	}

	@GetMapping
	@CrossOrigin(origins = { "http://localhost:3000" })
	public ResponseEntity<List<Type>> getAllTypes() {

		List<Type> types = (List<Type>) typeRepository.findAll();

		if (types == null)
			return new ResponseEntity<List<Type>>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Type>>(types, HttpStatus.OK);
	}
	
	@DeleteMapping
	@CrossOrigin(origins = { "http://localhost:3000" })
	public ResponseEntity<Void> deleteAllTypes() {

		typeRepository.deleteAll();

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping
	@CrossOrigin(origins = { "http://localhost:3000" })
	public ResponseEntity<Void> insertType(@RequestBody Type type) {

		typeRepository.save(type);
		return new ResponseEntity<Void>(HttpStatus.CREATED);

	}

	@GetMapping("/{id}")
	@CrossOrigin(origins = { "http://localhost:3000" })
	public ResponseEntity<Type> getType(@PathVariable Long id) {
		Type type = typeRepository.findOne(id);

		if (type == null)
			return new ResponseEntity<Type>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<Type>(type, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@CrossOrigin(origins = { "http://localhost:3000" })
	public ResponseEntity<Type> updateType(@PathVariable Long id, @RequestBody Type type) {
		Type currentType = typeRepository.findOne(id);

		if (currentType == null)
			return new ResponseEntity<Type>(HttpStatus.NOT_FOUND);

		currentType.setType(type.getType());
		typeRepository.save(currentType);

		return new ResponseEntity<Type>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	@CrossOrigin(origins = { "http://localhost:3000" })
	public ResponseEntity<Void> deleteType(@PathVariable Long id) {

		Type type = typeRepository.findOne(id);

		if (type == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

		typeRepository.delete(type);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
