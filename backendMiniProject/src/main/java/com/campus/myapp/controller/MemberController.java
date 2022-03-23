package com.campus.myapp.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.campus.myapp.service.MemberService;
import com.campus.myapp.vo.MemberVO;

@Controller
@RequestMapping("/member/")
public class MemberController {
	@Inject
	MemberService service;
	
	// �α��������� �̵�
	@GetMapping("loginForm")
	public String loginForm() {
		return "member/loginForm";
	}
	
	// �α���
	@PostMapping("loginOk")
	public ModelAndView loginOk(MemberVO vo, HttpSession session) {
		MemberVO vo2 = service.loginCheck(vo);
		
		ModelAndView mav = new ModelAndView();
		if(vo2 != null) {
			session.setAttribute("logId", vo2.getUserid());
			session.setAttribute("logName", vo2.getUsername());
			session.setAttribute("logStatus", "Y");
			mav.setViewName("redirect:/");
		}else {
			mav.setViewName("redirect:loginForm");
		}
		return mav;
	}
	
	// �α׾ƿ�
	@GetMapping("logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/");
		return mav;
	}
	
	// ȸ������������ �̵�
	@GetMapping("registerForm")
	public String registerForm() {
		return "member/registerForm";
	}
	
	// ȸ�����
	@PostMapping("registerOk")
	public String registerFormOk(MemberVO vo, Model model) {
		int cnt = service.memberInsert(vo);
		
		model.addAttribute("cnt", cnt);
		
		return "member/registerResult";
	}
	
	// ������������ �̵�
	@GetMapping("myPage")
	public String myPage() {
		return "member/myPage";
	}

}
