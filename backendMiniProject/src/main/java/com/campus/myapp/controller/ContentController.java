package com.campus.myapp.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.campus.myapp.service.ContentService;
import com.campus.myapp.vo.ContentVO;

@RestController
@RequestMapping("/content/*")
public class ContentController {
	@Inject
	ContentService service;
	// 글목록
	@GetMapping("list")
	public List<ContentVO> list(ContentVO vo) {
		return service.contentList(vo);
	}
	// 글내용보기
	@GetMapping("contentView")
	public ModelAndView contentView(Integer contentno) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("vo", service.contentSelect(contentno));
		mav.setViewName("content/contentView");
		
		return mav;
	}	
	
	// 컨텐츠내용보기
	@GetMapping("contentsView")
	public ModelAndView contentsView(Integer contentno) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("vo", service.contentsSelect(contentno));
		mav.setViewName("content/contentsView");
		
		return mav;
	}	
		
		
	// 글등록폼
	@GetMapping("contentWrite")
	public ModelAndView contentWrite() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("content/contentWrite");
		return mav;
	}
	// 글등록
	@PostMapping("contentWriteOk")
	public ResponseEntity<String> contentWriteOk(ContentVO vo, HttpServletRequest request) {
		vo.setUserid((String)request.getSession().getAttribute("logId"));
		
		ResponseEntity<String> entity = null;	// 데이터와 처리상태를 가진다.
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/html; charset=utf-8");
		// headers.setContentType(new MediaType("text", "html", Charset.forName("UTF-8")));
		try {
			service.contentInsert(vo);
			// 정상구현
			String msg = "<script>";
			msg += "alert('글이 등록되었습니다.');";
			msg += "location.href='/myapp/admin/adminPage';";
			msg += "</script>";
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.OK); // 200
		}catch(Exception e) {
			e.printStackTrace();
			// 등록안됨
			String msg = "<script>";
			msg += "alert('글등록실패하였습니다.');";
			msg += "history.back();";
			msg += "</script>";
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	// 영화목록
	@GetMapping("movieList")
	public List<ContentVO> movieList(ContentVO vo) {
		return service.movieList(vo);
	}
	
	
	// my목록
	@GetMapping("myList")
	public List<ContentVO> myList(ContentVO vo) {
		return service.myList(vo);
	}	
	
	
	
}
