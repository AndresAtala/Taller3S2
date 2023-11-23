<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 23-11-2023
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <head>
        <meta charset="UTF-8">
        <title>Agregar Asistente</title>
        <link rel="stylesheet" type="text/css" href="Style.css">
    </head>
    <meta charset="UTF-8">
    <title>Agregar Asistente</title>
</head>
<body>
<h2>Agregar Asistente</h2>
<form action="RegistroAsistenteServlet" method="post">
    Nombre: <input type="text" name="nombre" required><br>
    Teléfono: <input type="text" name="telefono" required><br>
    Preferencias Musicales: <input type="text" name="preferenciasMusicales" required><br>
    <input type="submit" value="Agregar Asistente">
</form>
<li><a href="index.jsp">INICIO</a></li>
</body>
</html>
