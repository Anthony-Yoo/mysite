package com.mysite.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysite.vo.BulletinVo;

@Repository
public class BulletinDao {
	
	@Autowired
	private SqlSession sqlsession;
	
	public int insertBulletin(BulletinVo bulletinVo) {
		System.out.println("BulletinDao.insertBulletin()");		
		
		return sqlsession.insert("bulletin.insert", bulletinVo);			
	}
	public List<BulletinVo> selectList() {
		System.out.println("BulletinDao.selectList()");
		
		List<BulletinVo> bulletinlist = sqlsession.selectList("bulletin.selectList");	
		return bulletinlist;
	}
	public int updateCount(int no) {
		System.out.println("BulletinDao.updateCount()");		
		
		return sqlsession.update("bulletin.updateCount",no);
	}	
	public BulletinVo selectOne(int no) {
		System.out.println("BulletinDao.selectOne()");		
		
		return sqlsession.selectOne("bulletin.selectOne", no);
	}
	public int delete(int no) {
		System.out.println("BulletinDao.delete()");
		
		return sqlsession.delete("bulletin.delete", no);
	}
	public int updateOne(BulletinVo bulletinVo) {
		System.out.println("BulletinDao.updateOne()");
		
		return sqlsession.update("bulletin.updateOne", bulletinVo);
	}
	public List<BulletinVo> selectKeyword(String keyword) {
		System.out.println("BulletinDao.selectKeyword()");
		
		return sqlsession.selectList("bulletin.selectKeyword", keyword);
	}
	
}
