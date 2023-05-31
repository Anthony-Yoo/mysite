package com.mysite.vo;

//특정페이지의 현재값을 조회하기위한 클래스
public class CriteriaVo {
	private int pageNum; // 현재 페이지번호
	private int amountColumn; // 페이지당 보여질 글의 갯수
	
	public CriteriaVo() {
		//기본생성자 최초 생성시 현재페이지번호,페이지당 보이질 글수 초기세팅 
		this.pageNum = 1;
		this.amountColumn = 10;
	}
	public int getPageStart( ) {
		//특정페이지 구간 범위 지정,현재페이지의 시작 컬럼 번호지정
		//(0~10의 0,11~20의 11)
		return (this.pageNum-1)*amountColumn;
	}
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		//페이지번호는 음수일수없어 1 초기화
		if(pageNum <=0) {
			this.pageNum = 1;
		} else {
			this.pageNum = pageNum;
		}		
	}
	public int getAmountColumn() {
		return amountColumn;
	}
	public void setAmountColumn(int amountColumn) {
		//보여질 게시글 인수 검증후 초기화
		int cnt = this.amountColumn;
		if(amountColumn != cnt) {
			this.amountColumn =cnt;			
		}else {
			this.amountColumn = cnt;
		}		
	}
	@Override
	public String toString() {
		return "CriteriaVo [pageNum=" + pageNum + ", amountColumn=" + amountColumn + "]";
	}
	

}
