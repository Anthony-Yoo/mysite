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
	
	//방명록 첫페이지(ajax리스트 출력)
	@RequestMapping(value="/api/guestbook/addList2",method= {RequestMethod.GET,RequestMethod.POST})
	public String addList2() {
		System.out.println("ApiGuestbookController.addList2()");		
		
		return "/WEB-INF/views/guestbook/ajaxList2.jsp";		
	}
	//ajax 전체 리스트 가져오기
	@ResponseBody
	@RequestMapping(value="/api/guestbook/list",method= {RequestMethod.GET,RequestMethod.POST})
	public JsonResult getList(Model model) {
		System.out.println("ApiGuestbookController.getList()");
		
		List<BoardVo> boardList =  boardServise.addList();
		System.out.println(boardList);
		JsonResult jsonResult = new JsonResult();
		jsonResult.success(boardList);		
		
		
		return jsonResult;
		
	}
	//Json 데이터 등록하기	
	@ResponseBody
	@RequestMapping(value="/api/guestbook/add2",method={RequestMethod.GET,RequestMethod.POST}) 
	public JsonResult add2(@RequestBody BoardVo boardVo) {
		System.out.println("ApiGuestbookController.add2()");
				
		BoardVo boardGuest = boardServise.addGuest(boardVo);
		JsonResult jsonResult = new JsonResult();
		jsonResult.success(boardGuest);
		
		return jsonResult;
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
	@ResponseBody
	@RequestMapping(value="/api/guestbook/remove",method={RequestMethod.GET,RequestMethod.POST})
	public JsonResult remove(@ModelAttribute BoardVo boardVo) {
		System.out.println("ApiGuestbookController.remove()");
		System.out.println(boardVo);
		
		JsonResult jsonResult = new JsonResult();		
		jsonResult.success(boardServise.delete(boardVo));
		
		System.out.println(jsonResult);
		
		return jsonResult;
	}
	 

}
