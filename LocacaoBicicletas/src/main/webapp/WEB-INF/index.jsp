<!-- ESTA PAGINA NAO E CARREGADA AUTOMATICAMENTE 
	IndexController.java e carregado em seu lugar, e passa as informacoes necessarias para esta pagina -->

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Autenticação de Usuário</title>
<link href="${pageContext.request.contextPath}/layout.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<h1>Autenticação de Usuário</h1>
	<!-- se o login falhar exibe a mensagem de erro que retorna de LoginController.java -->
	<c:if test="${mensagens.existeErros}">
		<div id="erro">
			<ul>
				<c:forEach var="erro" items="${mensagens.erros}">
					<li>${erro}</li>
				</c:forEach>
			</ul>
		</div>
	</c:if>
	<!-- Formulario de login controlado por LoginController.java -->
	<form method="post" action="login.jsp">
		<table>
			<tr>
				<th>Login:</th>
				<td><input type="text" name="login" value="${param.login}" /></td>
			</tr>
			<tr>
				<th>Senha:</th>
				<td><input type="password" name="senha" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="bOK" value="Entrar" />
				</td>
			</tr>
		</table>
	</form>

	<!-- Informacoes que nao precisam de nenhum login sao controladas por IndexController.java -->
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