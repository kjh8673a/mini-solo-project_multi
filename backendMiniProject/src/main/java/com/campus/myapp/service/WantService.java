package com.campus.myapp.service;

import java.util.List;

import com.campus.myapp.vo.WantVO;

public interface WantService {
	// ��۵��
	public int wantWrite(WantVO vo);
	// ��۸��
	public List<WantVO> wantList(String userid);
	// ��ۼ���
	public int wantEdit(WantVO vo);
}
