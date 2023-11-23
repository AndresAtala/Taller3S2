<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 23-11-2023
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar Asistente</title>
    <link rel="stylesheet" type="text/css" href="Style.css">
    <meta charset="UTF-8">
    <title>Agregar Artista</title>
</head>
<body>
<h2>Agregar Artista</h2>
<form action="RegistroArtistaServlet" method="post">
    Nombre Artístico: <input type="text" name="nombreArtistico" required><br>
    Género Musical: <input type="text" name="generoMusical" required><br>
    <input type="submit" value="Agregar Artista">
</form>
<li><a href="index.jsp">INICIO</a></li>
</body>
</html>

