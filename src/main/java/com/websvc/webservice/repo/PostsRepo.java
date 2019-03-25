package com.websvc.webservice.repo;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websvc.webservice.domain.Posts;

public interface PostsRepo extends JpaRepository<Posts, Long>{

	 Stream<Posts> findAllByOrderByIdDesc();

//	 @Query("SELECT p " +
//	            "FROM Posts p " +
//	            "ORDER BY p.id DESC")
//    Stream<Posts> findAllDesc();
}
