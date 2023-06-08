package com.mysite.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mysite.service.FileUpLoadService;

@Controller
@RequestMapping("/fileupload")
public class FileUpLoadController {
	@Autowired
	private FileUpLoadService fileUploadService;
	
	@RequestMapping(value="/form",method = {RequestMethod.GET,RequestMethod.POST})
	public String form() {
		System.out.println("FileUpLoadController.form()");		
		
		return "/WEB-INF/views/fileupload/form.jsp";
	}
	@RequestMapping(value="/upload",method = {RequestMethod.GET,RequestMethod.POST})
	public String upload(@RequestParam("file") MultipartFile file,Model model) {
		System.out.println("FileUpLoadController.upload()");	
		
		String saveName =  fileUploadService.restore(file);
		model.addAttribute("saveName", saveName);
		
		return "/WEB-INF/views/fileupload/result.jsp";
	}
	
	
	

}
