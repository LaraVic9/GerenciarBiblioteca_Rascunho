<%@page import=" app.LoginServlet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	
	
		<h1>Bem Vindo a Biblioteca(a definir o nome)!!!</h1>
	
		<h2>Vamos criar o seu primeiro login</h2>
		
		<h1></h1>
	
		<form action="Inicial.jsp" method="post">
		
			
			Email<input type="text" name="field_email" /> <br />
			Senha<input type="password" name="field_senha" /> <br />
				
			<br />	
			<input type="submit" value="enviar" />
			
		</form>
</body>
</html>