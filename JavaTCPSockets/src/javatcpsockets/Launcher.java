/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatcpsockets;

/**
 *
 * @author Polupero
 */
public class Launcher {
    public static void main (String args[]) {
        for (int i = 0; i < 250; i++) {//Cambia la cantidad de errores 
//dependiendo de cuando lo ejecutas. Si es la primera vez que abre el servidor 
//le va mejor qu si es la segunda o tercera. Preguntar sobre eso. (Aún así 
//puede  hacer bien cantidades pequeñas).
            ClientThread clientThread = new ClientThread();
            clientThread.start();            
        }
    }
} 
