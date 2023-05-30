package com.mysite.vo;

import java.util.List;

public class BulletinVo {
	private int no;
	private String title;
	private String content;
	private int hit;
	private String reg_date;
	private int user_no;
	private String name;
	private List<BulletinVo> bulletinList;
	
	
	public BulletinVo(int no, String title, String content, int hit, String reg_date, int user_no, String name,
			List<BulletinVo> bulletinList) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.reg_date = reg_date;
		this.user_no = user_no;
		this.name = name;
		this.bulletinList = bulletinList;
	}
	public BulletinVo() {
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<BulletinVo> getBulletinList() {
		return bulletinList;
	}
	public void setBulletinList(List<BulletinVo> bulletinList) {
		this.bulletinList = bulletinList;
	}
	@Override
	public String toString() {
		return "BulletinVo [no=" + no + ", title=" + title + ", content=" + content + ", hit=" + hit + ", reg_date="
				+ reg_date + ", user_no=" + user_no + ", name=" + name + ", bulletinList=" + bulletinList + "]";
	}
	
	
	

}
