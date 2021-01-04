<%-- 
    Document   : index
    Created on : 30/03/2020, 06:18:02 PM
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
        
        <form name="EnviaAuto" action="auto.jsp" method="POST">
            <table border="1">
                <thead>
                    <tr>
                        <th>Campo</th>
                        <th>Valor</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Nombre: </td>
                        <td><input type="text" name="nombre" value="" /></td>
                    </tr>
                    <tr>
                        <td>Apellidos: </td>
                        <td><input type="text" name="apellidos" value="" /></td>
                    </tr>
                    <tr>
                        <td>Género: </td>
                        <td>
                            <label><input type="radio" name="genero" value="Masculino" />Masculino</label>
                            <label><input type="radio" name="genero" value="Femenino" />Femenino</label>
                        </td>
                    </tr>
                    <tr>
                        <td>Edad: </td>
                        <td><input type="text" name="edad" value="" /></td>
                    </tr>
                    <tr>
                        <td>Estado: </td>
                        <td><select name="estado">
                                <option>Ciudad de Mexico</option>
                                <option>Veracruz</option>
                                <option>Estado de Mexico</option>
                                <option>Tlaxcala</option>
                            </select></td>
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
