<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td colspan="2" style="text-align: center;">Personal Registrado</td>
		</tr>
		<tr>
			<td>Nombre:</td>
			<td>${p.nombre}</td>
		</tr>
		<tr>
			<td>Apellidos:</td>
			<td>${p.apePaterno} ${p.apeMaterno}</td>
		</tr>
		<tr>
			<td>Email:</td>
			<td>${p.email}</td>
		</tr>
	</table>
	<a href="agregarPeronaForm.ctrl">Agregar otra persona</a>
</body>
</html>