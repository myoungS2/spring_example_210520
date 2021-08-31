package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.model.Review;

@RestController
public class ReviewRestController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	// SELECT
	// 요청 URL : http://localhost/lesson03/ex01?id=2 만약 id가 없다면 400대 error발생!(서버쪽으로 들어가지지도 않음)
	@RequestMapping("/lesson03/ex01")
	// 하나의 행만 가져오기
	public Review ex01(
			// requestparam 필수 파라미터로 가져오는 3가지 방법
			@RequestParam(value="id" /* 쿼리파라미터로 오는 id */) int id /* 필수파라미터(빼고 요청시 오류남) */
//			@RequestParam(value="id", required=true) int id /* 기본으로 필수 파라미터지만 명시적으로 required=true, int(null불가, 기본값이 0) 필수파라미터라는 뜻 */
//			@RequestParam("id") int id /* 이것도 필수 파라미터(키만 명시할 때)*/
			// requestparam 비필수 파라미터로 가져오는 방법
//			@RequestParam(value="id", required=false) Integer id /* required=false, Integer(null가능) */ 
			// 디폴트값(비필수파라미터)
//			@RequestParam(value="id", defaultValue="1") int id /* defaultValue는 숫자,문자 모두 ""로 감싸주어야함 */
			) {
		System.out.print(id); // BO에 들어가지 못하고 error발생 (넘겨준id는 null인데 bo에서는 int로 받으려고 준비중이기 때문에)
		Review review = reviewBO.getReviewById(id);
		return review;
	}
	
	// Invalid 어쩌구 에러 => 다오가 맵핑x
	
	// INSERT
	// 요청 URL : http://localhost/lesson03/ex02
	@RequestMapping("/lesson03/ex02")
	public String ex02() /* view가 아닌, 내가 리턴하는 스트링 그 자체가 response body에 담기게 됨*/ {
		Review review = new Review();
		review.setStoreId(7);
		review.setMenu("삼겹혼밥세트");
		review.setUserName("신보람");
		review.setPoint(4.5);
		review.setReview("혼자 먹기 적당하네요.");
		
		int rowCount = reviewBO.addReview(review); // BO insert, insert 성공한 개수 -> rowCount변수에 담기
		return "성공한 행의 개수는 : " + rowCount ;
	}
	
	// 요청 URL : http://localhost/lesson03/ex02/2
	@RequestMapping("/lesson03/ex02/2")
	public String ex02_2() {
		int rowCount = reviewBO.addReviewAsField(3, "치즈와퍼", "신바다", 5.0, "치즈 와퍼 좋아요!"); // as: 내가 무엇으로 어떻게 하겠다..!라는 뉘앙스 (내가 넘기고자 하는 것을 파라미터로 넣기)
		return "성공한 행의 개수는 : " + rowCount ;
	}
	
	// UPDATE
	// 요청 URL : http://localhost/lesson03/ex03?id=19&review=고기가 덜익었지만 맛있어요
	@RequestMapping("/lesson03/ex03")
	public String ex03(
			@RequestParam(value="id",  required=true) int id,
			@RequestParam("review") String review) {
		
		int rowCount = reviewBO.updateReview(id, review);
		return "변경 완료: " + rowCount;
	}
	
	// DELETE
	// 요청 URL : http://localhost/lesson03/ex04?id=23
	@RequestMapping("/lesson03/ex04")
	public String ex04(
			@RequestParam(value="id") int id) {
		
		int rowCount = reviewBO.deleteReviewById(id);
		return "삭제 완료: " + rowCount;
	}
}
