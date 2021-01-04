<%-- 
    Document   : welcome
    Created on : 15/04/2020, 05:12:32 PM
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
        <h1>Hello <% out.println(request.getParameter("usuario")); %>!</h1>
    </body>
</html>
