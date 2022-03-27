package com.campus.myapp.service;

import java.util.List;

import com.campus.myapp.vo.ContentVO;
import com.campus.myapp.vo.RatingVO;

public interface RatingService {
	// �������
    public int ratingWrite(RatingVO vo);
    // �������
    public List<RatingVO> ratingList(int contentno);
    
    // �������
    public void setRating(int contentno);
}
