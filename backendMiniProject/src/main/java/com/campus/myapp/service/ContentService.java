package com.campus.myapp.service;

import java.util.List;

import com.campus.myapp.vo.ContentVO;

public interface ContentService {
	// �۵��
    public int contentInsert(ContentVO vo);
    // �۸��
    public List<ContentVO> contentSelectAll();
}
