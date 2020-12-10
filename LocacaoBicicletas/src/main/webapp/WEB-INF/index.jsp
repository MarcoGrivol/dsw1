<!-- ESTA PAGINA NAO E CARREGADA AUTOMATICAMENTE 
	IndexController.java e carregado em seu lugar, e passa as informacoes necessarias para esta pagina -->

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Autenticação de Usuário</title>
<link href="${pageContext.request.contextPath}/layout.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<fmt:bundle basename="messages">
		<h1><fmt:message key="autentication"/></h1>
		<!-- se o login falhar exibe a mensagem de erro que retorna de LoginController.java -->
		<c:if test="${mensagens.existeErros}">
			<div id="erro">
				<ul>
					<c:forEach var="erro" items="${mensagens.erros}">
						<li><fmt:message key="${erro}" /></li>
					</c:forEach>
				</ul>
			</div>
		</c:if>
		<!-- Formulario de login controlado por LoginController.java -->
		<form method="post" action="login.jsp">
			<table>
				<tr>
					<th><fmt:message key="login"/>:</th>
					<td><input type="text" name="login" value="${param.login}" /></td>
				</tr>
				<tr>
					<th><fmt:message key="password"/>:</th>
					<td><input type="password" name="senha" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" name="bOK" value="<fmt:message key="enter"/>" />
					</td>
				</tr>
			</table>
		</form>

		<!-- Informacoes que nao precisam de nenhum login sao controladas por IndexController.java -->
		<form method="post" action="index.jsp">
			<div class="lisca-locadoras-index" style="centering">
				<h1 for="cidade"><fmt:message key="escolhaCidade"/></h1>
				<p><fmt:message key="rent_list"/></p>
				<select id="cidade" name="cidade" onchange="this.form.submit()">
					<option value='--'><fmt:message key="selecione"/></option>
					<option value='todasCidades'><fmt:message key="todas"/></option>
					<c:forEach items='${listaLocadorasOpcoes}' var='locadora'>
						<option value='${locadora.cidade}'>${locadora.cidade}</option>
					</c:forEach>
				</select>
				<div id="tabela">
					<table>
						<tr>
							<th>CNPJ</th>
							<th>E-mail</th>
							<th><fmt:message key="name"/></th>
							<th><fmt:message key="city"/></th>
						</tr>
						<c:forEach var="locadora" items="${listaLocadoras}">
							<tr>
								<td>${locadora.cnpj}</td>
								<td>${locadora.email}</td>
								<td>${locadora.nome}</td>
								<td>${locadora.cidade}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</form>
		<a style="text-align: center;"
			href='https://www.freepik.com/photos/background'>Background photo
			created by jcomp - www.freepik.com</a>
	</fmt:bundle>
</body>
</html>