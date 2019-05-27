package org.zerock.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	private int pageNum;
	private int amount;
	
	private String type;
	private String keyword;
	
	//기본 생성자 기본값 1페이지, 10개
	public Criteria () {
		this(1,10);
	}
	
	public Criteria (int pageNum, int amount) {
		this.pageNum=pageNum;
		this.amount=amount;
	}
	
	//Title, Writer, Content 를 배열로 처리
	//mapper에서 sql 조건문 처리시 사용
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}
	
	//URIComponentsBuilder
	public String getListLink() {
		//브라우저상 GET 방식의 파라미터 전송에 사용되는 쿼리문자열 처리
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", this.getPageNum())
				.queryParam("amount", this.getAmount())
				.queryParam("type", this.getType())
				.queryParam("keyword", this.getKeyword());
				
				return builder.toUriString();
	}
	
}
