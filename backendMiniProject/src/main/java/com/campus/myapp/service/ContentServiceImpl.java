package com.campus.myapp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.campus.myapp.dao.ContentDAO;
import com.campus.myapp.vo.ContentVO;
@Service
public class ContentServiceImpl implements ContentService {
	@Inject
	ContentDAO dao;
	
	@Override
	public int contentInsert(ContentVO vo) {
		return dao.contentInsert(vo);
	}

	@Override
	public List<ContentVO> contentSelectAll() {
		return dao.contentSelectAll();
	}


}
