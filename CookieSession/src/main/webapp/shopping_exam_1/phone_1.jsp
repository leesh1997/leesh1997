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
	갤럭시 노트10+ 5G에 대한 상세 페이지입니다.<br>
	모델명: 갤럭시 노트10+ 5G<br>
	제품가격: 1,397,000원<br>
		<img src="http://www.earlyadopter.co.kr/wp-content/uploads/2019/08/Note10_2-1024x683.jpg" width="300px">
		<br>
		
	<%
		//1.상품정보를 저장한 쿠키객체 생성
		Cookie cookie = new Cookie("item2", URLEncoder.encode("갤럭시 노트10+5G","UTF-8"));
		
		//2.1시간동안 유지
		cookie.setMaxAge(60*60);
		
		//3.클라이언트PC에 쿠키를 보내기 위해 response객체에 저장
		response.addCookie(cookie);	
	%>
	
	<a href="list_1.jsp">제품 목록 페이지</a>	
</body>
</html>