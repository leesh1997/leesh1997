<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>쿠키정보 조회</h1>
	
	<%
	//사용자의 쿠키정보는 request객체로부터 접근이 가능!
	//접근 시 Cookie배열을 반환받을 수 있음!
	Cookie[] cookies = request.getCookies();
	
	//반복문을 활용해서 모든 쿠키의 이름과 값을 웹 페이지에 출력하시오.!
	for (int i = 0; i < cookies.length; i++){
		out.print("쿠키이름: " + cookies[i].getName() + "<br>");
		//out.print("쿠키 값: " + cookies[i].getValue());
		
		out.print("쿠키 값: " + URLDecoder.decode(cookies[i].getName(),"UTF-8"));
		out.print("<hr>");
	}
	
	%>
	
	
</body>
</html>