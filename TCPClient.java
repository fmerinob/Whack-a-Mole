/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javatcpsockets;

import java.net.*;
import java.io.*;
import java.util.*;

public class TCPClient {

    public static void main (String args[]) {

	Socket s = null;
	    try {
	    	int serverPort = 7896, posAt;
                s = new Socket("localhost", serverPort);
                Random r = new Random();    
		DataInputStream in = new DataInputStream( s.getInputStream());
		DataOutputStream out = new DataOutputStream( s.getOutputStream());
                
                String posiciones =in.readUTF();
                System.out.println();
                int i= 1;
                for (Character pos :posiciones.toCharArray()) {
                    System.out.print(pos+ " ");
                }
                System.out.println("");
                posAt=r.nextInt(9);
                System.out.println(posAt);
                if(posiciones.charAt(posAt)=='1'){
                    System.out.println("Le atiné");
                    
                }
                out.writeBoolean(posiciones.charAt(posAt)=='1');
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
