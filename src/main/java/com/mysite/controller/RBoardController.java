package com.mysite.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.service.BulletinService;
import com.mysite.service.RBoardService;
import com.mysite.vo.RBoardVo;

@Controller
public class RBoardController {
		
		@Autowired
		private RBoardService rBoardService;
		
		
		@RequestMapping(value = "/rBoard/writeForm",method = {RequestMethod.GET,RequestMethod.POST})
		public String writeForm(@ModelAttribute RBoardVo rBoardVo,Model model) {
			System.out.println("rBoardController.writeForm()");
			System.out.println(rBoardVo);
			
//			rBoardService.writeForm(rBoardVo);
			
			return "/WEB-INF/views/rBoard/writeForm.jsp";
			
		}		
//		
//		
//		@RequestMapping("/rBoard/write")
//		public String write(@ModelAttribute BoardVo BoardVo,HttpSession session) {
//			System.out.println("rBoardController.write()");
//			
//			UserVo rBoardUser = (UserVo)session.getAttribute("successUser");
//			BoardVo.setUser_no(rBoardUser.getNo());
////			System.out.println(rBoardUser.getNo());
////			System.out.println(BoardVo);
//			rBoardService.write(BoardVo);
//			
//			return "redirect:/rBoard/list";
//		}
//		
//		
//		
//		@RequestMapping(value = "/rBoard/list",method = {RequestMethod.GET,RequestMethod.POST})
//		public String ListandCount(@ModelAttribute RBoardVo rBoardVo, Model model) {
//			System.out.println("RBoardController.ListandCouint");			
//						
//			List<RBoardVo> rBoardList = rBoardService.list(rBoardVo);
//			System.out.println(rboardList);		
//			model.addAttribute("rboardList",rboardList);
//			
//			
//			return "/WEB-INF/views/rBoard/list.jsp";
//		}
//		
//		
		
		
		
		
		
		/*
		 * @RequestMapping("/rBoard/search") public String search(@RequestParam String
		 * keyword,Model model) { System.out.println("rBoardController.search()");
		 * 
		 * List<BoardVo> keyList = rBoardService.search(keyword);
		 * System.out.println("keyList"); model.addAttribute("boardList", keyList);
		 * 
		 * return "/WEB-INF/views/rBoard/list.jsp"; }
		 */
		/*
		 * @RequestMapping("/rBoard/list") 
		 * public ModelAndView list(ModelAndView mav) { 
		 * System.out.println("rBoardController.list()");
		 * 
		 * List<HashMap<String, Object>> rBoardList = rBoardService.list();
		 * System.out.println(rBoardList); 
		 * mav.addObject("bList", rBoardList);
		 * mav.setViewName("/WEB-INF/views/rBoard/list.jsp");
		 * 
		 * return mav; }
		 */
		
		/*
		 * @RequestMapping("rBoard/viewForm") public String viewForm(@RequestParam int
		 * no,Model model) { System.out.println("rBoardController.viewForm()");
		 * 
		 * rBoardService.viewCount(no); BoardVo view = rBoardService.view(no);
		 * model.addAttribute("view", view);
		 * 
		 * return "/WEB-INF/views/rBoard/viewForm.jsp";
		 * 
		 * 
		 * }
		 * 
		 * @RequestMapping("/rBoard/delete") public String delete(@RequestParam int no)
		 * { System.out.println("rBoardController.delete()");
		 * 
		 * rBoardService.delete(no);
		 * 
		 * return "redirect:/rBoard/list"; }
		 * 
		 * @RequestMapping("/rBoard/modifyForm") public String modifyForm(@RequestParam
		 * int no,Model model) { System.out.println("rBoardController.modifyForm()");
		 * 
		 * rBoardService.viewCount(no); BoardVo modify = rBoardService.view(no);
		 * System.out.println(modify); model.addAttribute("modify", modify); return
		 * "/WEB-INF/views/rBoard/modifyForm.jsp"; }
		 * 
		 * @RequestMapping("/rBoard/modify") public String modify(@ModelAttribute
		 * BoardVo BoardVo) { System.out.println("rBoardController.modify()");
		 * System.out.println(BoardVo);
		 * 
		 * rBoardService.modify(BoardVo);
		 * 
		 * return "redirect:/rBoard/list"; }
		 */

}
