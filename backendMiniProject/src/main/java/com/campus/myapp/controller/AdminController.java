package com.campus.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	// 관리자페이지로 이동
	@GetMapping("adminPage")
	public String adminPage() {
		return "admin/adminPage";
	}
}
