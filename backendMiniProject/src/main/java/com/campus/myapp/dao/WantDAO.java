package com.campus.myapp.dao;

import java.util.List;

import com.campus.myapp.vo.WantVO;

public interface WantDAO {
	// ´ñ±Ûµî·Ï
	public int wantWrite(WantVO vo);
	// ´ñ±Û¸ñ·Ï
	public List<WantVO> wantList(String userid);
	// ´ñ±Û¼öÁ¤
	public int wantEdit(WantVO vo);
}
