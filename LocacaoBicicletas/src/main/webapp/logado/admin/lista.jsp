<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<a href="${pageContext.request.contextPath}/admin/cadastro">CADASTRO</a>
	
	
	<table>
		<c:forEach var="usuario" items="${requestScope.listaUsuarios}">
			<tr>
				<td><c:out value="${usuario.CPF}" /></td>
				<td><c:out value="${usuario.login}" /></td>
				<td><c:out value="${usuario.senha}" /></td>
				<td><c:out value="${usuario.nome}" /></td>
				<td>Teste</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

