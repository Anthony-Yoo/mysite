package com.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.dao.BoardDao;
import com.mysite.vo.BoardVo;
import com.mysite.vo.JsonResult;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	public List<BoardVo> addList() {
		System.out.println("Service.addList()");
		
		return boardDao.SelectGuests();
	}
	
	public int writeGuest(BoardVo boardVo) {
		System.out.println("Service.guestForm()");		
				
		return boardDao.insertBoard(boardVo);
	}
	public int delete(BoardVo boardVo) {
		System.out.println("Service. delete()");
		
		return boardDao.deleteGuest(boardVo);
	}
	public BoardVo addGuest(BoardVo boardVo) {
		System.out.println("Service.guestForm()");		
		boardDao.insertSelectKey(boardVo);
		int no = boardVo.getNo();
		BoardVo boardGuest = boardDao.selectOne(no);
				
		return boardGuest;
	}
	

}
