package com.infitymaze.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infitymaze.application.posts.Post;
import com.infitymaze.application.posts.PostRepository;
import com.infitymaze.application.types.Type;
import com.infitymaze.application.types.TypeRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private TypeRepository typeRepository;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		postRepository.deleteAllInBatch();
		typeRepository.deleteAllInBatch();

		Type important = new Type(1,"Important");

		Post manga = new Post("Manga", "This is a content about manga",important);
		
		typeRepository.save(important);
		postRepository.save(manga);
		

	}

}
