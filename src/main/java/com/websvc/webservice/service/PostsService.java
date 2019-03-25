package com.websvc.webservice.service;

import java.util.List;

import com.websvc.webservice.dto.PostsMainResDto;
import com.websvc.webservice.dto.PostsSaveReqDto;

public interface PostsService {

	public Long save(PostsSaveReqDto dto);
	
	public List<PostsMainResDto> findAllDesc();
}
