package com.campus.myapp.service;

import com.campus.myapp.vo.MemberVO;

public interface MemberService {
	// 로그인
	public MemberVO loginCheck(MemberVO vo);
	// 회원등록
	public int memberInsert(MemberVO vo);
}
