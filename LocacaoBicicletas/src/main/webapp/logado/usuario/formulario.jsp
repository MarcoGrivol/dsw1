<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<h3>CAMPOS</h3>

<table border="1">
 	<fmt:bundle basename="messages">
	
	<form action="cadastroAluguel">
		<tr>
			<td><label for="Locadora"><fmt:message key="company"/></label></td>
			<td><select name="locadora" id="locadora">
			<c:forEach var="locadora" items="${requestScope.ListaLocadoras}">
				<option value="${locadora.cnpj}"> "${locadora.nome}" </option>
			</c:forEach>
			</select>
			</td>
			</tr>
		<tr>
			<td><label for="Data"><fmt:message key="date"/></label></td>
			<td><input type="date" id="Data" name="Data"
				value="" /></td>
		</tr>
			<input type="hidden" id="usuario" name="usuario"
				value="${requestScope.usuario.cpf}" />

		<tr>
			<td><label for="Locadora"><fmt:message key="time"/></label></td>
			<td><select name="hora" id="hora">
			<c:forEach var="hora" begin="0" end="23">
				<option  value="${hora}">${hora} </option>
			</c:forEach>
			</select> </td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Salvar" /></td>
			</tr>
		</form>
    </fmt:bundle>
</table>

