<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>

<body>
	<ul>
		<li><a href="${pageContext.request.contextPath}/logout.jsp">Sair</a>
		</li>
	</ul>
	<h1>LISTA CLIENTES</h1>
	
	<a href="${pageContext.request.contextPath}/admin/CRUD_cliente/cadastro">CADASTRO de novo cliente</a>

	<table border="1">
		<tr>
			<th>CPF</th>
			<th>Data de Nascimento</th>
			<th>E-mail</th>
			<th>Nome</th>
			<th>Login</th>
		</tr>
		<c:forEach var="usuario" items="${requestScope.listaUsuarios}">
			<tr>
				<td><c:out value="${usuario.cpf}" /></td>
				<td><c:out value="${usuario.dataNascimento}" /></td>
				<td><c:out value="${usuario.email}" /></td>
				<td><c:out value="${usuario.nome}" /></td>
				<td><c:out value="${usuario.login}" /></td>
				<td><a href="${pageContext.request.contextPath}/admin/CRUD_cliente/edicao?cpf=${usuario.cpf}">EDICAO</a> &nbsp;&nbsp;&nbsp;&nbsp;
					<a href="${pageContext.request.contextPath}/admin/CRUD_cliente/remocao?cpf=${usuario.cpf}">REMOCAO</a></td>
			</tr>
		</c:forEach>
	</table>
	
		<h1>LISTA LOCADORAS</h1>
		<table border="1">
		<tr>
			<th>CNPJ</th>
			<th>E-mail</th>
			<th>Nome</th>
			<th>Cidade</th>
		</tr>
		<c:forEach var="locadora" items="${requestScope.listaLocadoras}">
			<tr>
				<td><c:out value="${locadora.cnpj}" /></td>
				<td><c:out value="${locadora.email}" /></td>
				<td><c:out value="${locadora.nome}" /></td>
				<td><c:out value="${locadora.cidade}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

