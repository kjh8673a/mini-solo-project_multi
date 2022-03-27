package com.campus.myapp.dao;

import java.util.List;

import com.campus.myapp.vo.ContentVO;
import com.campus.myapp.vo.RatingVO;

public interface RatingDAO {
	// �������
    public int ratingWrite(RatingVO vo);
    // �������
    public List<RatingVO> ratingList(int contentno);
    
    // �������
    public Double getRatingAverage(int contentno);
    public int updateRating(ContentVO vo);
}
