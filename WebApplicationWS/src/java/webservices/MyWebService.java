/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
/**
 *
 * @author Polupero
 */
@WebService(serviceName = "MyWebService")
public class MyWebService { //Para agregar operaciones, lo hago desde design, 
    //no modificar nada de lo autogenerado aquí, todo desde alla.
    //Hasta que no le de deploy, no lo puedo usar, se usa abriendo la carpeta de
    //webservice y dandole clic derecho al MyWebService y escogiendo test.
    //Esto es el link de apretar wcdl en el test

    /**
     * Web service operation
     */
    @WebMethod(operationName = "suma")
    public int suma(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
        //TODO write your implementation code here:
        return a+b;
    }


}
