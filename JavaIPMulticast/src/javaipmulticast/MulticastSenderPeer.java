/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaipmulticast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.Date;

/**
 *
 * @author JGUTIERRGARC
 */
public class MulticastSenderPeer {
    	public static void main(String args[]){ 
  	 
	MulticastSocket s =null;
   	 try {
                
                InetAddress group = InetAddress.getByName("228.5.8.7"); // destination multicast group 
	    	s = new MulticastSocket(6889);
	   	s.joinGroup(group); 
                //s.setTimeToLive(10);
//                System.out.println("Messages' TTL (Time-To-Live): "+ s.getTimeToLive());
//                String myMessage="Hello";
//                byte [] m = myMessage.getBytes();
//	    	DatagramPacket messageOut = new DatagramPacket(m, m.length, group, 6889);
//	    	s.send(messageOut);
                while(true){
                    String myMessage = (new Date()).toString();
                    byte [] m = myMessage.getBytes();
                    DatagramPacket messageOut = new DatagramPacket(m, m.length, group, 6889);
                    s.send(messageOut);
                }		
 	    }
         catch (SocketException e){
             System.out.println("Socket: " + e.getMessage());
	 }
         catch (IOException e){
             System.out.println("IO: " + e.getMessage());
         }
	 finally {
            if(s != null) s.close();
        }
    }		     
}
