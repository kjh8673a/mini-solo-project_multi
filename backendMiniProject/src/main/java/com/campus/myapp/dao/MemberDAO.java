package com.campus.myapp.dao;

import com.campus.myapp.vo.MemberVO;

public interface MemberDAO {
	// 로그인
	public MemberVO loginCheck(MemberVO vo);
	// 회원등록
	public int memberInsert(MemberVO vo);
}
