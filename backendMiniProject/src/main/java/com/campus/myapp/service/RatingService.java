package com.campus.myapp.service;

import java.util.List;

import com.campus.myapp.vo.ContentVO;
import com.campus.myapp.vo.RatingVO;

public interface RatingService {
	// 평점등록
    public int ratingWrite(RatingVO vo);
    // 평점목록
    public List<RatingVO> ratingList(int contentno);
    
    // 평점평균
    public void setRating(int contentno);
}
