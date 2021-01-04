<%-- 
    Document   : profile
    Created on : 22/04/2020, 05:31:50 PM
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
        <%
            HttpSession mySession = request.getSession();
            if(mySession.getAttribute("usuario")!=null){ //Aunque la gente trate de saltar directo hacia acá, pongo esto para ver si paso por la página anterior
                out.println("<p>" + mySession.getAttribute("usuario") + " aqui estan tus fotos</p>");
                out.println("<a href = ''SignOut>Cerrar sesion</a>");
            } else{
                response.sendRedirect("index.html");
            }
        %>
    </body>
</html>
