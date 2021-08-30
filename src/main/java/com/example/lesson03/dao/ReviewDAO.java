package com.example.lesson03.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.model.Review;

@Repository
public interface ReviewDAO {
	
	// SELECT
	//	public Review selectReviewById(int id); // 가져올 행의 필드를 파라미터로 넣어준다. / Integer : null값 허용, int : 필수값
	public Review selectReviewById(@Param("id") int id); // 2개 이상..!

	// INSERT
	public int insertReview (Review review); // 파라미터가 하나일 때는 @Param 없어도 무관!
}
