package com.websvc.webservice.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.websvc.webservice.domain.Posts;

import lombok.Getter;

@Getter
public class PostsMainResDto {

	private Long id;
    private String title;
    private String author;
    private String modifiedDate;

    public PostsMainResDto(Posts entity) {
        id = entity.getId();
        title = entity.getTitle();
        author = entity.getAuthor();
        modifiedDate = toStringDateTime(entity.getModifiedDate()); //view 영역에선 LocalDateTime 타입을 모르기 때문에 인식할 수 있도록 문자열로 날짜형식을 변경해서 등록
    }
    
    /**
     * Java 8 버전
     */
    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }

    /**
     * Java 7 버전
     */
//    private String toStringDateTimeByJava7(LocalDateTime localDateTime){
//        if(localDateTime == null){
//            return "";
//        }
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        return formatter.format(localDateTime);
//    }
}
