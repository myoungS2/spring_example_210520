<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 라이브러리 (2)</title>
</head>
<body>
	<h1>1. 조건문 (c:choose, c:when(else if), c:otherwise(else))</h1>
	<c:set var="weight" value="80" />
	
	<c:choose>
		<c:when test="${weight < 60}">
			치킨 먹자!!!<br>
		</c:when>
		<%-- 60 이상 ~ 70 미만인 경우 --%>
		<c:when test="${weight < 70 }"> 
			샐러드 먹자!!!<br>
		</c:when>
		<%-- 70 이상 ~ --%>
		<c:otherwise>
			굶자!!!<br>
		</c:otherwise>
	</c:choose>
	
	<h1>2. 반복문 (c:forEach)</h1> 
	<c:forEach begin="0" end="5" step="1" var="val1"> <%-- 0~5까지 1씩 증가! --%> 
		${val1}<br> <%-- 0,1,2,3,4,5 --%>
	</c:forEach>
	<br>
	<%-- 16 ~ 20 : 5번 --%>
	<c:forEach begin="16" end="20" step="1" var="val2" varStatus="status">
		val: ${val2} current: ${status.current} first: ${status.first}<br>
		last: ${status.last} count: ${status.count} index : ${status.index}
		<br>
	</c:forEach>
	
	<%-- 서버에서 가져온 List<String> 출력 -> 향상된 for문과 비슷 --%>
	<c:forEach var="fruit" items="${fruits}" varStatus="status">
		${fruit} ::::: ${status.count} ${status.index} 
	</c:forEach>	
	<br>
	<%-- 서버에서 가져온 List<Map<String, Object>> 출력 --%>
	<c:forEach var="user" items="${users}" varStatus="status">
		<h4>${status.count}번째 사람 정보</h4>
		이름: ${user.name}<br> <%-- user라는 맵에 있는 name, 일반객체여도 객체의 필드명으로 꺼낼 수 있음! --%>
		나이: ${user.age}<br>
		취미: ${user.hobby}<br>
	</c:forEach>
	<br>
	
	
	<%-- 테이블 구성 --%>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>나이</th>
				<th>취미</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${users}" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${user.name}</td>
				<td>${user.age}</td>
				<td>${user.hobby}</td>
			</tr>
			</c:forEach>
		</tbody>
	
	</table>

</body>
</html>