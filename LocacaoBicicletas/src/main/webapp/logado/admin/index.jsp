<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/layout.css"
	rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>LocacaoBicicletas</title>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>

<body>
	<fmt:bundle basename="messages">
		<c:if test="${mensagens.existeErros}">
			<div id="erro">
				<ul>
					<c:forEach var="erro" items="${mensagens.erros}">
						<li>${erro}</li>
					</c:forEach>
				</ul>
			</div>
		</c:if>
		<h1>
			<fmt:message key="adm_page" />
		</h1>
		<p>
			<fmt:message key="hello" />
			${sessionScope.usuarioLogado.papel}
		</p>


		<form action="${pageContext.request.contextPath}/logout" method="post">
			<input type="submit" value="<fmt:message key="exit"/>" />
		</form>

		<h1>
			<fmt:message key="cust_list" />
		</h1>

		<a
			href="${pageContext.request.contextPath}/admin/CRUD_cliente/cadastro"><fmt:message
				key="customer_regist" /></a>

		<table border="1">
			<tr>
				<th>CPF</th>
				<th><fmt:message key="birthdate" /></th>
				<th>E-mail</th>
				<th><fmt:message key="name" /></th>
				<th><fmt:message key="login" /></th>
			</tr>
			<c:forEach var="usuario" items="${requestScope.listaUsuarios}">
				<tr>
					<td><c:out value="${usuario.cpf}" /></td>
					<td><c:out value="${usuario.dataNascimento}" /></td>
					<td><c:out value="${usuario.email}" /></td>
					<td><c:out value="${usuario.login}" /></td>
					<td><c:out value="${usuario.nome}" /></td>
					<td><c:out value="${usuario.sexo}" /></td>
					<td><c:out value="${usuario.telefone}" /></td>
					<td><a class=edit
						href="${pageContext.request.contextPath}/admin/CRUD_cliente/edicao?cpf=${usuario.cpf}"><fmt:message
								key="edit" /></a> &nbsp;&nbsp;&nbsp;&nbsp; 
					<c:if test="${!listaLocacoesCpf.contains(usuario.cpf)}">
							<a class=remove
								href="${pageContext.request.contextPath}/admin/CRUD_cliente/remocao?cpf=${usuario.cpf}"><fmt:message
									key="remove" /></a>
					</c:if></td>
				</tr>
			</c:forEach>
		</table>

		<h1>
			<fmt:message key="rent_list" />
		</h1>
		<a
			href="${pageContext.request.contextPath}/admin/CRUD_locadora/cadastro"><fmt:message
				key="rent_regist" /></a>
		<table border="1">
			<tr>
				<th>CNPJ</th>
				<th>E-mail</th>
				<th><fmt:message key="name" /></th>
				<th><fmt:message key="city" /></th>
			</tr>
			<c:forEach var="locadora" items="${requestScope.listaLocadoras}">
				<tr>
					<td><c:out value="${locadora.cnpj}" /></td>
					<td><c:out value="${locadora.email}" /></td>
					<td><c:out value="${locadora.nome}" /></td>
					<td><c:out value="${locadora.cidade}" /></td>
					<td><a class=edit
						href="${pageContext.request.contextPath}/admin/CRUD_locadora/edicao?cnpj=${locadora.cnpj}"><fmt:message
								key="edit" /></a> &nbsp;&nbsp;&nbsp;&nbsp;
					<c:if test="${!listaLocacoesCnpj.contains(locadora.cnpj)}">
					 <a class=remove
						href="${pageContext.request.contextPath}/admin/CRUD_locadora/remocao?cnpj=${locadora.cnpj}"><fmt:message
								key="remove" /></a>
					</c:if></td>
				</tr>
			</c:forEach>
		</table>
	</fmt:bundle>
</body>
</html>

