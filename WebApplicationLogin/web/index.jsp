<%-- 
    Document   : index
    Created on : 15/04/2020, 05:12:18 PM
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
        <h1>Ingreso al sistema</h1>
        <form action="LoginServlet">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Usuario</td>
                        <td><input type="text" name="usuario" value="Octavio" /></td>
                    </tr>
                    <tr>
                        <td>Contraseña</td>
                        <td><input type="password" name="contrasena" value="" /></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Ingresar" />
        </form>
    </body>
</html>
