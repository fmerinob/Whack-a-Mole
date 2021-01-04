<%-- 
    Document   : index
    Created on : 27/04/2020, 05:28:35 PM
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
        <h1>STAFF</h1>
        <%
            Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection con =
            DriverManager.getConnection("jdbc:derby://localhost:1527/MyDatabase","root","root"); 
            /* TODO output your page here. You may use following sample code. */
            Statement query = con.createStatement();
            
            if(request.getParameter("add")!=null){
                if(request.getParameter("id")!=null && request.getParameter("name")!=null && request.getParameter("balance")!=null ){
                    query.executeUpdate("INSERT INTO CUSTOMERS VALUES ("+request.getParameter("id")+", '"+request.getParameter("name")+"' ,"+request.getParameter("balance")+")");
                }
            }
            if(request.getParameter("update")!=null){
                if(request.getParameter("id")!=null && request.getParameter("name")!=null && request.getParameter("balance")!=null ){
                    query.executeUpdate("UPDATE CUSTOMERS SET NAME='"+request.getParameter("name")+"'WHERE ID="+request.getParameter("id"));
                    query.executeUpdate("UPDATE CUSTOMERS SET BALANCE="+Double.valueOf(request.getParameter("balance"))+" WHERE ID="+request.getParameter("id")); 
//Recordar quitar las comillas en balance para que tome el número y no la palabra; además, real es compatible con double
                }
            }
            if(request.getParameter("delete")!=null){
                if(request.getParameter("id")!=null){
                    query.executeUpdate("DELETE FROM CUSTOMERS where ID="+request.getParameter("id"));
                }
            }
            
            ResultSet rs = query.executeQuery("SELECT * FROM CUSTOMERS");
            
            
            while(rs.next()) {
                out.println(" Id: "+ rs.getInt("ID"));
                out.println(" Name: "+ rs.getString("NAME"));
                out.println(" Balance: "+ rs.getDouble("BALANCE")+"<br>");
            }
            //con.commit(); No lo uso porque ya estoy haciendo el execute update
            con.close();
            
        %>
        <form action="index.jsp">
            <h1>Add a record</h1>
            <table border="1">
                <tbody>
                    <tr>
                        <td>ID:</td>
                        <td><input type="text" name="id" value="" /></td>
                        <td>NAME:</td>
                        <td><input type="text" name="name" value="" /></td>
                        <td>BALANCE</td>
                        <td><input type="text" name="balance" value="" /></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="ok" name="add" />
        </form>
        
        <form action="index.jsp">
            <h1>Delete a record</h1>
            <table border="1">
                <tbody>
                    <tr>
                        <td>ID:</td>
                        <td><input type="text" name="id" value="" /></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="ok"name="delete" />
        </form>
        
        <form action="index.jsp">
            <h1>Update a record</h1>
            <table border="1">
                <tbody>
                    <tr>
                        <td>ID:</td>
                        <td><input type="text" name="id" value="" /></td>
                        <td>NAME:</td>
                        <td><input type="text" name="name" value="" /></td>
                        <td>BALANCE</td>
                        <td><input type="text" name="balance" value="" /></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="ok" name="update"/>
        </form>
    </body>
</html>