<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sign in</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<!--  Ajax를 쓰려면 jquery slim버전이 아닌 더 많은 함수가 있는 jquery js사용 -->
  <script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css" href="/CSS/marondalgram_style.css">
</head>
<body>
	<div id="wrap" class="container">
		<%-- 로고 --%>
		<header class="d-flex justify-content-center">
			<div class="col-7 ml-4 text-center">
				<a id="logo" href="#">Marondalgram</a>
			</div>
		</header>
		
		<%-- 아이디/비밀번호 --%>
		<section class="signin d-flex justify-content-center">
			<div class="form-group">
					<div class="w-100">
						<input type="text" id="loginIdInput" class="form-control mt-3">
						<input type="password" id="passwordInput" class="form-control mt-3">
					</div>	
				
				
					<div class="d-flex justify-content-center mt-3">	
						<button type="button" id="signinBtn" class="btn btn-secondary col-5">sign in</button>
					</div>	
				
					<div class="d-flex justify-content-center mt-3" >
						<a id="signup" href="#">sign up</a>
					</div>
			</div>
		</section>
		
	</div>
</body>
</html>