package com.websvc.webservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websvc.webservice.dto.PostsMainResDto;
import com.websvc.webservice.dto.PostsSaveReqDto;
import com.websvc.webservice.repo.PostsRepo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsServiceImpl implements PostsService {
	
	private PostsRepo postsRepo;

	@Override
	@Transactional
	public Long save(PostsSaveReqDto dto) {
		return postsRepo.save(dto.toEntity()).getId();
	}

	@Override
	@Transactional(readOnly = true)
	public List<PostsMainResDto> findAllDesc() {
		return postsRepo.findAllByOrderByIdDesc()
						.map(PostsMainResDto::new) // == .map(posts -> new PostsMainResDto(posts))
						.collect(Collectors.toList());
	}

}
