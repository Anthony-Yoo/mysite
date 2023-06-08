package com.mysite.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysite.vo.GalleryVo;

@Repository
public class GalleryDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	public GalleryVo selectOne(int no) {
		System.out.println("GalleryDao.selectOne()");
		
		return sqlSession.selectOne("gallery.selectOne", no);
	}
	
	public List<GalleryVo> selectList() {
		System.out.println("GalleryDao.selectList()");		
		
		return sqlSession.selectList("gallery.selectList"); 
	}
	
	public int insertGallery(GalleryVo galleryVo) {
		System.out.println("GalleryDao.insertGallery()");		
		
		System.out.println(galleryVo);
		
		return sqlSession.insert("gallery.insert", galleryVo);
	}
	public int delete(int no) {
		System.out.println("GalleryDao.delete()");
		
		return sqlSession.delete("gallery.delete", no);
	}
	
}
