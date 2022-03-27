package com.campus.myapp.dao;

import java.util.List;

import com.campus.myapp.vo.ContentVO;
import com.campus.myapp.vo.RatingVO;

public interface RatingDAO {
	// 평점등록
    public int ratingWrite(RatingVO vo);
    // 평점목록
    public List<RatingVO> ratingList(int contentno);
    
    // 평점평균
    public Double getRatingAverage(int contentno);
    public int updateRating(ContentVO vo);
}
