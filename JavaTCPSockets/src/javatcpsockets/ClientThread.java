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
class ClientThread extends Thread {
    public ClientThread () {
    }
    public void run(){
        TCPClient cliente = new TCPClient();
        cliente.main(null); //Para llamar a un main, aunque no lleve nada, debo 
        //de poner el null 
    }
} 
