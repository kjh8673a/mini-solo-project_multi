package com.campus.myapp.dao;


import java.util.List;

import com.campus.myapp.vo.ContentVO;

public interface ContentDAO {
	// 글등록
    public int contentInsert(ContentVO vo);
    // 글목록
    public List<ContentVO> contentSelectAll();
}
