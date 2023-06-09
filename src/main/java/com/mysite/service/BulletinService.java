package com.mysite.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.dao.BulletinDao;
import com.mysite.vo.BulletinVo;
import com.mysite.vo.PageVo;

@Service
public class BulletinService {
	
	@Autowired
	private BulletinDao bulletinDao;
	
	
	//게시판 리스트 페이징 포함//
	public Map<String, Object> list4(int crtPage,String keyword) {
			System.out.println("BulletinService.list4()");
			System.out.println(crtPage);
			///////////////////////////////////////////////////////////
			//키워드 검색
			///////////////////////////////////////////////////////////
			//bulletinDao.selectKeyword(keyword);
			//총 키워드 글갯수
			int totalCount = bulletinDao.selectCount(keyword);
			
			///////////////////////////////////////////////////////////
			//리스팅 계산
			///////////////////////////////////////////////////////////
			crtPage = (crtPage >=1) ? crtPage : (crtPage=1) ;
			
			//page당 글의 숫자(listCnt) : 10
			int listCnt = 10;
			
			//1-10, 11-20
			//rownum 번호를 구해야한다
			//startRnum - endRnum
			
			//시작글번호 (startRnum)
			int startRnum = (crtPage-1) * listCnt + 1;
			
			//마지막글번호(endRnum)
			int endRnum = startRnum + (listCnt-1);
			
			///////////////////////////////////////////////////////////
			//페이징 계산
			///////////////////////////////////////////////////////////
			
			//페이징당 버튼 갯수( 1 - 5 )
			int pageBtnCount = 5;
			//마지막 버튼 번호
			//1 -> 1~5
			//5 --> 1~5
			//6 --> 6~10
			
			int endPageBtnNo = (int)Math.ceil(crtPage/(double)pageBtnCount)*pageBtnCount;
			
			//시작버튼 번호
			int startPageBtnNo = (endPageBtnNo-pageBtnCount)+1;
			
			
			//진짜 마지막번호
			
			//Next 화살표 Boolean true / false
			boolean next = false;		
			//총객수 123
			//endPageBtn * listCtn = 10*10 = 100
			
			if ((endPageBtnNo*listCnt) < totalCount) {
				next = true;
			}else {
				next = false;
				//끝번호 계산 endPageBtnNo 다시계산
				endPageBtnNo =  (int)Math.ceil(totalCount /(double)listCnt);
			}		
			//Prev 화살표
			boolean prev = false;
			if(startPageBtnNo != 1) {
				prev = true;			
			}
			List<BulletinVo> bulletinList = bulletinDao.List4(startRnum,endRnum,keyword);
			
			Map<String, Object> pMap = new HashMap<String, Object>();
			pMap.put("prev",prev);
			pMap.put("next",next);
			pMap.put("endPageBtnNo",endPageBtnNo);
			pMap.put("startPageBtnNo",startPageBtnNo);
			pMap.put("bulletinList",bulletinList);
			
			System.out.println(pMap);
			
			return pMap; 		
	}
	
	
	//게시판 리스트 페이징 포함//
	public Map<String, Object> list3(int crtPage) {
		System.out.println("BulletinService.list3()");
		System.out.println(crtPage);
		
		///////////////////////////////////////////////////////////
		//리스팅 계산
		///////////////////////////////////////////////////////////
		crtPage = (crtPage >=1) ? crtPage : (crtPage=1) ;
		
		//page당 글의 숫자(listCnt) : 10
		int listCnt = 10;
		//1-10, 11-20
		//rownum 번호를 구해야한다
		//startRnum - endRnum
		
		//시작글번호 (startRnum)
		int startRnum = (crtPage-1) * listCnt + 1;
		
		//마지막글번호(endRnum)
		int endRnum = startRnum + (listCnt-1);
		
		///////////////////////////////////////////////////////////
		//페이징 계산
		///////////////////////////////////////////////////////////
		
		//페이징당 버튼 갯수( 1 - 5 )
		int pageBtnCount = 5;
		//마지막 버튼 번호
		//1 -> 1~5
		//5 --> 1~5
		//6 --> 6~10
		
		int endPageBtnNo = (int)Math.ceil(crtPage/(double)pageBtnCount)*pageBtnCount;
		
		//시작버튼 번호
		int startPageBtnNo = (endPageBtnNo-pageBtnCount)+1;
		

		//총 글갯수
		int totalCount = bulletinDao.totalCount();
		//진짜 마지막번호
		
		//Next 화살표 Boolean true / false
		boolean next = false;		
		//총객수 123
		//endPageBtn * listCtn = 10*10 = 100
		
		if ((endPageBtnNo*listCnt) < totalCount) {
			next = true;
		}else {
			next = false;
			//끝번호 계산 endPageBtnNo 다시계산
			endPageBtnNo =  (int)Math.ceil(totalCount /(double)listCnt);
		}		
		//Prev 화살표
		boolean prev = false;
		if(startPageBtnNo != 1) {
			prev = true;			
		}
		List<BulletinVo> bulletinList = bulletinDao.List3(startRnum,endRnum);
		
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("prev",prev);
		pMap.put("next",next);
		pMap.put("endPageBtnNo",endPageBtnNo);
		pMap.put("startPageBtnNo",startPageBtnNo);
		pMap.put("bulletinList",bulletinList);
		System.out.println(pMap);
		return pMap; 		
	}
	
	
	public int write(BulletinVo bulletinVo) {
		System.out.println("BulletinService.write()");
						
		return bulletinDao.insertBulletin(bulletinVo);
	}

	public List<BulletinVo> list() {
		System.out.println("BulletinService.list()");
		
		List<BulletinVo> bulletinList = bulletinDao.List();
//		List<BulletinVo> bulletinList = bulletinDao.ListWithPaging(bulletinVo);
		
		return bulletinList; 		
	}
	public BulletinVo view(int no) {
		System.out.println("BulletinService.view()");
		
		return bulletinDao.selectOne(no);
	}
	public int viewCount(int no) {
		System.out.println("BulletinService.viewForm()");	
		
		return bulletinDao.updateCount(no);		
	}
	public int delete(int no) {
		System.out.println("BulletinService.delete()");
				
		return bulletinDao.delete(no);
	}
	public int modify(BulletinVo bulletinVo) {
		System.out.println("BulletinService.modify()");
		
		return bulletinDao.updateOne(bulletinVo);	
	}
	public List<BulletinVo>  search(String keyword) {
		System.out.println("BulletinService.search");
		
		return bulletinDao.selectKeyword(keyword);
		
	}
}
