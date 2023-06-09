package com.mysite.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysite.vo.BulletinVo;

@Repository
public class BulletinDao {
	
	@Autowired
	private SqlSession sqlsession;
	
	public List<BulletinVo> List4(int startRnum,int endRnum,String keyword) {
		System.out.println("BulletinDao.selectList()");
		System.out.println(startRnum+" "+endRnum);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startRnum", startRnum);
		map.put("endRnum", endRnum);
		map.put("keyword",keyword);
		
		List<BulletinVo> bulletinlist = sqlsession.selectList("bulletin.List4",map);
		System.out.println(bulletinlist);		
		
		return bulletinlist;
	}
	
	public List<BulletinVo> List3(int startRnum,int endRnum) {
		System.out.println("BulletinDao.selectList()");
		System.out.println(startRnum+" "+endRnum);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRnum", startRnum);
		map.put("endRnum", endRnum);
		
		List<BulletinVo> bulletinlist = sqlsession.selectList("bulletin.List3",map);
		System.out.println(bulletinlist);
		
		
		return bulletinlist;
	}
	public int selectCount(String keyword) {
		System.out.println("BulletinDao.selectCount()");
		
		return sqlsession.selectOne("bulletin.selectCount2",keyword);		
	}
	
	public int totalCount() {
		System.out.println("BulletinDao.totalCount()");
		
		return sqlsession.selectOne("bulletin.totalCount");
		
	}
	public int selectCount() {
		System.out.println("BulletinDao.selectCount()");
		
		return sqlsession.selectOne("bulletin.selectCount()");
		
	}	
	public int insertBulletin(BulletinVo bulletinVo) {
		System.out.println("BulletinDao.insertBulletin()");		
		
		return sqlsession.insert("bulletin.insert", bulletinVo);			
	}
	public List<BulletinVo> List() {
		System.out.println("BulletinDao.selectList()");
		
		List<BulletinVo> bulletinlist = sqlsession.selectList("bulletin.List");	
		return bulletinlist;
	}
	public List<BulletinVo> ListWithPaging(BulletinVo bulletinVo) {
		System.out.println("BulletinDao.selectList()");
		
		List<BulletinVo> bulletinlist = sqlsession.selectList("bulletin.pagingList",bulletinVo);	
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
