<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LocacaoBicicletas</title>
<link href="${pageContext.request.contextPath}/layout.css"
	rel="stylesheet" type="text/css" />
</head>

<body>
 	<fmt:bundle basename="messages">
	<h2><fmt:message key="form"/></h2>
	<br>
	<c:choose>
		<c:when test="${locadora != null}">
			<form action="atualizacao" method="POST">
				<%@include file="campos.jsp" %>
			</form>
		</c:when>
		<c:otherwise>
			<form action="insercao" method="POST">
				<%@include file="campos.jsp" %>
			</form>
		</c:otherwise>
	</c:choose>
    </fmt:bundle>
</body>
</html>