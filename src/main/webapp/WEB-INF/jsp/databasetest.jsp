<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.example.demo.entities.Reparto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Market Data Base Test</title>
</head>
<body>
	<h1>Market Database Test is Working ...</h1>
	
	<%
	Reparto reparto = (Reparto) request.getAttribute("reparto");
	%>
	<div>
		<p>Reparto:</p>
		<p>Descrizione: <%=reparto.getDescrizione() %></p>
		<p>      Sigla: <%=reparto.getSigla() %></p>
		<p>  Posizione: <%=reparto.getPosizione() %></p>
	</div>
	<div><a href="/index.html">Home</a></div>
</body>
</html>