package com.websvc.webservice.controller;

import java.util.Arrays;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.websvc.webservice.dto.PostsSaveReqDto;
import com.websvc.webservice.service.PostsService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor //모든 필드를 인자값으로 하는 생성자 생성(Lombok)
public class WebRestController {

	/******************************
	 * Beam 주입받는 방식
	 * 1)@Autowired -> 비권장방식
	 * 2)setter
	 * 3)생성자
	 ******************************/
	private PostsService postsService;
	private Environment env;
	
//	private PostsRepo postsRepo;
	
	//@AllArgsContstuctor 로 인행 생기는 생성자 형태
//	public WebRestController(PostsRepo postsRepo) {
//        this.postsRepo = postsRepo;
//    }
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello World!!!";
	}
	
	@PostMapping("/posts")
	public void savePosts(@RequestBody PostsSaveReqDto dto) {
		postsService.save(dto);
	}
	
	@GetMapping("/profile")
    public String getProfile () {
        return Arrays.stream(env.getActiveProfiles())
                .findFirst()
                .orElse("");
    }
}
