package com.campus.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AdminController {
	
	// �������������� �̵�
	@GetMapping("/admin/adminPage")
	public ModelAndView adminPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/adminPage");
		return mav;
	}
	
	// ��ȭ�������� �̵�
	@GetMapping("/movie/movieMain")
	public ModelAndView movieMain() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("movie/movieMain");
		return mav;
	}
	
}
