<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 02.06.18
  Time: 8:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
<c:forEach items="${requestScope.products}" var="product">
    <tr>
        <td><c:out value="${product.name}"></c:out></td>
        <td><c:out value="${product.price}"></c:out></td>
    </tr>
</c:forEach>
</table>
</body>
</html>
