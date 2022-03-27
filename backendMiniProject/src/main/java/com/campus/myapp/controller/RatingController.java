package com.campus.myapp.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.campus.myapp.service.RatingService;
import com.campus.myapp.vo.ContentVO;
import com.campus.myapp.vo.RatingVO;

@RestController
@RequestMapping("/rating/*")
public class RatingController {
	@Inject
	RatingService service;
	
		// 평점등록
		@RequestMapping(value="rating/ratingOk", method=RequestMethod.POST)
		public String ratingOk(RatingVO vo, HttpSession session, Model model) {
			vo.setUserid((String)session.getAttribute("logId"));
			
			int cnt = service.ratingWrite(vo);
			
			model.addAttribute("cnt", cnt);
			
			return "rating/ratingResult";
		}
		
		// 평점목록
		@GetMapping("list")
		public List<RatingVO> list(int contentno) {
			return service.ratingList(contentno);
		}
	
}
