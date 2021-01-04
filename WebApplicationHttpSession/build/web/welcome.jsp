<%-- 
    Document   : welcome
    Created on : 22/04/2020, 05:31:58 PM
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
            if (request.getParameter("contrasena")!= null){
                if (request.getParameter("contrasena").equals("123456")){
                    HttpSession mySession = request.getSession();
                    mySession.setAttribute("usuario", request.getParameter("usuario"));
                    mySession.setAttribute("contrasena", request.getParameter("contrasena")); 
//Esto solo es para enseñar que se pueden agregar dos valores, no es una buena práctica guardar así la contraseña
                    out.println("<p>Bienvenido " + request.getParameter("usuario") + "</p>");
                    out.println("<a href = 'profile.jsp'>Visita tu perfil</a>");
                } else{
                    response.sendRedirect("index.jsp");
                }
            } else{
                response.sendRedirect("index.jsp");
            }
            
        %>
        
    </body>
</html>
