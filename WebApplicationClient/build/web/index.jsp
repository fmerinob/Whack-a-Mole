<%-- 
    Document   : index
    Created on : 11/05/2020, 06:55:22 PM
    Author     : Polupero
El punto de esto es que al hacer clic derecho en el proyecto y darle a agregar a
webserviceclient, y en la parte del url pegar la dirección de WebApplicationWS 
(La que conseguimos en el test), podemos recuperar ese webservice.
Puedo checar todo esto en la interfaz
Para llamarlo en el jsp hago clic derecho en un espacio vacio y escogo la opción 
de web service resources, después, abro lo que esta disponible hasta encontrar
la suma y hacerle clic. Lo pruebo cambiando los valores de a y b 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
    <%-- start web service invocation --%><hr/>
    <%
    try {
	webserviceclient.MyWebService_Service service = new webserviceclient.MyWebService_Service();
	webserviceclient.MyWebService port = service.getMyWebServicePort();
	 // TODO initialize WS operation arguments here
	int a = 3;
	int b = 2;
	// TODO process result here
	int result = port.suma(a, b);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    
    
    
    </body>
</html>
