package com.mysite.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysite.service.BoardService;
import com.mysite.vo.BoardVo;

@Controller
public class BoardController {
	//게스트북
		@Autowired
		private BoardService boardService;
	
		@RequestMapping("/board/addList")
		public String addList(Model model) {			
			System.out.println("BoardController.guestBook()");
			
			List<BoardVo> guestList =  boardService.addList();
		
			model.addAttribute("guestList", guestList);
			 
			return "/WEB-INF/views/guestbook/addList.jsp";
		}
		@RequestMapping("/board/writeGuest")
		public String writeGuest(@ModelAttribute BoardVo boardVo,HttpSession session) {
			System.out.println("BoardController.writeGuest()");
			
			boardService.writeGuest(boardVo);			
			
			return "/board/addList";
		}		
		@RequestMapping("/board/deleteForm")
		public String deleteForm() {
			System.out.println("BoardController.deleteForm()");			
			
			
			return "/WEB-INF/views/guestbook/deleteForm.jsp";
			
		}

		@RequestMapping("/board/delete")
		public String delete(@ModelAttribute BoardVo boardVo) {
			System.out.println("BoardController.delete()");
			
			boardService.delete(boardVo);
			
			return "redirect:/board/addList";
			
		}

}
