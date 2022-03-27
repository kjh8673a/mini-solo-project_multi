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
	// �۸��
	@GetMapping("list")
	public List<ContentVO> list(ContentVO vo) {
		return service.contentList(vo);
	}
	// �۳��뺸��
	@GetMapping("contentView")
	public ModelAndView contentView(Integer contentno) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("vo", service.contentSelect(contentno));
		mav.setViewName("content/contentView");
		
		return mav;
	}	
	
	// ���������뺸��
	@GetMapping("contentsView")
	public ModelAndView contentsView(Integer contentno) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("vo", service.contentsSelect(contentno));
		mav.setViewName("content/contentsView");
		
		return mav;
	}	
		
		
	// �۵����
	@GetMapping("contentWrite")
	public ModelAndView contentWrite() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("content/contentWrite");
		return mav;
	}
	// �۵��
	@PostMapping("contentWriteOk")
	public ResponseEntity<String> contentWriteOk(ContentVO vo, HttpServletRequest request) {
		vo.setUserid((String)request.getSession().getAttribute("logId"));
		
		ResponseEntity<String> entity = null;	// �����Ϳ� ó�����¸� ������.
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/html; charset=utf-8");
		// headers.setContentType(new MediaType("text", "html", Charset.forName("UTF-8")));
		try {
			service.contentInsert(vo);
			// ������
			String msg = "<script>";
			msg += "alert('���� ��ϵǾ����ϴ�.');";
			msg += "location.href='/myapp/admin/adminPage';";
			msg += "</script>";
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.OK); // 200
		}catch(Exception e) {
			e.printStackTrace();
			// ��Ͼȵ�
			String msg = "<script>";
			msg += "alert('�۵�Ͻ����Ͽ����ϴ�.');";
			msg += "history.back();";
			msg += "</script>";
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	// ��ȭ���
	@GetMapping("movieList")
	public List<ContentVO> movieList(ContentVO vo) {
		return service.movieList(vo);
	}
	
	
	// my���
	@GetMapping("myList")
	public List<ContentVO> myList(ContentVO vo) {
		return service.myList(vo);
	}	
	
	
	
}
