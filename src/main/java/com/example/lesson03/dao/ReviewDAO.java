package com.example.lesson03.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.model.Review;

@Repository
public interface ReviewDAO {
	
	// SELECT
	//	public Review selectReviewById(int id); // 가져올 행의 필드를 파라미터로 넣어준다. / Integer : null값 허용, int : 필수값
	public Review selectReviewById(@Param("id") int id); // 2개 이상..!

	// INSERT 1
	public int insertReview (Review review); // 파라미터가 하나일 때는 @Param 없어도 무관!
	
	// INSERT 2 -> map으로 구성
	public int insertReviewAsField (
			@Param("storeId") int storeId, 
			@Param("menu") String menu, 
			@Param("userName") String userName,
			@Param("point") double point, 
			@Param("review") String review
									);
	
	// UPDATE
	public int updateReview(
			@Param("id") int id, 
			@Param("review") String review);
	
	// DELETE
	public int deleteReviewById(int id);
}
