<%-- 
    Document   : auto
    Created on : 30/03/2020, 06:18:11 PM
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
        <h1>Sistema de Cotización de Seguros de Auto</h1>
        <p>Datos Personales</p>
        <%
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
        %>
        <p>Datos del auto</p>
        
        <form name="EnviaCotizacion" action="cotizacion.jsp" method="POST">
            <table border="1">
                <thead>
                    <tr>
                        <th>Campo</th>
                        <th>Valor</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Marca: </td>
                        <td><select name="marca">
                                <option>Chevrolet</option>
                                <option>Chrysler</option>
                                <option>KIA</option>
                                <option>Renault</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td>Modelo: </td>
                        <td><input type="text" name="modelo" value="" /></td>
                    </tr>
                    <tr>
                        <td>Placas: </td>
                        <td><input type="text" name="placas" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="reset" value="Limpiar" name="limpiar" /></td>
                        <td><input type="submit" value="Enviar" name="enviar" /></td>
                    </tr>
                </tbody>
            </table>
            
            <input type="hidden" name="nombre" value="<%=request.getParameter("nombre")%>" />
            <input type="hidden" name="apellidos" value="<%=request.getParameter("apellidos")%>" />
            <input type="hidden" name="genero" value="<%=request.getParameter("genero")%>" />
            <input type="hidden" name="estado" value="<%=estado%>" />
            <input type="hidden" name="edad" value="<%=request.getParameter("edad")%>" />
        </form>
        
    </body>
</html>
