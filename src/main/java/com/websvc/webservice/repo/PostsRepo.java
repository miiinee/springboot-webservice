package com.websvc.webservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websvc.webservice.domain.Posts;

public interface PostsRepo extends JpaRepository<Posts, Long>{

}
