package com.campus.myapp.service;

import com.campus.myapp.vo.MemberVO;

public interface MemberService {
	// �α���
	public MemberVO loginCheck(MemberVO vo);
	// ȸ�����
	public int memberInsert(MemberVO vo);
}
