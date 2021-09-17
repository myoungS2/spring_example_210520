<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 추가</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<!--  Ajax를 쓰려면 jquery slim버전이 아닌 더 많은 함수가 있는 jquery js사용 -->
  <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>

	<div class="container">
		<h1>회원 정보 추가</h1>
		<form id="form" method="post" action="/lesson06/ex01/add_user">
			<b>이름:</b>
			<input type="text" class="form-control" name="name"><br>
			<b>생년월일:</b>
			<input type="text" class="form-control" name="yyyymmdd"><br>
			<b>이메일:</b>
			<input type="text" class="form-control" name="email"><br>
			<b>자기소개:</b>
			<textarea rows="10" cols="30" class="form-control" name="introduce"></textarea><br>
			<input type="submit" id="addBtn" class="btn btn-success" value="추가"> <!-- submit으로 보내면, validation check못함-> script로..! -->
		</form>
	</div>
	
	<script>
		$(document).ready(function() {
			// (1) jquery의 submit 기능 이용하기
			// from 태그 통째로 가져오기(submit이 일어났을 때)
				/*  $('#form').on('submit', function(e) {
					// e.preventDefault(); // validation->submit이 바로 되버림, 따라서 기본적으로 submit이 되는 것을 막아주어야 함.
				
					alert("추가 버튼 클릭");
					
					// validation
					let name = $('input[name=name]').val().trim(); // 이름 가져와서 앞뒤 여백 제거
					if (name == ''){
						alert("이름을 입력하세요.");
						return false;
					}
				let yyyymmdd = $('input[name=yyyymmdd]').val().trim();
				if (yyyymmdd == ''){
					alert("생년월일 입력하세요.");
					return false;
				}
			
				
				$(this).submit(); // Maximum call stack size exceeded -> 계속 이벤트를 부르는데 e.preventDefault(); 때문에 못하고 또 부르고를 반복(무한루프)
			}); */
			
			// (2) jquery의 AJAX 통신을 이용하기
			$('#addBtn').on('click', function(e) {
				e.preventDefault(); // 기본 submit 동작 되는 것을 막는다.
				
				// alert("추가 버튼 클릭");
				
				// validation
				
				let name = $('input[name=name]').val().trim(); // 이름 값(val) 가져와서 앞뒤 여백 제거(trim)
				if (name == ''){
					alert("이름을 입력하세요.");
					return false;
				}
				let yyyymmdd = $('input[name=yyyymmdd]').val().trim();
				if (yyyymmdd == ''){
					alert("생년월일 입력하세요.");
					return false;
				}
				// 입력받은 생년월일이 숫자인지
				if (isNaN(yyyymmdd)) {
					alert("숫자만 입력해주세요.");
					return false;
				}
				
				let email = $('input[name=email]').val().trim(); 
				let introduce = $('textarea[name=introduce]').val(); 
				
				// AJAX : 우리가 브라우저의 역할을 하는 것 (name, form, submit 세트와 상관 없이) -> 비동기로 별도 요청
				$.ajax({
					// key: value 쌍으로
					type: 'POST' // type = method
					, url: '/lesson06/ex01/add_user'
					, data: {"name":name, "yyyymmdd":yyyymmdd, "email":email, "introduce":introduce}
					, success: function(data) { // function의 data(parameter)는 String (= ajax 결과는 String이다.)
						alert(data); // 결과가 200 OK이어야 뜸..!
						location.href = "/lesson06/ex01/after_add_user";
						// location.reload(); // 새로고침(지금화면)
					}
					, complete: function(data) {
						alert("완료"); // 에러든 뭐든 끝나긴 끝남..!(잘 안씀)
					}
					, error: function(e) {
						alert("에러" + e); // 요청에 실패했을 때
					}
					
				});
				
			});
			
		}); 
		
	</script>
</body>
</html>