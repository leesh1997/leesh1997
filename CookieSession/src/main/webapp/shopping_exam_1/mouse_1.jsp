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
	마우스에 대한 상세 페이지입니다.<br>
	모델명: 로지텍 게이밍 마우스<br>
	제품가격: 21,900원<br>
	
	<img src="http://th3.tmon.kr/thumbs/image/742/c10/e07/21ad84eb3_700x700_95_FIT.jpg", width="300px">
	<br>
	<%
	
		//1.상품정보를 저장한 쿠키객체 생성
		Cookie cookie = new Cookie("item1",URLEncoder.encode("로지텍 게이밍 마우스","UTF-8"));
		
		//2.1시간동안 유지
		cookie.setMaxAge(60*60);
		
		//3.클라이언트PC에 쿠키를 보내기 위해 response객체에 저장
		response.addCookie(cookie);
	%>
	
	<a href="list_1.jsp">제품 목록 페이지</a>
	
	
</body>
</html>