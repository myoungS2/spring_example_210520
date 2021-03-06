<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 라이브러리 (1)</title>
</head>
<body>
	<h1>1. 변수 정의하기 (c:set)</h1>
	
	<c:set var="number1" value="100" /> <%-- 열고,닫기: 하나의 태그일 경우 =>  <c:set  />  --%>
	number1 : ${number1}<br>
	<c:set var="number2">250</c:set>
	number2 : ${number2} <br>
	number1 + number2 : ${number1 + number2}
	
	<h1>2. 변수 출력하기 (c:out)</h1>
	number1 : <c:out value="${number1}"  /> <%-- EL문법으로 넣기  --%>
	<c:out value="Hello world!!!" /><br>
	<c:out value="<script>alert('얼럿창 띄우기');</script>" /></br> <%-- 문구 그대로 출력 --%>
	<%-- 	<script>
			alert("안녕");
			</script> --%>
	<%--  escapeXml="false" -> 스크립트가 수행 됨 --%>		
	<c:out value="<script>alert('얼럿창 띄우기');</script>" escapeXml="false" />		
	
	<%-- escapeXml="true" -> 문구 그대로 출력 --%>	
	<c:out value="<script>alert('얼럿창 띄우기');</script>" escapeXml="true" />	
	
	<h1>3. 조건문 (c:if)</h1>
	<c:if test="${number1 > 50}"> <%-- 참이면 아래 문장이 출력 됨. --%>
		number1은 50보다 크다.<br>
	</c:if>
	<%-- <c:if text="${number1 == 100}">
		number1은 100이다.<br>
	</c:if> --%>
	<c:if test="${number1 eq 100 }"> <%-- number1과 100이 같다.(eq) jstl --%>
		number1은 100이다.<br>
	</c:if>
	<c:if test="${number1 ne 222 }"> <%-- ne(not equal 같지 않다) --%>
		number1은 222가 아니다. <br>
	</c:if>
	<c:if test="${not empty number1}"> <%-- 비어있냐 아니냐(null과 비슷) (not, !)empty --%>
		number1은 비어있지 않다.<br>
	</c:if>
	
</body>
</html>