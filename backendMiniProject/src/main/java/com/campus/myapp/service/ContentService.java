package com.campus.myapp.service;

import java.util.List;

import com.campus.myapp.vo.ContentVO;

public interface ContentService {
	// 글등록
    public int contentInsert(ContentVO vo);
    // 글목록
    public List<ContentVO> contentList(ContentVO vo);
    // 글내용
    public ContentVO contentSelect(Integer contentno);
    
    // 영화목록
    public List<ContentVO> movieList(ContentVO vo);
    // 컨텐츠내용
    public ContentVO contentsSelect(Integer contentno);
    
    // my목록
    public List<ContentVO> myList(ContentVO vo);
    
}
