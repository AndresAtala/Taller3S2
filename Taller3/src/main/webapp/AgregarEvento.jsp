<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 23-11-2023
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar Evento</title>
</head>
<body>
<h2>Agregar Evento Musical</h2>
<form action="RegistroEventoServlet" method="post">
    Nombre del Evento: <input type="text" name="nombreEvento" required><br>
    Fecha: <input type="text" name="fecha" placeholder="YYYY-MM-DD" required><br>
    Lugar: <input type="text" name="lugar" required><br>
    Artistas: <input type="text" name="artistas" required><br>
    <input type="submit" value="Agregar Evento">
</form>
</body>
</html>
