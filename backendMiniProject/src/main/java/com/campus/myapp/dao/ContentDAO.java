package com.campus.myapp.dao;


import java.util.List;

import com.campus.myapp.vo.ContentVO;

public interface ContentDAO {
	// �۵��
    public int contentInsert(ContentVO vo);
    // �۸��
    public List<ContentVO> contentSelectAll();
}
