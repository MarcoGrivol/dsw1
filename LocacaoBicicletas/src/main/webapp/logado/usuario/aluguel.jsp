<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <link href="${pageContext.request.contextPath}/layout.css"
        rel="stylesheet" type="text/css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AJAX (dynamic select)</title>
    </head>
    <body>
        <br/>
        <form name='form'>
            <table>
                <tr>
                    <td>Locadoras</td>
                    <td>
                        <select id = 'locadora' name='locadora' onchange='locacaoSelecionada(this.value)'>
                            <option value='--'>--</option>
                            <c:forEach items='${Locadora.locadoras}' var='estado'>
                                <option value='${locadora.nome}'>${locadora.nome}</option>
                            </c:forEach>
                        </select>   
                    </td>
                </tr>
            </table>
        </form>
        <br/>
    </body>
</html>