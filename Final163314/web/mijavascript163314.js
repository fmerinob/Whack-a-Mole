/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function Agrega(Identificador, Cliente, Domicilio, Saldo) {
    var ajaxRequest;
    if (window.XMLHttpRequest) {
        ajaxRequest = new XMLHttpRequest();
    } else {
        ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
    }
    ajaxRequest.onreadystatechange = function () {
        if (ajaxRequest.readyState == 4 && ajaxRequest.status == 200) {
            //document.getElementById("confirmacion").innerHTML = "Se publicó con éxito tu mensaje";
        }
    }
    ajaxRequest.open("GET", "ServletAgregar163314?Identificador163314=" + Identificador + "&Cliente163314=" + Cliente + "&Domicilio163314=" + Domicilio + "&Saldo163314=" + Saldo, true /*async*/);
    ajaxRequest.send();
}

function Borra(Identificador) {
    var ajaxRequest;
    if (window.XMLHttpRequest) {
        ajaxRequest = new XMLHttpRequest();
    } else {
        ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
    }
    ajaxRequest.onreadystatechange = function () {
        if (ajaxRequest.readyState == 4 && ajaxRequest.status == 200) {
            //document.getElementById("confirmacion").innerHTML = "Se publicó con éxito tu mensaje";
        }
    }
    ajaxRequest.open("GET", "ServletBorrar163314?Identificador163314=" + Identificador, true /*async*/);
    ajaxRequest.send();
}

function Actualiza(Identificador, Cliente, Domicilio, Saldo) {
    var ajaxRequest;
    if (window.XMLHttpRequest) {
        ajaxRequest = new XMLHttpRequest();
    } else {
        ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
    }
    ajaxRequest.onreadystatechange = function () {
        if (ajaxRequest.readyState == 4 && ajaxRequest.status == 200) {
            //document.getElementById("confirmacion").innerHTML = "Se publicó con éxito tu mensaje";
        }
    }
    ajaxRequest.open("GET", "ServletActualizar163314?Identificador163314=" + Identificador + "&Cliente163314=" + Cliente + "&Domicilio163314=" + Domicilio + "&Saldo163314=" + Saldo, true /*async*/);
    ajaxRequest.send();
}