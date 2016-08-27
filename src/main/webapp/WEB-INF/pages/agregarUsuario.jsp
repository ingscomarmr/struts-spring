<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar Usuario</title>
</head>
<body>
	<form:form action="altaPersona.ctrl" method="POST"
		commandName="persona" >
		<table>
			<tr>
				<td colspan="2" style="text-align: center;">Datos de Persona</td>
			</tr>
			<tr>
				<td><form:label path="nombre">Nombre:</form:label></td>
				<td><form:input path="nombre" /></td>
			</tr>
			<tr>
				<td><form:label path="apePaterno">Apellido Paterno</form:label></td>
				<td><form:input path="apePaterno" /></td>
			</tr>
			<tr>
				<td><form:label path="apeMaterno">Apellido Materno</form:label></td>
				<td><form:input path="apeMaterno" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td colspan="2"><form:hidden path="idPersona" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Registrar" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>