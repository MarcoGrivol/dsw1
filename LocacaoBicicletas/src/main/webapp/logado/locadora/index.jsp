<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
    </fmt:bundle>
</body>
</html>