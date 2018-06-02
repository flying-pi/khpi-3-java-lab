<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 02.06.18
  Time: 6:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="javafx.util.Pair" %>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <title>$Title$</title>
</head>
<body>
<div>
    <a onclick="window.history.back()" style="font-weight: 900;font-size: 22px">Back</a>
</div>
<div>
    <h1> Request:</h1>
    <table>
        <%
            ArrayList<Pair<String,String>> params = (ArrayList<Pair<String, String>>) request.getAttribute("params");
            for (int i = 0; i < params.size(); i++) {
        %>
        <tr>
            <td><% out.print(params.get(i).getKey()); %></td>
            <td><% out.print(params.get(i).getValue()); %></td>
        </tr>
        <%}%>
    </table>


    <h3> Header:</h3>
    <table>
        <%
            ArrayList<Pair<String,String>> headers = (ArrayList<Pair<String, String>>) request.getAttribute("headers");
            for (int i = 0; i < headers.size(); i++) {
        %>
        <tr>
            <td><% out.print(headers.get(i).getKey()); %></td>
            <td><% out.print(headers.get(i).getValue()); %></td>
        </tr>
        <%}%>
    </table>

</div>
</body>
</html>
