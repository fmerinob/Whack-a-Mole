<%-- 
    Document   : page1
    Created on : 4/05/2020, 05:45:52 PM
    Author     : Polupero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! Hola Mundo!</h1>
        <%
            out.write(request.getParameter("name"));
        %>
    </body>
</html>
