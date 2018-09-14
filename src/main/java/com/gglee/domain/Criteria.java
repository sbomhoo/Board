package com.gglee.domain;

/**
 * 검색 정보를 관리하는 모델 클래스 
 * 
 * @author gglee
 */
public class Criteria {
	
	private int page = 1;
	private int perPageNum = 10;
	
	public Criteria() {}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
			return;
		}

		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		if(perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}

		this.perPageNum = perPageNum;
	}
	
	public int getPageStart() {
		return (this.page - 1) * perPageNum;
	}
	
	@Override
	public String toString() {
		return "[page=" + page + ", " + "perPageNum=" + perPageNum +"]";
	}

}
