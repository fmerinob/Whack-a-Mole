/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationrestfulclient;

import webservicesclients.RestfulClient;

/**
 *
 * @author Polupero
 */
public class JavaApplicationRestfulClient {

    /**
     * @param args the command line arguments
     */
    // Esto sale de lo que esta comentado de manera automática entre los pre en 
    //el java, y se modifica un poco para que funcione
    public static void main(String[] args) {
        RestfulClient client = new RestfulClient();
        String response = client.getHtml();
        System.out.println("Respuesta del get: " + response);
        client.putHtml("Jose");
        client.close();
    }
}
