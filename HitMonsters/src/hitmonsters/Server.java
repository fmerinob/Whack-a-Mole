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
                try {
                    out.writeUTF("hola");
                    boolean punto = in.readBoolean();
                    if (punto){
                        puntaje++;
                        System.out.println("El puntaje de: "+ Thread.currentThread().getName() + " es de : " + puntaje);
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