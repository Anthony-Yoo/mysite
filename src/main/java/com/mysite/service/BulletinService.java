package com.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.dao.BulletinDao;
import com.mysite.vo.BulletinVo;
import com.mysite.vo.PageVo;

@Service
public class BulletinService {
	
	@Autowired
	private BulletinDao bulletinDao;
	
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
