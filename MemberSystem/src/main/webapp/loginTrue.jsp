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
	<!-- 세션에 저장된 닉네임을 출력해보기 -->
	<h1><%=session.getAttribute("nick")%>님! 환영해유!
	</h1>

	<%-- <h1>
		<%=request.getParameter("nick") %>님! 환영합니다!

		<!-- 닉네임이 저장된 쿠키정보를 가져온 후 웹 페이지에 출력하시오. -->
		<%
		Cookie[] cookies = request.getCookies();
			for (int i = 0; i < cookies.length; i++) {
				if(cookies[i].getName().equals("nick")){
					String value = URLDecoder.decode(cookies[i].getValue(), "UTF-8");
					out.print(value + "님! 환영합니다!");
					break;
				}
			}
		%>
	</h1> --%>


</body>
</html>