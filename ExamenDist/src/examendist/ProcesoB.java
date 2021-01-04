
// "contenido", localhost


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examendist;

import java.net.*;
import java.io.*;

public class ProcesoB{
	
        public static void main(String args[]){ 
	DatagramSocket aSocket = null;
        String mensajeUDP;
	   try{
	    	int serverPort = 6789;
                aSocket = new DatagramSocket(serverPort); 
		byte[] buffer = new byte[1000]; // buffer encapsulará mensajes
 		while(true){
                   System.out.println("Waiting for messages..."); 
		DatagramPacket reply = new DatagramPacket(buffer, buffer.length);	
                aSocket.receive(reply);
                mensajeUDP = (new String(reply.getData())).trim();
		System.out.println("Reply: " + (new String(reply.getData())).trim()  );
                //System.out.println(mensajeUDP);
                
                
                
                
                
                
	Socket s = null;
	    try {
	    	int serverPort2 = 7896;
                s = new Socket("localhost", serverPort2);       
		DataOutputStream out = new DataOutputStream( s.getOutputStream());
		out.writeUTF(mensajeUDP);
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
           catch (SocketException e){
                System.out.println("Socket: " + e.getMessage());
	   }
           catch (IOException e) {
               System.out.println("IO: " + e.getMessage());
           }
           finally {
                if(aSocket != null)
                    aSocket.close();
           }
    }
}
