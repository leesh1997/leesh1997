<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	사무용 PC에 대한 상세 페이지입니다.
	<br> 모델명: 사무용 PC
	<br> 제품가격: 159,000원
	<br>
	
	<img src="data:image/jpeg;base64,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", width="300px">
	<br>
	<%
	//1.상품정보를 저장한 쿠키객체 생성
	Cookie cookie = new Cookie("item3", URLEncoder.encode("사무용 PC", "UTF-8"));
	
	//2.1시간동안 유지
	cookie.setMaxAge(3600);
	
	//3.클라이언트PC에 쿠키를 보내기 위해 response객체에 저장
	response.addCookie(cookie);
	%>
	<a href="list_1.jsp">제품 목록 페이지</a>
	
	
</body>
</html>