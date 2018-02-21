package com.infitymaze.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infitymaze.application.posts.Post;
import com.infitymaze.application.posts.PostRepository;
import com.infitymaze.application.types.PostType;
import com.infitymaze.application.types.PostTypeRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private PostTypeRepository postTypeRepository;

	public static void main(String[] args) throws Exception {
        SpringApplication.run(DemoApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		postRepository.deleteAllInBatch();
		postTypeRepository.deleteAllInBatch();
		
		PostType important = new PostType(1,"Important");
		PostType generic = new PostType(2,"Generic");
		PostType flash = new PostType(3,"Flash");
		
		postTypeRepository.save(important);
		postTypeRepository.save(generic);
		postTypeRepository.save(flash);
	}
	
	

}
