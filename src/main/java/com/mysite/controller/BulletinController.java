package com.mysite.controller;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.mysite.service.BulletinService;
import com.mysite.vo.BulletinVo;
import com.mysite.vo.CriteriaVo;
import com.mysite.vo.PageVo;
import com.mysite.vo.UserVo;

//게시판 컨트롤러

@Controller
public class BulletinController {
		
	@Autowired
	private BulletinService bulletinService;		
	
	//페이징 게시판 + Search 기술 포함*
	@RequestMapping(value = "/bulletin/list4",method = {RequestMethod.GET,RequestMethod.POST})
	public String List4(@RequestParam(value="crtPage",required = false,defaultValue = "1")  int crtPage,
						@RequestParam(value = "keyword",required = false,defaultValue = "") String keyword,Model model) {
		System.out.println("BulletinController.List4()");
				
		Map<String, Object> pMap = bulletinService.list4(crtPage,keyword);
		System.out.println(pMap); 
		model.addAttribute("pMap",pMap);
		
		return "/WEB-INF/views/bulletin/list4.jsp";
		
	}	
	//게시판 페이징 기술 포함*	
	@RequestMapping(value = "/bulletin/list3",method = {RequestMethod.GET,RequestMethod.POST})
	public String List3(@RequestParam(value="crtPage",required = false,defaultValue = "1")  int crtPage, Model model) {
		System.out.println("BulletinController.List3()");
				
		Map<String, Object> pMap = bulletinService.list3(crtPage);
		System.out.println(pMap); 
		model.addAttribute("pMap",pMap);
		
		return "/WEB-INF/views/bulletin/list3.jsp";
		
	}	
	
	 @RequestMapping(value = "/bulletin/list",method = {RequestMethod.GET,RequestMethod.POST}) 
	 public String List(Model model) { 
		 System.out.println("BulletinController.List");
	  
	  
		 List<BulletinVo> boardList = bulletinService.list();
		 System.out.println(boardList); 
		 model.addAttribute("boardList",boardList);
	  
	  return "/WEB-INF/views/bulletin/list.jsp"; 
	  }
	 
	 @RequestMapping(value="/bulletin/list2",method = {RequestMethod.GET,RequestMethod.POST})
	 public String List2(Model model) { 
		 System.out.println("BulletinController.List2()");
		  
		  
		 List<BulletinVo> boardList = bulletinService.list();
		 System.out.println(boardList); 
		 model.addAttribute("boardList",boardList);
	  
	  return "/WEB-INF/views/bulletin/list2.jsp"; 
	  }
	 
//	@RequestMapping(value = "/bulletin/list3", method = { RequestMethod.POST, RequestMethod.GET })
//	public String ListAndCountPaging(@ModelAttribute BulletinVo bullVo, Model model) {
//		System.out.println("BulletinController.ListAndCountNumbering()");
//
//		int pageNum = bullVo.getPageNum();
//		System.out.println(pageNum);
//
//		PageVo pageVo = new PageVo();
//		pageVo.setCri(bullVo);
//		System.out.println(pageVo);
		// 리스트 조회시 게시글 총 숫자 서비스 호출
//		bulletinService.totalCount();
//		pageVo.setTotalCount(tCount);
		// == pageVo 초기화 및 변수초기화 완료 ==
//		System.out.println(pageVo);
//		model.addAttribute("paging", pageVo);
//
//		List<BulletinVo> boardList = bulletinService.list();
//		model.addAttribute("boardList", boardList);
//
//		return "";
//	}

	@RequestMapping("/bulletin/search")
	public String search(@RequestParam(value = "keyword",required = false,defaultValue = "") String keyword, Model model) {
		System.out.println("BulletinController.search()");

		List<BulletinVo> keyList = bulletinService.search(keyword);
		System.out.println(keyList);
		model.addAttribute("boardList", keyList);

		return "/WEB-INF/views/bulletin/list.jsp";
	}

	/*
	 * @RequestMapping("/bulletin/list") public ModelAndView list(ModelAndView mav)
	 * { System.out.println("BulletinController.list()");
	 * 
	 * List<HashMap<String, Object>> bulletinList = bulletinService.list();
	 * System.out.println(bulletinList); mav.addObject("bList", bulletinList);
	 * mav.setViewName("/WEB-INF/views/bulletin/list.jsp");
	 * 
	 * return mav; }
	 */
	@RequestMapping(value = "/bulletin/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		System.out.println("BulletinController.writeForm()");

		return "/WEB-INF/views/bulletin/writeForm.jsp";

	}

	@RequestMapping("/bulletin/write")
	public String write(@ModelAttribute BulletinVo bulletinVo, HttpSession session) {
		System.out.println("BulletinController.write()");

		UserVo bulletinUser = (UserVo) session.getAttribute("successUser");
		bulletinVo.setUser_no(bulletinUser.getNo());
//			System.out.println(bulletinUser.getNo());
//			System.out.println(bulletinVo);
		
		for(int i=1; i<123;i++) {			
			String str = i + "번째 글입니다.";
			bulletinVo.setTitle(str);			
			bulletinService.write(bulletinVo);
		}		
		return "redirect:/bulletin/list3";
	}

	@RequestMapping("bulletin/viewForm")
	public String viewForm(@RequestParam int no, Model model) {
		System.out.println("BulletinController.viewForm()");

		bulletinService.viewCount(no);
		BulletinVo view = bulletinService.view(no);
		model.addAttribute("view", view);

		return "/WEB-INF/views/bulletin/viewForm.jsp";

	}

	@RequestMapping("/bulletin/delete")
	public String delete(@RequestParam int no) {
		System.out.println("BulletinController.delete()");

		bulletinService.delete(no);

		return "redirect:/bulletin/list";
	}

	@RequestMapping("/bulletin/modifyForm")
	public String modifyForm(@RequestParam int no, Model model) {
		System.out.println("BulletinController.modifyForm()");

		bulletinService.viewCount(no);
		BulletinVo modify = bulletinService.view(no);
		System.out.println(modify);
		model.addAttribute("modify", modify);
		return "/WEB-INF/views/bulletin/modifyForm.jsp";
	}

	@RequestMapping("/bulletin/modify")
	public String modify(@ModelAttribute BulletinVo bulletinVo) {
		System.out.println("BulletinController.modify()");
		System.out.println(bulletinVo);

		bulletinService.modify(bulletinVo);

		return "redirect:/bulletin/list";
	}

}
