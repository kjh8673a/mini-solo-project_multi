package com.campus.myapp.dao;

import com.campus.myapp.vo.MemberVO;

public interface MemberDAO {
	// �α���
	public MemberVO loginCheck(MemberVO vo);
	// ȸ�����
	public int memberInsert(MemberVO vo);
}
