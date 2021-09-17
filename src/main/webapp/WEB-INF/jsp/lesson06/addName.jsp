<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이름추가하기</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<!--  Ajax를 쓰려면 jquery slim버전이 아닌 더 많은 함수가 있는 jquery js사용 -->
  <script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<b>이름:</b>
		<label for="name">
		<input type="text" class="form-control" id="name"></label>
		<button type="button" id="nameCheckBtn" class="btn btn-info">중복확인</button><br>
		<div id="nameStatusArea"></div><br>
		<button type="submit" id="joinBtn" class="btn btn-danger">회원가입</button>
	</div>
	
	<script>
		$(document).ready(function () {
			$('#nameCheckBtn').on('click', function() {
				let name = $('#name').val().trim();
				
				// 비우기..! (그렇지 않으면 append해줄때마다 계속 추가됨..!)
				$('#nameStatusArea').empty(); // div 태그 안에 있는 자식태그들을 비운다.
				
				// validation check
				// 이름이 있는지 확인
				if (name == '') {
					$('#nameStatusArea').append('<small class="text-danger">이름이 비어있습니다.</samll>');
					return;
				}
				
				// 이름이 중복되는지 확인 (DB 조회) -> AJAX 통신을 이용..!
				$.ajax({
					type: 'get' // 주소에 노출되어도 상관x
					, url: '/lesson06/ex02/is_duplication'
					, data: {'name': name}
					, success: function(data) {
						// alert(data.is_duplication);
						if(data.is_duplication == true){
							$('#nameStatusArea').append('<small class="text-danger">중복된 이름입니다.</samll>');
						}
					}
					, error: function(e) {
						alert("실패" + e); 
					}
					
				});
				
				
			});
			
			
			// 회원가입 동작 (버튼이 클릭되었을 때)
			$('#joinBtn').on('click', function() {
				// alert("회원가입 버튼 클릭");
				
				console.log($('#nameStatusArea').children().length);
				
				if($('#nameStatusArea').children().length == 0) {
					alert("서브밋 가능");
				} else {
					alert ("서브밋 불가");
				}
			});
			
			
		});
		
		
	
	
	</script>
</body>
</html>