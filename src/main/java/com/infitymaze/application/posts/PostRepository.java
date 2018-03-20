package com.infitymaze.application.posts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.infitymaze.application.types.Type;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

	//solution: https://stackoverflow.com/questions/37178520/jpql-like-case-insensitive
	@Query("select p from Post p where UPPER(p.title) like  UPPER(concat('%', :name,'%')) or UPPER(p.content) like UPPER(concat('%', :name,'%'))")
	List<Post> filterPostsName(@Param("name") String name);
    	 
	@Query("select p from Post p "
			+ "where ( UPPER(p.title) like  UPPER(concat('%', :name,'%')) "
			+ "or UPPER(p.content) like UPPER(concat('%', :name,'%')) )"
			+ "and p.type in :types")
	List<Post> filterPosts(@Param("name") String name, @Param("types") Type[] types);
}
