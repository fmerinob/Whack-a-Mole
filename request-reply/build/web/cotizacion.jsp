<%-- 
    Document   : cotizacion
    Created on : 30/03/2020, 06:18:20 PM
    Author     : Polupero
Abajo del  año 2000 4200, arriba, 7800
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Sistema de Cotización de Seguros de Auto</h1>
        <%
            int modelo = 0, valor = 0;
            String nombre = request.getParameter("nombre"), apellidos = request.getParameter("apellidos"), genero = request.getParameter("genero"), estado = request.getParameter("estado"), edad = request.getParameter("edad");
            if(nombre!=null && apellidos!=null){
                out.println("<p>Estimado " + nombre + " " + apellidos + "</p>");
            }
            else{
                out.println("<p>Nombre Desconocido" + "</p>");
            }
            out.println("<p>En funcion a los datos proporcionados " + "</p>");
            if(genero!=null){
                out.println("<p>Género: " + genero + "</p>");
            }
            else{
                out.println("<p>Género Desconocido" + "</p>");
            }
            if(edad!=null){
                out.println("<p>Edad: " + edad + "</p>");
            }
            else{
                out.println("<p>Edad Desconocida" + "</p>");
            }
            if(estado!=null){
                out.println("<p>Estado: " + estado + "</p>");
            }
            else{
                out.println("<p>Estado Desconocido" + "</p>");
            }
            if(request.getParameter("marca")!=null){
                out.println("<p>Marca: " + request.getParameter("marca")+ "</p>");
            }
            else{
                out.println("<p>Marca Desconocida" +"</p>");
            }
            if(request.getParameter("modelo")!=null){
                out.println("<p>Modelo: " + request.getParameter("modelo")+"</p>");
                modelo = Integer.parseInt(request.getParameter("modelo"));
                if(modelo <=2000){
                    valor = 4200;
                }
                else{
                    valor = 7800;
                }
            }
            else{
                out.println("<p>Modelo Desconocido" +"</p>");
                valor = 0;
            }
            if(request.getParameter("placas")!=null){
                out.println("<p>Placas: " + request.getParameter("placas")+"</p>");
            }
            else{
                out.println("<p>Placas Desconocidas" +"</p>");
            }
            out.println("<p>La cotización de su seguro es: " +"</p>");
            out.println("<p>"+"</p>");
            out.println("<p>"+ valor +"</p>");
        %>
    </body>
</html>
