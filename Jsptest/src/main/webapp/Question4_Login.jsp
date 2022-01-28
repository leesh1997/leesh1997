<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body{background: whitesmoke; text-align: center;}
	fieldset {border:3px dotted blue;}
	table{margin:0 auto;}
</style>
</head>
<body>
	<form action="LoginCon" method="post">
		<fieldset>
			<legend><h2>도서관리 프로그램</h2></legend>
			
			<table>
				<tr>	
					<td>ID</td>
					<td><input type="text" name="id"></td>
					<td rowspan="3">
						<input type="submit" value="로그인">
					</td>
				</tr>
				<tr>	
					<td>PW</td>
					<td><input type="password" name="pw"></td>
				</tr>
			</table>
			아이디가 없다면 <a href="Question4_Join.jsp">회원가입</a>클릭
		</fieldset>
	</form>
</body>
</html>