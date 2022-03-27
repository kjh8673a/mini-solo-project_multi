package com.campus.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campus.myapp.dao.RatingDAO;
import com.campus.myapp.vo.ContentVO;
import com.campus.myapp.vo.RatingVO;
@Service
public class RatingServiceImpl implements RatingService {
	@Autowired
	RatingDAO dao;

	@Override
	public int ratingWrite(RatingVO vo) {
		
		int result = dao.ratingWrite(vo);
		setRating(vo.getContentno());
		
		return result;
	}

	@Override
	public List<RatingVO> ratingList(int contentno) {
		return dao.ratingList(contentno);
	}

	// ∆Ú¡°∆Ú±’
	public void setRating(int contentno) {
		Double totalrating = dao.getRatingAverage(contentno);
		
		if(totalrating == null) {
			totalrating = 0.0;
		}
		
		totalrating = (double) (Math.round(totalrating*10));
		totalrating = totalrating / 10;
		
		ContentVO cvo = new ContentVO();
		cvo.setContentno(contentno);
		cvo.setTotalrating(totalrating);

		dao.updateRating(cvo);
	}
	
	
}
