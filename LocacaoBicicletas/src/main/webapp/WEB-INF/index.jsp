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
		<form method="post" action="index.jsp">
			<div class="lisca-locadoras-index">
				<p>Lista de Locadoras</p>
				<h1 for="cidade">Escolha a cidade</h1> <select id="cidade" name="cidade"
					onchange="this.form.submit()">
					<option value='--'>Selecione</option>
					<option value='todasCidades'>Todas</option>
					<c:forEach items='${listaLocadorasOpcoes}' var='locadora'>
						<option value='${locadora.cidade}'>${locadora.cidade}</option>
					</c:forEach>
				</select>
				<div id="tabela">
					<table>
						<tr>
							<th>CNPJ</th>
							<th>E-mail</th>
							<th>Nome</th>
							<th>Cidade</th>
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
		<a style="text-align: center;" href='https://www.freepik.com/photos/background'>Background photo created by jcomp - www.freepik.com</a>
	</body>
	</html>