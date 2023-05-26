package com.mysite.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysite.dao.UserDao;
import com.mysite.service.UserService;
import com.mysite.vo.UserVo;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	//회원가입폼
	@RequestMapping("/user/joinForm")
	public String joinForm() {
		System.out.println("UserController.joinForm();");
		
		return "/WEB-INF/views/user/joinForm.jsp";
	}
	//회원가입
	@RequestMapping("/user/join")
	public String join(@ModelAttribute UserVo userVo, Model model) {
		System.out.println("UserController.join();");
		
		userService.join(userVo);
		model.addAttribute("joinVo",userVo);
		return "/WEB-INF/views/user/joinOk.jsp";		
	}
	//로그인 폼
	@RequestMapping("/user/loginForm")
	public String loginForm() {
		System.out.println("UserController.loginForm()");
		
		return "/WEB-INF/views/user/loginForm.jsp";
	}
	//로그인
	@RequestMapping("/user/login")
	public String login(@ModelAttribute UserVo uservo,HttpSession session) {
		System.out.println("UserController.login()");
		
		UserVo successUser = userService.login(uservo);
		System.out.println(successUser);
		
		if (successUser != null) {
			System.out.println("로그인성공");
			session.setAttribute("successUser", successUser);
			
			return "/index";
		}else {
			System.out.println("로그인실패");
			return "redirect:/user/loginForm?result=fail";
		}
	}
	//로그아웃
	@RequestMapping("/user/logout")
	public String logout(HttpSession session) {
		System.out.println("UserController.logout()");
		
		session.removeAttribute("successUser");
		session.invalidate();
		
		return "redirect:/index";
	}
	//회원정보폼수정
	@RequestMapping("/user/modifyForm")
	public String modifyform(HttpSession session,Model model) {
		System.out.println("UserController.modifyForm()");
		
		//error null -> 리다이렉트 : login
		UserVo successUser = (UserVo)session.getAttribute("successUser");
		int no = successUser.getNo();
		
		System.out.println(no);
		
		UserVo authUserVo = userService.modifyForm(no);
		System.out.println(authUserVo);
		model.addAttribute("authUserVo", authUserVo);
		
		return "/WEB-INF/views/user/modifyForm.jsp";
	}
	//회원정보수정
	@RequestMapping("/user/modify")
	public String modify(@ModelAttribute UserVo userVo,HttpSession session) {
		System.out.println("UserController.modify()");
				
		userService.modify(userVo);
		UserVo authUser =  (UserVo)session.getAttribute("successUser");
		authUser.setName(userVo.getName());
		String name = "유상우";
		
		
		return "redirect:/user/modifyForm";
	}
	//게스트북
	@RequestMapping("/board/guestForm")
	public String guestForm(@ModelAttribute UserVo userVo) {
		System.out.println("UserController.guestBook()");
	
		
		return "";
	}
}
