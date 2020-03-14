/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hitmonsters;

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
                
                //String posiciones =in.readUTF();
                //System.out.println();
                boolean flag = true;
                while (flag) {
                    String posiciones = in.readUTF();
                    if(posiciones.equals("Fin")){
                        flag = false;
                    }
                    else{
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

                    //out.writeBoolean(true);
            }
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
