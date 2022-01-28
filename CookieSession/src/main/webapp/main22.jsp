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
		String id = (String)session.getAttribute("id");
		String nick = (String)session.getAttribute("nick");
	%>

	<%
			if(id == null){%>

	<h1>로그인 페이지</h1>
	<form action="LoginService222" method="post">
		<table border="1">
			<tr>
				<td><input type="text" name="id" placeholder="ID를 입력해주세요"></td>
			</tr>
			<tr>
				<td><input type="password" name="pw" placeholder="PW를 입력해주세요"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" name="로그인"></td>
			</tr>
		</table>
	</form>
	<%}else {%>
	<h1> <%= session.getAttribute("nick") %></h1>
	로그인 중입니다. <br>
	<a href = 'logout.jsp'>로그아웃 </a>
	<%} %>
</body>
</html>