package com.campus.myapp.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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
	
	@GetMapping("contentList")
	public ModelAndView contentList() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("list", service.contentSelectAll());
		
		mav.setViewName("content/contentList");
		return mav;
	}
	
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
	

	
	
	
}
