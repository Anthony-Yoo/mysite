package com.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.dao.UserDao;
import com.mysite.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	//회원등록
	public int join(UserVo userVo) {
		System.out.println("Service.join()");
		
		int count = userDao.insertUser(userVo);
		
		return count;
	}
	public UserVo login(UserVo userVo) {
		System.out.println("Service.login()");
		
		return userDao.selectUser(userVo);
		
	}
	public UserVo modifyForm(int no) {
		System.out.println("UserService.modifyForm()");		
		
		return userDao.selectUser(no);
	}
	public int modify(UserVo userVo) {
		System.out.println("UserService.modify()");
		
		return userDao.updateUser(userVo);
	}
}
