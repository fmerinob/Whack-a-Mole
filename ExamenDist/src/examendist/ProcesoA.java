/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examendist;

import java.net.*;
import java.io.*;

public class ProcesoA{
    
    public static void main(String args[]){ 
	DatagramSocket aSocket = null;
	  try {
		aSocket = new DatagramSocket();    
		String myMessage = "m";
                byte [] m = myMessage.getBytes();
		
                InetAddress aHost = InetAddress.getByName("localhost");
		int serverPort = 6789;
    		DatagramPacket request = new DatagramPacket(m, m.length, aHost, serverPort);
    		aSocket.send(request);			                        
	  }
          catch (SocketException e){
                System.out.println("Socket: " + e.getMessage());
	  }
          catch (IOException e){
              System.out.println("IO: " + e.getMessage());
          }
	  finally{
            if(aSocket != null) 
                aSocket.close();
         }
   }
}