/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcalculatorclient;

import webservices.ComplexNumber;

/**
 *
 * @author Polupero
 */
public class WebCalculatorClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ComplexNumber a = new ComplexNumber();
        ComplexNumber b = new ComplexNumber();
        a.setI(1);
        b.setI(2);
        a.setJ(3);
        b.setJ(4);
        ComplexNumber c = add(a,b);
        System.out.println(c.getI() + " " + c.getJ());
        //System.out.println(add(a,b));//No puedo hacer un método .toString en la
        //clase porque solo puedo usar las automaticamente generadas
    }
//Esto lo agregue haciendo clic derecho, insert code y escogiendo call web service operation
    private static ComplexNumber add(webservices.ComplexNumber a, webservices.ComplexNumber b) {
        webservices.Calculator_Service service = new webservices.Calculator_Service();
        webservices.Calculator port = service.getCalculatorPort();
        return port.add(a, b);
    }
    
    
    
}
