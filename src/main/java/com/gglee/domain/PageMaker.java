package com.gglee.domain;

/**
 * 페이징 처리를 전담하는 클래스
 * 
 * @author gglee
 */
public class PageMaker {
	
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	// 페이지 번호를 몇 개씩 구분할지 나타내는 변수
	// 기본값은 10. 10개의 페이지 번호를 출력한다. 
	private int displayPageNum = 10;
	
	private Criteria criteria;
	
	public PageMaker() {}
	
	public PageMaker(Criteria criteria) {
		this.criteria = criteria;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		// 게시글 전체 개수 데이터를 전달 받으면 페이지 관련 변수를 구하기 위해서 연산을 수행한다.
		calculatePagingData();
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public Criteria getCriteria() {
		return criteria;
	}

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}
	
	/**
	 * 페이징 처리를 위한 변수 값을 계산한다.
	 * 
	 * <p>시작 페이지, 마지막 페이지, 이전 페이지 존재 여부, 다음 페이지 존재 여부에 해당하는 변수에
	 * 값을 넣기 위해 계산한다.</p> 
	 */
	private void calculatePagingData() {
		endPage = (int) (Math.ceil(criteria.getPage() / (double) displayPageNum) * displayPageNum);

		startPage = (endPage - displayPageNum) + 1;

		int tempEndPage = (int) (Math.ceil(totalCount / (double) criteria.getPerPageNum()));

		// 수식에 의한 마지막 페이지 값과 실제 데이터 값을 이용한 구한 마지막 페이지 값을 비교한다.
		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		prev = startPage == 1 ? false : true;
		next = endPage * criteria.getPerPageNum() >= totalCount ? false : true;
	}
	
}
