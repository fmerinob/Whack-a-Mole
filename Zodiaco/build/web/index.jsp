<%-- 
    Document   : index
    Created on : 13/04/2020, 05:35:55 PM
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
        if(request.getAttribute("message") != null){
            out.println("Hubo un error en la captura de datos");
        }
        %>
        <form action="SignZodiac">
            
            <h1>Zodiaco</h1>
            <table border="1">
                <thead>
                    <tr>
                        <th>¿Cuál es tu fecha de nacimiento?</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Dia</td>
                        <td><input type="text" name="dia" value="" /></td>
                    </tr>
                    <tr>
                        <td>Mes</td>
                        <td><input type="text" name="mes" value="" /></td>
                    </tr>
                    <tr>
                        <td>Año</td>
                        <td><input type="text" name="ano" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="reset" value="Limpiar" name="limpiar" /></td>
                        <td><input type="submit" value="Enviar" name="enviar" /></td>
                    </tr>
                </tbody>
            </table>

            
        </form>
        
    </body>
</html>
