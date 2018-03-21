package com.infitymaze.application.posts;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends PagingAndSortingRepository<Post, Long> {

	@Query("select p from Post p " + "where UPPER(p.title) like  UPPER(concat('%', :name,'%')) "
			+ "or UPPER(p.content) like UPPER(concat('%', :name,'%'))")
	List<Post> filterPostsByName(@Param("name") String name);

	// solution:
	// https://stackoverflow.com/questions/37178520/jpql-like-case-insensitive
	@Query("select p from Post p JOIN p.type t where ( UPPER(p.title) like  UPPER(concat('%', :name,'%')) "
			+ "or UPPER(p.content) like UPPER(concat('%', :name,'%')) )" + "and t.name in :types")
	List<Post> filterPostByNameAndType(@Param("name") String name, @Param("types") String[] types);
	

}
