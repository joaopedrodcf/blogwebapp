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

		Type important = new Type(1, "Important");
		Post manga = new Post("Lorem ipsum.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut dignissim blandit mauris, has egestas nibh efficitur at. Potentially suspend Ut.", important,
				"https://images.unsplash.com/photo-1508384429315-7cf06f2792bb?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=b238991dc14a015785d885cecd81914c&auto=format&fit=crop&w=1350&q=80");

		Type curiosity = new Type(2, "Curiosity");
		Post apples = new Post("Phasellus ullamcorper", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer ex nibh, pharetra at efficitur sed, viverra at nulla. Aenean tincidunt.", curiosity,"https://images.unsplash.com/photo-1517586783515-463aa9571631?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=a8cdbb35e8f6b2f69fa0fbc566dd79be&auto=format&fit=crop&w=634&q=80");

		Type general = new Type(3, "General");
		Post update = new Post("Quisque vitae", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque ut velit in ante porttitor pharetra. Etiam dui purus, ullamcorper in.", general,"https://images.unsplash.com/photo-1501769752-a59efa2298ce?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=5113802ae15a82c47fad708e9d0c9e21&auto=format&fit=crop&w=1350&q=80");

		Type games = new Type(4, "Games");
		Post naruto = new Post("Nulla at ante", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vel metus sapien. Donec purus diam, eleifend vitae posuere et, convallis.", games,"https://images.unsplash.com/photo-1498036882173-b41c28a8ba34?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=11d9d5a5d76bd21f6876c2c3142f4de6&auto=format&fit=crop&w=700&q=80");

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
