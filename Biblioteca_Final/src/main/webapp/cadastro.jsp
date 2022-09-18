
<%@page import=" app.LoginServlet" %>
<%@page import=" repository.UsuarioRepository" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro usuario Leitor</title>
</head>
<body>

	<%
	
	//cast 
	//coercao
	String erro4 = (String) request.getAttribute("erro");
	
	%>
	
	<% if(erro4 != null){ %>
		<p><% out.println(erro4); %></p>
	<% } %>

	<h1>Bem Vindo a Biblioteca(a definir o nome)!!!</h1>

	<h2>Vamos criar o seu primeiro cadastro</h2>
	
	<h1></h1>

	<form method="post" action="http://localhost:8080/Biblioteca/processa">
	
		
		<input type="text" name="field_nome" value="nome..." /> <br />
		<input type="text" name="field_sobrenome" value="sobrenome..." /> <br />
			
		<br />	
		<input type="submit" value="enviar" />
		
	</form>

</body>
</html>