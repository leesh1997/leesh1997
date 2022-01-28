<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>세션 저장</h1>
	<%
		//세션: 사용자의 정보를 서버에 저장하는 기술
		// - 노출되면 안되는 중요한 정보들
		
		//setAttribute(이름, 값)
		//값: Object타입으로 설정하게 되어있지만 다른 타입을 넣어도
		//	 업캐스팅이 일어나기 때문에 반드시 Object타입을 넣을 필요는 없음
		session.setAttribute("msg", "세션에 데이터 저장");
		session.setAttribute("num", 150);		
	
		ArrayList<String> list = new ArrayList<String>();
		list.add("오늘");
		list.add("미세먼지가");
		list.add("최악이네요..");
		
		session.setAttribute("list", list);
		
		//세션정보의 유효기간을 설정하는 메소드(초단위)
		session.setMaxInactiveInterval(60);
		
	%>
</body>
</html>