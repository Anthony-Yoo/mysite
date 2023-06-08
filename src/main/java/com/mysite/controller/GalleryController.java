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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mysite.service.FileUpLoadService;
import com.mysite.service.GalleryService;
import com.mysite.vo.GalleryVo;
import com.mysite.vo.JsonResult;
import com.mysite.vo.UserVo;

@Controller
@RequestMapping(value="/gallery")
public class GalleryController {
	
	@Autowired
	private GalleryService galleryServise;

	
	@RequestMapping(value ="/list",method = {RequestMethod.GET,RequestMethod.POST})
	public String list(Model model) {
		System.out.println("GalleryController.list()");
		
		List<GalleryVo> galleryList =  galleryServise.list();
		System.out.println(galleryList);
		model.addAttribute("galleryList", galleryList);
		
		return "/WEB-INF/views/gallery/list.jsp";
	}
	
	@ResponseBody
	@RequestMapping(value="/view",method = {RequestMethod.GET,RequestMethod.POST})
	public JsonResult view(@RequestParam("no") int no,  Model model,HttpSession session) {
		System.out.println("GalleryController.view()");
		
		JsonResult jsonResult = new JsonResult();
		GalleryVo galleryVo = new GalleryVo();
		UserVo bulletinUser = (UserVo) session.getAttribute("successUser");
		galleryVo = galleryServise.view(no);
		try {			
			galleryVo.setSessionName(bulletinUser.getName());	
			jsonResult.success(galleryVo);
		} catch (Exception e) {
			e.printStackTrace();			
		}
		
		jsonResult.success(galleryVo);		
		System.out.println(galleryVo);
		System.out.println(jsonResult);
		
		return jsonResult;
		
	}
		
	@RequestMapping(value="/upload",method = {RequestMethod.GET,RequestMethod.POST})
	public String upload(@RequestParam("file") MultipartFile file,@ModelAttribute GalleryVo galleryVo,HttpSession session) {
		System.out.println("FileUpLoadController.upload()");	
		
		
		UserVo bulletinUser = (UserVo) session.getAttribute("successUser");
		galleryVo.setUser_no(bulletinUser.getNo());
		galleryVo.setUserName(bulletinUser.getName());		
		
		System.out.println(galleryVo);
		galleryServise.restore(file, galleryVo);
		
		
		
//		model.addAttribute("saveName", saveName);
		
		return "redirect:/gallery/list";
	}
	@RequestMapping(value="/delete",method = {RequestMethod.GET,RequestMethod.POST})
	public String delete(@RequestParam int no) {
		System.out.println("FileUpLoadController.delete()");

		galleryServise.delete(no);

		return "redirect:/gallery/list";
	}
}
