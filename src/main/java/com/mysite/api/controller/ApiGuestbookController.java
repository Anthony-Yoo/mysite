package com.mysite.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysite.service.BoardService;
import com.mysite.vo.BoardVo;
import com.mysite.vo.JsonResult;

@Controller
public class ApiGuestbookController {
	
	@Autowired
	private BoardService boardServise;

	//ajax 방명록 첫화면
	@RequestMapping(value="/api/guestbook/addList",method= {RequestMethod.GET,RequestMethod.POST})
	public String addList(Model model) {
		System.out.println("ApiGuestbookController.addList()");
		
		List<BoardVo> boardList =  boardServise.addList();
		model.addAttribute("boardList", boardList);
		System.out.println(boardList);		
		
		return "/WEB-INF/views/guestbook/ajaxList.jsp";
	}
	@ResponseBody
	@RequestMapping(value="/api/guestbook/add",method={RequestMethod.GET,RequestMethod.POST}) 
	public JsonResult add(@ModelAttribute BoardVo boardVo) {
		System.out.println("ApiGuestbookController.add()");
				
		BoardVo boardGuest = boardServise.addGuest(boardVo);
		JsonResult jsonResult = new JsonResult();
		jsonResult.success(boardGuest);
		
		return jsonResult;
		
	}
	 

}
