<%-- 
    Document   : final
    Created on : 30/03/2020, 05:35:47 PM
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
        <h1>Resultado</h1>
        
        <%
            if(request.getParameter("parametro_con_post")!=null){
                out.println("<p>Recibí un parámetro via post con valor = " + request.getParameter("parametro_con_post")+ "</p>");
            }
            
            if(request.getParameter("parametro_con_get")!=null){
                out.println("<p>Recibí un parámetro via get con valor = " + request.getParameter("parametro_con_get")+ "</p>");
            }
        %>
        
    </body>
</html>
