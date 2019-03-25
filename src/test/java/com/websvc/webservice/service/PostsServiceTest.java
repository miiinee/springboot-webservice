package com.websvc.webservice.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.websvc.webservice.domain.Posts;
import com.websvc.webservice.dto.PostsSaveReqDto;
import com.websvc.webservice.repo.PostsRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {

	@Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepo postsRepo;
    
    
	@Test
	public void Dto데이터가_posts테이블에_저장된다() {
		//given
        PostsSaveReqDto dto = PostsSaveReqDto.builder()
                .author("jojoldu@gmail.com")
                .content("테스트")
                .title("테스트 타이틀")
                .build();

        //when
        postsService.save(dto);

        //then
        Posts posts = postsRepo.findAll().get(0);
        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
	}

	@After
	public void cleanup () {
		postsRepo.deleteAll();
	}
}
