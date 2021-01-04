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


/**
 *
 * @author JGUTIERRGARC
 */
public class MulticastReceivingPeer {
    	public static void main(String args[]){ 
  	 
	MulticastSocket s =null;
   	 try {
                InetAddress group = InetAddress.getByName("228.5.8.7"); // destination multicast group 
	    	s = new MulticastSocket(6889);
	   	s.joinGroup(group); 
                System.out.println("Waiting for messages");
//	    	byte[] buffer = new byte[1000];
// 	   	for(int i=0; i< 3; i++) {
//                  System.out.println("Waiting for messages");
//                  DatagramPacket messageIn = new DatagramPacket(buffer, buffer.length);
// 		    s.receive(messageIn);
// 		    System.out.println("Message: " + new String(messageIn.getData())+ " from: "+ messageIn.getAddress());
//  	     	}
//	    	s.leaveGroup(group);		

                byte[] buffer = new byte[1000];
                DatagramPacket messageIn = new DatagramPacket(buffer, buffer.length);
 		s.receive(messageIn); //El receive es bloqueante
 		System.out.println(new String(messageIn.getData()));
	    	s.leaveGroup(group);
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
                 // get messages from others in group
}
