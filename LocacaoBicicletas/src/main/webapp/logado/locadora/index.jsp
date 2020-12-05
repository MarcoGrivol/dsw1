<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu do Sistema</title>
</head>
<body>
 	<fmt:bundle basename="messages">
	<h1><fmt:message key="edit"/></h1>
	<p><fmt:message key="hello"/> ${sessionScope.usuarioLogado.papel}</p>
	<ul>
		<li><a href="${pageContext.request.contextPath}/logout.jsp"><fmt:message key="exit"/></a>
		</li>
	</ul>
	<table border="1">
		<tr>
			<th><fmt:message key="login"/></th>
			<th><fmt:message key="date"/> </th>
			<th><fmt:message key="time"/> </th>
		</tr>
			
		<c:forEach var="locacao" items="${listaLocacoes}">
			<c:when test = "${locacao.cnpj == usuario.cnpj}">
			<tr>
				<td><c:out value="${locacao.cpf}" /></td>
				<td><c:out value="${locacao.data}" /></td>
				<td><c:out value="${locacao.hora}" /></td>
			</tr>
			</c:when>
		</c:forEach>
	</table>
    </fmt:bundle>
</body>
</html>