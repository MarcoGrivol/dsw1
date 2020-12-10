<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<table >
	
	<caption>
		<c:choose>
			<c:when test="${usuario != null}">
		<fmt:message key="edit"/>
	</c:when>
			<c:otherwise>
		<fmt:message key="cadastro"/>
	</c:otherwise>
		</c:choose>
	</caption>


 	<fmt:bundle basename="messages">
	<tr>
		<td><label for="cpf">CPF</label></td>
		<c:choose>
		<c:when test="${usuario != null}">
			<td><input type="text" id="cpf" name="cpf" required
			value="${usuario.cpf}" readonly/></td>
		</c:when>
		<c:otherwise>
			<td><input type="text" id="cpf" name="cpf" required
			value="${usuario.cpf}"/></td>
		</c:otherwise>
		</c:choose>
	</tr>
	<tr>
		<td><label for="dataNascimento"><fmt:message key="birthdate"/></label></td>
		<td><input type="text" id="dataNascimento" name="dataNascimento"
			value="${usuario.dataNascimento}" /></td>
	</tr>
	<tr>
		<td><label for="email">E-mail</label></td>
		<td><input type="text" id="email" name="email"
			value="${usuario.email}" /></td>
	</tr>
	<tr>
		<td><label for="login"><fmt:message key="login"/></label></td>
		<td><input type="text" id="login" name="login"
			value="${usuario.login}" /></td>
	</tr>
	<tr>
		<td><label for="nome"><fmt:message key="name"/></label></td>
		<td><input type="text" id="nome" name="nome"
			value="${usuario.nome}" /></td>
	</tr>
	<tr>
		<td><label for="senha"><fmt:message key="password"/></label></td>
		<td><input type="password" id="senha" name="senha"
			value="${usuario.senha}" /></td>
	</tr>

	<tr>
		<td><label for="sexo"><fmt:message key="gender"/></label></td>
		<td><input type="text" id="sexo" name="sexo"
			value="${usuario.sexo}" /></td>
	</tr>
	<tr>
		<td><label for="telefone"><fmt:message key="tel"/></label></td>
		<td><input type="text" id="telefone" name="telefone"
			value="${usuario.telefone}" /></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="<fmt:message key="salvar"/>" /></td>
	</tr>
	
    </fmt:bundle>
</table>

