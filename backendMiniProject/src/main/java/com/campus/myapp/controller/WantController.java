package com.campus.myapp.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.campus.myapp.service.WantService;
import com.campus.myapp.vo.WantVO;

@RestController
@RequestMapping("/want/")
public class WantController {
	@Inject
	WantService service;
	
	// ´ñ±Ûµî·Ï
	@PostMapping("writeOk")
	public int writeOk(WantVO vo, HttpSession session) {
		vo.setUserid((String)session.getAttribute("logId"));
		
		return service.wantWrite(vo);
	}
	
	// ´ñ±Û¸ñ·Ï
	@GetMapping("list")
	public List<WantVO> list(String userid) {
		return service.wantList(userid);
	}
	
	// ´ñ±Û¼öÁ¤
	@PostMapping("editOk")
	public int editOk(WantVO vo) {
		return service.wantEdit(vo);
	}
	
	
	
}
