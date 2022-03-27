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
	public List<ContentVO> contentList(ContentVO vo) {
		return dao.contentList(vo);
	}

	@Override
	public ContentVO contentSelect(Integer contentno) {
		return dao.contentSelect(contentno);
	}

	@Override
	public List<ContentVO> movieList(ContentVO vo) {
		return dao.movieList(vo);
	}

	@Override
	public ContentVO contentsSelect(Integer contentno) {
		return dao.contentsSelect(contentno);
	}

	@Override
	public List<ContentVO> myList(ContentVO vo) {
		return dao.myList(vo);
	}



}
