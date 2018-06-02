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
  <form action="/calculator/result" method="post">
    <input type="number" name="a">
    <select name="operation">
      <option value="plus" selected> + </option>
      <option value="minus"> - </option>
      <option value="mull"> * </option>
      <option value="div"> / </option>
    </select>
    <input type="number" name="b">
    <input type="submit" title="Submit">
  </form>
  </body>
</html>
