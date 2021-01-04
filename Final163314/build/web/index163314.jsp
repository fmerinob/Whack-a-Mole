<%-- 
    Document   : index163314
    Created on : 1/06/2020, 05:02:22 PM
    Author     : Polupero
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con
                    = DriverManager.getConnection("jdbc:derby://localhost:1527/misdatos163314", "root", "root");
            Statement query = con.createStatement();

            ResultSet rs = query.executeQuery("SELECT * FROM MITABLA163314");

            while (rs.next()) {
                out.println(rs.getInt("IDENTIFICADOR163314") + " | ");
                out.println(rs.getString("CLIENTE163314") + " | ");
                out.println(rs.getString("DOMICILIO163314") + " | ");
                out.println(rs.getDouble("SALDO163314") + "<br>");
            }
            //con.commit(); No lo uso porque ya estoy haciendo el execute update
            con.close();

        %>

        <script async src=“mijavascript163314.js”></script>

        <h3>Listado de clientes</h3>

        <h3>Agrega un registro</h3>

        <table border="1">
            <tbody>
                <tr>
                    <td>Identificador:</td>
                    <td><input type="text" name="AIdentificador163314" value="" /></td>
                    <td>Cliente:</td>
                    <td><input type="text" name="ACliente163314" value="" /></td>
                    <td>Domicilio:</td>
                    <td><input type="text" name="ADomicilio163314" value="" /></td>
                    <td>Saldo:</td>
                    <td><input type="text" name="ASaldo163314" value="" /></td>
                </tr>
            </tbody>
        </table>
        <input type="submit" value="Agrega" onclick="Agrega(AIdentificador163314.value, ACliente163314.value, ADomicilio163314.value, ASaldo163314.value)"/>

            <h3>Borra un registro</h3>

            <table border="1">
                <tbody>
                    <tr>
                        <td>Identificador:</td>
                        <td><input type="text" name="BIdentificador163314" value="" /></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Borra" onclick="Borra(BIdentificador163314.value)" />

            <h3>Actualiza un registro</h3>
            <table border="1">
                <tbody>
                    <tr>
                        <td>Identificador:</td>
                        <td><input type="text" name="Identificador163314" value="" /></td>
                        <td>Cliente:</td>
                        <td><input type="text" name="Cliente163314" value="" /></td>
                        <td>Domicilio:</td>
                        <td><input type="text" name="Domicilio163314" value="" /></td>
                        <td>Saldo:</td>
                        <td><input type="text" name="Saldo163314" value="" /></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Actualiza" onclick="Actualiza(Identificador163314.value, Cliente163314.value, Domicilio163314.value, Saldo163314.value)" />

    </body>
</html>
