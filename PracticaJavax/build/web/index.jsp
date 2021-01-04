<%-- 
    Document   : index
    Created on : 4/05/2020, 06:36:37 PM
    Author     : polupero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function hints(id,input){
                var ajaxRequest;
                if (window.XMLHttpRequest){
                    ajaxRequest = new XMLHttpRequest();
                }else{
                    ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
                }
                ajaxRequest.onreadystatechange = function(){
                    if(ajaxRequest.readyState==4 && ajaxRequest.status==200){
                        document.getElementById(id).innerHTML=ajaxRequest.responseText;
                    }
                }
                ajaxRequest.open("GET","Estados?input="+input,true);
                ajaxRequest.send();
            }
        </script>
    </head>
    <body>
        Indica un estado para conocer su capital:
        <input type="text" name="estado" value=""  onkeyup="hints('sugerencias',this.value);"/>
        
        <h1>Sugerencia:</h1> 
        <span id = "sugerencias"></span>
        
        
    </body>
</html>
