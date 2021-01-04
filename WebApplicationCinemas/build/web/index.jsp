<%-- 
    Document   : index
    Created on : 15/04/2020, 06:30:44 PM
    Author     : ferch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CineMAS</title>
    </head>
    <body>
        <h1>¡Bienvenido a CineMAS!</h1>
        <p>Permitenos recomendarte una película</p>
        <form action="GetSuggestion">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Zona: </td>
                        <td><select name="zona">
                                <option>Centro</option>
                                <option>Sur</option>
                                <option>Norte</option>
                                <option>Este</option>
                                <option>Oeste</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td>Tipo de Película: </td>
                        <td><select name="tipo">
                                <option>Comedia</option>
                                <option>Accion</option>
                                <option>Drama</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td><input type="reset" value="Limpiar" /></td>
                        <td><input type="submit" value="Ver Recomendación" /></td>
                    </tr>
                </tbody>
            </table>

        </form>
    </body>
</html>
