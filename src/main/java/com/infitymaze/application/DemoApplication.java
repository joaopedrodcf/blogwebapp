package com.infitymaze.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infitymaze.application.posts.Post;
import com.infitymaze.application.posts.PostRepository;
import com.infitymaze.application.types.Type;
import com.infitymaze.application.types.TypeRepository;

@SpringBootApplication
@RequestMapping("/api")
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
		
		Type curiosity = new Type(2,"Curiosity");
		Post apples = new Post("Apples are healthy", "It is known as today that apples are healthy",curiosity);
		
		Type general = new Type(3,"General");
		Post update = new Post("Update blog", "This is about the recent update of the blog",general);
		
		Type games = new Type(4,"Games");
		Post naruto = new Post("Naruto", "Awesome game that is about the story of the anime",games);
		
		typeRepository.save(important);
		postRepository.save(manga);
		typeRepository.save(curiosity);
		postRepository.save(apples);
		typeRepository.save(general);
		postRepository.save(update);
		typeRepository.save(games);
		postRepository.save(naruto);
		

	}

}
