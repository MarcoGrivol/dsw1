<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<h3>CAMPOS</h3>

<table border="1">
 	<fmt:bundle basename="messages">
	<caption>
		<c:choose>
			<c:when test="${locadora != null}">
		<label for="edit">
	</c:when>
			<c:otherwise>
		<label for="regist">
	</c:otherwise>
		</c:choose>
	</caption>


	<tr>
		<td><label for="cnpj">CNPJ</label></td>
		<c:choose>
		<c:when test="${locadora != null}">
			<td><input type="text" id="cnpj" name="cnpj" required
			value="${locadora.cnpj}" readonly/></td>
		</c:when>
		<c:otherwise>
			<td><input type="text" id="cnpj" name="cnpj" required
			value="${locadora.cnpj}"/></td>
		</c:otherwise>
		</c:choose>
	</tr>
	<tr>
		<td><label for="email">E-mail</label></td>
		<td><input type="text" id="email" name="email"
			value="${locadora.email}" /></td>
	</tr>
	<tr>
		<td><label for="nome"><fmt:message key="name"/></label></td>
		<td><input type="text" id="nome" name="nome"
			value="${locadora.nome}" /></td>
	</tr>
	<tr>
		<td><label for="senha"><fmt:message key="password"/></label></td>
		<td><input type="password" id="senha" name="senha"
			value="${locadora.senha}" /></td>
	</tr>
	<tr>
		<td><label for="cidade"><fmt:message key="city"/></label></td>
		<td><input type="text" id="cidade" name="cidade"
			value="${locadora.cidade}" /></td>
	</tr>
		<tr>
		<td><input type="hidden" id="papel" name="papel"
			value="${locadora.papel}" /></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="Salvar" /></td>
	</tr>
    </fmt:bundle>
</table>

