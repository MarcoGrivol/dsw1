<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h3>CAMPOS</h3>

<table border="1">
	<caption>
		<c:choose>
			<c:when test="${usuario != null}">
		EDICAO
	</c:when>
			<c:otherwise>
		CADASTRO
	</c:otherwise>
		</c:choose>
	</caption>


	<tr>
		<td><label for="cpf">CPF</label></td>
		<td><input type="text" id="cpf" name="cpf" required
			value="${usuario.cpf}" readonly/></td>
	</tr>
	<tr>
		<td><label for="dataNascimento">Data de Nascimento</label></td>
		<td><input type="text" id="dataNascimento" name="dataNascimento"
			value="${usuario.dataNascimento}" /></td>
	</tr>
	<tr>
		<td><label for="email">E-mail</label></td>
		<td><input type="text" id="email" name="email"
			value="${usuario.email}" /></td>
	</tr>
	<tr>
		<td><label for="login">Login</label></td>
		<td><input type="text" id="login" name="login"
			value="${usuario.login}" /></td>
	</tr>
	<tr>
		<td><label for="nome">Nome</label></td>
		<td><input type="text" id="nome" name="nome"
			value="${usuario.nome}" /></td>
	</tr>
	<tr>
		<td><label for="senha">Senha</label></td>
		<td><input type="text" id="senha" name="senha"
			value="${usuario.senha}" /></td>
	</tr>

	<tr>
		<td><label for="sexo">Sexo</label></td>
		<td><input type="text" id="sexo" name="sexo"
			value="${usuario.sexo}" /></td>
	</tr>
	<tr>
		<td><label for="telefone">Telefone</label></td>
		<td><input type="text" id="telefone" name="telefone"
			value="${usuario.telefone}" /></td>
	</tr>
		<tr>
		<td><input type="hidden" id="papel" name="papel"
			value="${usuario.papel}" /></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="Salvar" /></td>
	</tr>
</table>

