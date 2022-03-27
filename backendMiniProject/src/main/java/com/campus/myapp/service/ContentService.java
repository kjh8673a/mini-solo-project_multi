package com.campus.myapp.service;

import java.util.List;

import com.campus.myapp.vo.ContentVO;

public interface ContentService {
	// �۵��
    public int contentInsert(ContentVO vo);
    // �۸��
    public List<ContentVO> contentList(ContentVO vo);
    // �۳���
    public ContentVO contentSelect(Integer contentno);
    
    // ��ȭ���
    public List<ContentVO> movieList(ContentVO vo);
    // ����������
    public ContentVO contentsSelect(Integer contentno);
    
    // my���
    public List<ContentVO> myList(ContentVO vo);
    
}
