package com.websvc.webservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//기본 생성자 자동 추가, 기본생성자의 접근 권한을 protected로 제한
//생성자로 protected Posts(){}와 같은 효과
//Entity 클래스를 프로젝트 코드상에서 기본생성자로 생성하는 것은 막되, JPA에서 Entity 클래스를 생성하는것은 허용하기 위해 추가
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Posts extends BaseTimeEntity {

	/* Hibernate의 id생성 전략을 결정하는 useNewIdGeneratorMappings = true(spring boot 2.0)/false(1.5)
	 * Hibernate 5.0부터 MySQL의 AUTO는 IDENTITY가 아닌 TABLE을 기본 시퀀스 전략으로 선택된다.
	 * 즉, 1.5에선 Hibernate 5를 쓰더라도 AUTO를 따라가지 않기 때문에 IDENTITY가 선택
	 * 2.0에선 true이므로 Hibernate 5를 그대로 따라가기 때문에 TABLE이 선택
	 * 방안1)application.properties(yml) 설정 변경 : spring: jpa: hibernate: use-new-id-generator-mappings: false
	 * 방안2)@GeneratedValue(strategy = GenerationType.IDENTITY)
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    //해당 클래스의 빌더패턴 클래스를 생성
    //생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}