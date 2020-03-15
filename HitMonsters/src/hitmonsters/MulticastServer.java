package hitmonsters;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.Random;


public class MulticastServer extends Thread{
    	public static void main(String args[]) throws InterruptedException{ 
  	 
	MulticastSocket s =null;
   	 try {
                
                InetAddress group = InetAddress.getByName("228.5.8.7"); // destination multicast group 
	    	s = new MulticastSocket(6889);
	   	s.joinGroup(group); 
                while(true){
                    System.out.println("Enviando tableros");
                    Random r= new Random();
                    int totMoles = r.nextInt(4), val;
                    String pos="";
                    int i = 0,j = 0;
                        while (j<r.nextInt(3)){
                            pos+=0;
                            j++;
                        }
                        while (i < totMoles && pos.length()<9) {
                            val=r.nextInt(2);
                            if(val==1){
                                i++;
                            }
                            pos+=val;
                        }
                        while (pos.length()<9){
                            pos+=0;
                        }
                    byte [] m = pos.getBytes();
                    DatagramPacket messageOut = new DatagramPacket(m, m.length, group, 6889);
                    s.send(messageOut);
                    Thread.sleep(1000);
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
