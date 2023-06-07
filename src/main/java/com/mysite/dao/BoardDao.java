package com.mysite.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysite.vo.BoardVo;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardVo> SelectGuests() {
		System.out.println("Dao.SelectGuests()");
		
		return sqlSession.selectList("board.selectList");
	}
	
	public int insertBoard(BoardVo boardVo) {
		System.out.println("Dao.insertBoard()");
		System.out.println(boardVo);
		
		return sqlSession.insert("board.insert", boardVo);	
	}
	public int deleteGuest(BoardVo boardVo) {
		System.out.println("Dao.deleteGuest()");
		System.out.println(boardVo);
		
		return sqlSession.delete("board.delete", boardVo);		
	}
	public int insertSelectKey(BoardVo boardVo) {
		System.out.println("Dao.insertSelectKey()");
		System.out.println(boardVo);		
		
		return sqlSession.insert("board.insertSelectKey", boardVo);
	}
	public BoardVo selectOne(int no) {
		System.out.println("Dao.selectOne()");
		
		return sqlSession.selectOne("board.selectOne", no);
	}
	
	
}
