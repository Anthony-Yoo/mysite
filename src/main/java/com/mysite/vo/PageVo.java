package com.mysite.vo;

//페이지 조회를 위한 VO
public class PageVo {	
	private int totalCount;//전체데이터의 게시글의 수
	private int indexPageNum = 10;//LIST페이지에 보여질 페이지번호의 갯수
	
	private int startPage;//화면의 시작번호
	private int endPage;//화면의 끝번호
	private boolean prev;//페이징 이전번호 활성화 여부	
	private boolean next;//페이징 다음번호 활성화 여부
	private CriteriaVo cri;//특정 페이지처리 Vo  클래스 변수 선언
	
			
	public PageVo() {
		// TODO Auto-generated constructor stub
	}
	public PageVo(int totalCount, int indexPageNum, int startPage, int endPage,
			boolean prev, boolean next) {		
		this.totalCount = totalCount;
		this.indexPageNum = indexPageNum;
		this.startPage = startPage;
		this.endPage = endPage;
		this.prev = prev;
		this.next = next;
	}
	
	public int getTotalCount() {
		return totalCount;		
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		pagingCalc();
	}
	private void pagingCalc() {
		//endPage = (현재 페이지 번호 / 화면에 보여질 페이지 번호의 개수) * 화면에 보여질 페이지 번호의 개수
		int endPage = (int)(Math.ceil((cri.getPageNum()/this.indexPageNum)*this.indexPageNum));
		// startPage = (끝 페이지 번호 - 화면에 보여질 페이지 번호의 개수) + 1
		int startPage = (this.endPage - this.indexPageNum) + 1;
		// 마지막 페이지 번호(temp) = 총 게시글 수 / 한 페이지당 보여줄 게시글의개수
		int tempEndPage = (int)(Math.ceil(this.totalCount / cri.getAmountColumn()));
		if (endPage>tempEndPage) {
			endPage = tempEndPage;
		}
		// 이전 버튼 생성 여부 = 시작 페이지 번호가 1과 같으면 false, 아니면 true
		prev = startPage == 1 ? false : true;
		// 다음 버튼 생성 여부 = 마지막 페이지 번호 * 한페이지당 보여주는 글의 갯수가 총 게시글의 수보다 크거나 같으면 false, 아니면 true
		next = endPage * cri.getAmountColumn() >= totalCount ? false : true;		
	}
	public int getIndexPageNum() {
		return indexPageNum;
	}
	public void setIndexPageNum(int indexPageNum) {
		this.indexPageNum = indexPageNum;
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
	
	public CriteriaVo getCri() {
		return cri;
	}

	public void setCri(CriteriaVo cri) {
		this.cri = cri;
	}

	@Override
	public String toString() {
		return "PageVo [totalCount=" + totalCount + ", indexPageNum=" + indexPageNum + ", startPage=" + startPage
				+ ", endPage=" + endPage + ", prev=" + prev + ", next=" + next + ", cri=" + cri + "]";
	}
	
	
	
	
	
	

}
