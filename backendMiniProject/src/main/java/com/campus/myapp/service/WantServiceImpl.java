package com.campus.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campus.myapp.dao.WantDAO;
import com.campus.myapp.vo.WantVO;

@Service
public class WantServiceImpl implements WantService {
	@Autowired
	WantDAO dao;
	
	@Override
	public int wantWrite(WantVO vo) {
		return dao.wantWrite(vo);
	}

	@Override
	public List<WantVO> wantList(String userid) {
		return dao.wantList(userid);
	}

	@Override
	public int wantEdit(WantVO vo) {
		return dao.wantEdit(vo);
	}

}
