package com.campus.myapp.dao;

import java.util.List;

import com.campus.myapp.vo.WantVO;

public interface WantDAO {
	// ��۵��
	public int wantWrite(WantVO vo);
	// ��۸��
	public List<WantVO> wantList(String userid);
	// ��ۼ���
	public int wantEdit(WantVO vo);
}
