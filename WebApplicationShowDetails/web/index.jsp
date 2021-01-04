<%-- 
    Document   : index
    Created on : 6/05/2020, 06:45:59 PM
    Author     : Polupero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body onload = "loadOnStart('divNombres', 'Nombres')">
        <script>
            //El nombres que le pase al loadOnStarte es el nombre del servlet.
            function loadOnStart(id, target) {//Yo le puse el nombre, no es reservado.
                var ajaxRequest;
                if (window.XMLHttpRequest){
                    ajaxRequest=new XMLHttpRequest();
                } else {
                    ajaxRequest=new ActiveXObject("Microsoft.XMLHTTP");
                }
                ajaxRequest.onreadystatechange = function(){
                    if (ajaxRequest.readyState==4 && ajaxRequest.status==200){
                        var JSONObject = JSON.parse(ajaxRequest.responseText);
                        var txt = "<select name='clientes' onchange='getDetails(this.value)'><option>Select a customer</option>";
                        for(var i = 0; i<JSONObject.nombres.length; i++){
                            txt = txt + "<option>" + JSONObject.nombres[i].nombre + "</option>";
                        }
                        document.getElementById(id).innerHTML=txt;
                    }
                }
                ajaxRequest.open("GET", target, true /*async*/);
                ajaxRequest.send();
            }
            
            function getDetails(param) {
                var ajaxRequest;
                if (window.XMLHttpRequest){
                    ajaxRequest=new XMLHttpRequest();
                } else {
                    ajaxRequest=new ActiveXObject("Microsoft.XMLHTTP");
                }
                ajaxRequest.onreadystatechange = function(){
                    if (ajaxRequest.readyState==4 && ajaxRequest.status==200){
                        var JSONObject = JSON.parse(ajaxRequest.responseText);
                        var txt = "ID: " + JSONObject.id+ " Nombre: "+ JSONObject.nombre+ " Balance: "+ JSONObject.balance+ "<br />";
                        document.getElementById("divDetalles").innerHTML=txt;
                    }
                }
                ajaxRequest.open("GET", "Datos?parametro="+param, true /*async*/); //El nombreServlet?nombreParametro=valorParametro
                ajaxRequest.send();
            }
        </script>
        <div id = divNombres></div>
        <div id = divDetalles>No details</div>
    </body>
</html>
