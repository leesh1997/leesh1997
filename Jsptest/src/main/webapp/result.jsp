<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String name = request.getParameter("name");
	String[] fruit = request.getParameterValues("fruit");
	out.print("<h1>선호도 조사 결과</h1>");
	out.print("<table border='1'>");
	out.print("<tr><td align=\"center\">이름</td><td align=\"center\">" + name + "</td></tr>");
	out.print("<tr><td>좋아하는 과일</td><td>");
	for (int i = 0; i < fruit.length; i++) {
		out.print(fruit[i] + " ");
	}
	out.print("</td></tr>");
	out.print("</table>");
	%>



</body>
</html>