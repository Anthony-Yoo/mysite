package com.mysite.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysite.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int insertUser(UserVo userVo) {
		System.out.println("Dao.insertUser()");
		System.out.println(userVo);
		
		int count = sqlSession.insert("user.insert",userVo);
		
		return count;
		
	}
	public UserVo selectUser(UserVo userVo) {
		System.out.println("Dao.selectUser()");
		System.out.println(userVo);
		
		return sqlSession.selectOne("user.selectOne",userVo);		
	}
	public UserVo selectUser(int no) {
		System.out.println("Dao.selectUser");
		System.out.println(no);			
		return sqlSession.selectOne("user.selectOne_n", no);
	}
	public int updateUser(UserVo userVo) {
		System.out.println("UserDao.updateUser()");
		System.out.println(userVo);
		return sqlSession.update("user.updateOne", userVo);
	}
	public UserVo selectId(String id) {
		System.out.println("UserDao.selectId()");
		
		return sqlSession.selectOne("user.selectId", id);
				
		
	}
}
