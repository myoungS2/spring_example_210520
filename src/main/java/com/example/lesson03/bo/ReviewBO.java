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
	
	// SELECT
	// 하나를 가져올 때: getReview, 리스트로 가져올 때 : getReivewList,  조건을 쓸 때 : getReviewBy(필드명)
	public Review getReviewById(int id) {
		return reviewDAO.selectReviewById(id);
	}
	
	// INSERT 1 -> void대신 int를 넘기면, 몇행을 insert 성공했는지 return
	public int addReview (Review review) {
		return reviewDAO.insertReview(review); 
	}
	
	// INSERT 2
	public int addReviewAsField (
			int storeId, String menu, String userName,
			double point, String review) {
		// 3, "치즈와퍼", "신바다", 5.0, "치즈 와퍼 좋아요!"
		return reviewDAO.insertReviewAsField ( storeId, menu, userName, point, review); 
	}
	
	// UPDATE
	public int updateReview(int id, String review) {
		return reviewDAO.updateReview(id, review);
	}
	
	// DELETE
	public int deleteReviewById(int id) {
		return reviewDAO.deleteReviewById(id);
	}
}