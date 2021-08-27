package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.dao.ReviewDAO;
import com.example.lesson03.model.Review;

@Service
public class ReviewBO {
	
	// dao 연결
	@Autowired
	private ReviewDAO reviewDAO;
	
	// 하나를 가져올 때: getReview, 리스트로 가져올 때 : getReivewList,  조건을 쓸 때 : getReviewBy(필드명)
	public Review getReviewById(int id) {
		return reviewDAO.selectReviewById(id);
	}
}