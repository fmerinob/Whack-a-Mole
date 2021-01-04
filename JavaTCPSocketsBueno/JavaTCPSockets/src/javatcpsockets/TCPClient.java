/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javatcpsockets;

import java.net.*;
import java.io.*;

public class TCPClient {

    public static void main (String args[]) {

	Socket s = null;
	    try {
	    	int serverPort = 7896;
                s = new Socket("localhost", serverPort);    
             //   s = new Socket("127.0.0.1", serverPort);    
		DataInputStream in = new DataInputStream( s.getInputStream());
		DataOutputStream out = new DataOutputStream( s.getOutputStream());
//		out.writeUTF("Hello");        	// UTF is a string encoding
                //int valorDado = Math.floor(Math.random()*6);
                double tiempoTotalCliente = 0;
                int numeroMensajes = 200;
                for (int i = 0; i < numeroMensajes; i++) {//Manda 10 preguntas
                    int valorDado;
                    if(i == (numeroMensajes - 1)){
                        valorDado = 5;
                    }
                    else{
                        valorDado = (int)Math.floor(Math.random()*5);
                    }
                    double startTime = System.currentTimeMillis();
                    out.writeInt(valorDado);
                    String data = in.readUTF();
                    double spentTime = System.currentTimeMillis() - startTime;
                    tiempoTotalCliente = tiempoTotalCliente + spentTime;
                    //System.out.println("El nombre es: " + data) ;
                }
                double promedioCliente = tiempoTotalCliente / numeroMensajes;
                System.out.println(promedioCliente);
       	    } 
            catch (UnknownHostException e) {
		System.out.println("Sock:"+e.getMessage()); 
	    }
            catch (EOFException e) {
                System.out.println("EOF:"+e.getMessage());
    	    } 
            catch (IOException e) {
                System.out.println("IO:"+e.getMessage());
            } finally {
                if(s!=null) 
                    try {
                        s.close();
                    } catch (IOException e){
                    System.out.println("close:"+e.getMessage());}
                    }
            }
}
