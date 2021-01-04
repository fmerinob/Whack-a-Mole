/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JGUTIERRGARC
 */

package examendist;

import java.net.*;
import java.io.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import interfaces.ProcesoRMI;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class ProcesoC implements ProcesoRMI{
    static String message;
        public ProcesoC() throws RemoteException
    {
        super();
    }
 
    @Override
    public String print() throws RemoteException {
        return (message);
    }
    
    public static void main (String args[]) {
	try{
		int serverPort = 7896; 
		ServerSocket listenSocket = new ServerSocket(serverPort);
		while(true) {
			System.out.println("Waiting for messages..."); 
                        Socket clientSocket = listenSocket.accept();  // Listens for a connection to be made to this socket and accepts it. The method blocks until a connection is made. 
			Connection c = new Connection(clientSocket);
                        c.start();		}
	} 
        catch(IOException e) {System.out.println("Listen :"+ e.getMessage());}
    }
}

class Connection extends Thread {
	DataInputStream in;
	DataOutputStream out;
	Socket clientSocket;
	public Connection (Socket aClientSocket) {
	    try {
		clientSocket = aClientSocket;
		in = new DataInputStream(clientSocket.getInputStream());
		out =new DataOutputStream(clientSocket.getOutputStream());
	     } 
            catch(IOException e)  {System.out.println("Connection:"+e.getMessage());}
            
            
            
            
            
           
        System.setProperty("java.security.policy","D:\\Universidad\\Sistemas Distribuidos\\ExamenDist\\src\\examendist\\server.policy");

        if (System.getSecurityManager() == null) {
           System.setSecurityManager(new SecurityManager());
        }
        
        try {

            LocateRegistry.createRegistry(1099);
            String name = "ProcesoRMI";
            ProcesoC engine = new ProcesoC();
            ProcesoRMI stub = (ProcesoRMI) UnicastRemoteObject.exportObject(engine, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);
        } catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }
            
            
            
            
            
            
	}
        
        @Override
	public void run(){
            while(true){
                try {
                String Mensaje = in.readUTF();
                    System.out.println(Mensaje);
                    ProcesoC.message = Mensaje;
	    }
            catch(EOFException e) {
                System.out.println("EOF:"+e.getMessage());
                
	    } 
            catch(IOException e) {
                System.out.println("IO:"+e.getMessage());
	    }
        }
    }
}
