package com.websvc.webservice.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.websvc.webservice.domain.Posts;
import com.websvc.webservice.repo.PostsRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepoTest {

	@Autowired
	PostsRepo postsRepo;
	

	@Before
	public void setup() {
		
	}
	
    @Test
    public void test() {
        //given
    	postsRepo.save(Posts.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("jojoldu@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepo.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is("테스트 게시글"));
        assertThat(posts.getContent(), is("테스트 본문"));
    }

    @Test
    public void BaseTimeEntity_등록 () {
        //given
        LocalDateTime now = LocalDateTime.now();
        postsRepo.save(Posts.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("jojoldu@gmail.com")
                .build());
        //when
        List<Posts> postsList = postsRepo.findAll();

        //then
        Posts posts = postsList.get(0);
        assertTrue(posts.getCreatedDate().isAfter(now));
        assertTrue(posts.getModifiedDate().isAfter(now));
    }
    
    @After
    public void cleanup() {
    	/** 
		        이후 테스트 코드에 영향을 끼치지 않기 위해 
		        테스트 메소드가 끝날때 마다 respository 전체 비우는 코드
    	 **/
    	postsRepo.deleteAll();
    }
}
