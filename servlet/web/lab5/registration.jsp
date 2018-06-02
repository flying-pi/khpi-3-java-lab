<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 02.06.18
  Time: 6:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <form action="/lab5/actionA" method="get">
    <label> Name:
      <input type="text" name="name">
    </label>
    <label> Password:
      <input type="password" name="pass">
    </label>
    <input type="submit" title="Submit">
  </form>

  <form action="/lab5/actionB" method="post">
    <label> Name:
      <input type="text" name="name">
    </label>
    <label> Password:
      <input type="password" name="pass">
    </label>
    <input type="submit" title="Submit">
  </form>

  <form action="/lab5/actionC" method="post">
    <label> Name:
      <input type="text" name="name">
    </label>
    <label> Password:
      <input type="password" name="pass">
    </label>
    <input type="submit" title="Submit">
  </form>
  </body>
</html>
