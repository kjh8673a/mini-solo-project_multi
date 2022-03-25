package com.campus.myapp.service;

import java.util.List;

import com.campus.myapp.vo.ContentVO;

public interface ContentService {
	// 글등록
    public int contentInsert(ContentVO vo);
    // 글목록
    public List<ContentVO> contentSelectAll();
}
