<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/layout.css"
	rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu do Sistema</title>
</head>
<fmt:bundle basename="messages">
	<body>
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
			<fmt:message key="user_page" />
		</h1>
		<p>
			<fmt:message key="hello" />
			${sessionScope.usuarioLogado.papel}
		</p>
		<ul>
			<li><a
				href="${pageContext.request.contextPath}/usuario/FormularioAluguel"><fmt:message
						key="rent_bike" /></a></li>
		</ul>
		<form action="${pageContext.request.contextPath}/logout" method="post">
			<input type="submit" value="<fmt:message key="exit"/>"/>
		</form>
		<table>
			<tr>
				<th><fmt:message key="comp" /></th>
				<th><fmt:message key="date" /></th>
				<th><fmt:message key="time" /></th>
			</tr>
			<c:forEach var="locacao" items="${listaLocacoes}">
				<tr>
					<c:choose>
						<c:when
							test="${locacao.cpf.equals(sessionScope.usuarioLogado.cpf)}">
							<td><c:out value="${locacao.cnpj}" /></td>
							<td><c:out value="${locacao.data}" /></td>
							<td><c:out value="${locacao.hora}" /></td>
						</c:when>
					</c:choose>
				</tr>
			</c:forEach>
		</table>
</fmt:bundle>
</body>
</html>