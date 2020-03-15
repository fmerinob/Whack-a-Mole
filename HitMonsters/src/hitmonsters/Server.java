package hitmonsters;

import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    
    public static void main (String args[]) {
	try{
		int serverPort = 7897; 
		ServerSocket listenSocket = new ServerSocket(serverPort);
		while(true) {
			System.out.println("Enviando Posiciones"); 
                        Socket clientSocket = listenSocket.accept();
			Connection2 c = new Connection2(clientSocket);
                        c.start();
		}
	} 
        catch(IOException e) {System.out.println("Listen :"+ e.getMessage());}
    }
}

class Connection2 extends Thread {
	DataInputStream in;
	DataOutputStream out;
	Socket clientSocket;
        Random r= new Random();
	public Connection2 (Socket aClientSocket) {
	    try {
		clientSocket = aClientSocket;
		in = new DataInputStream(clientSocket.getInputStream());
		out =new DataOutputStream(clientSocket.getOutputStream());
	     } 
            catch(IOException e)  {System.out.println("Connection:"+e.getMessage());}
	}
        
        @Override
	public void run(){
            boolean flag=true;
            int puntaje=0;
            while(flag){
                int totMoles = r.nextInt(4), val;
                try {
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
                out.writeUTF(pos);
                boolean punto = in.readBoolean();
                
                if (punto){
                    puntaje++;
                    System.out.println(puntaje);
                }
                if(puntaje == 10){
                    flag=!flag;
                }
                }
            catch(EOFException e) {
                System.out.println("EOF:"+e.getMessage());
	    } 
            catch(IOException e) {
                System.out.println("IO:"+e.getMessage());
	    }
        }
        try {
            out.writeUTF("Fin");
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}