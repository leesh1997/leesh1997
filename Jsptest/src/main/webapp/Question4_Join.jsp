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
	<form action="JoinCon" method="post">
		<fieldset>
			<legend><h2>회원가입</h2></legend>
			
			<table>
				<tr>	
					<td>ID</td>
					<td><input type="text" name="id"></td>
					
				</tr>
				<tr>	
					<td>PW</td>
					<td><input type="password" name="pw"></td>
					<td rowspan="3">
						<input type="submit" value="가입">
					</td>
				</tr>
				<tr>	
					<td>NICKNAME</td>
					<td><input type="text" name="nick"></td>
					
				</tr>
				<tr>	
					<td>EMAIL</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>	
					<td>TEL</td>
					<td><input type="text" name="tel"></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>