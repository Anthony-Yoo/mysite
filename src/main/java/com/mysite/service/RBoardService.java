package com.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.dao.BulletinDao;
import com.mysite.vo.BulletinVo;

@Service
public class RBoardService {
	
	@Autowired
	private RBoardDao rBoardDao;
	
	public int write(rBoardVo rBoardVo) {
		System.out.println("rBoardService.write()");
						
		return rBoardDao.insertrBoard(rBoardVo);
	}
	public List<rBoardVo> list(rBoardVo rBoardVo) {
		System.out.println("rBoardService.list()");
		
		List<rBoardVo> rBoardList = rBoardDao.List();
//		List<rBoardVo> rBoardList = rBoardDao.ListWithPaging(rBoardVo);
		
		return rBoardList; 		
	}
	/*
	 * public rBoardVo view(int no) { System.out.println("rBoardService.view()");
	 * 
	 * return rBoardDao.selectOne(no); } public int viewCount(int no) {
	 * System.out.println("rBoardService.viewForm()");
	 * 
	 * return rBoardDao.updateCount(no); } public int delete(int no) {
	 * System.out.println("rBoardService.delete()");
	 * 
	 * return rBoardDao.delete(no); } public int modify(rBoardVo rBoardVo) {
	 * System.out.println("rBoardService.modify()");
	 * 
	 * return rBoardDao.updateOne(rBoardVo); } public List<rBoardVo> search(String
	 * keyword) { System.out.println("rBoardService.search");
	 * 
	 * return rBoardDao.selectKeyword(keyword);
	 * 
	 * }
	 */
}
