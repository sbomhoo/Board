package com.gglee.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * 게시판 테이블의 데이터를 구조화 시킬 때 사용하는 클래스이다.<br>
 * 계층간의 데이터 교환을 위해 사용하는 자바빈즈이다.
 * 
 * @author gglee
 */
@Alias("board")
public class BoardVO {
	
	private Integer bno;	// 번호
	private String title;	// 제목
	private String content; // 내용 
	private String writer;  // 작성자
	private Date regdate;   // 등록 날짜
	private int viewcnt;    // 조회 카운트

	/**
	 * 게시글 클래스 기본 생성자
	 */
	public BoardVO() {
		// empty
	}
	
	public Integer getBno() {
		return bno;
	}

	public void setBno(Integer bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

}
