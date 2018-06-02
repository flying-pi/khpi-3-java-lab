<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 02.06.18
  Time: 8:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/lab6/registration" method="get">
    <label> Name:
        <input type="text" name="name" value="${name}">
    </label>
    <label> Password:
        <input type="password" name="pass" value="${pass}">
    </label>
    <label> Is send email:
        <input type="checkbox" name="is_send" ${is_send}>
    </label>
    <input type="submit" title="Submit">
</form>
</body>
</html>
