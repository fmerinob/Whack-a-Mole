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
                MulticastServer2 multicast = new MulticastServer2();
                multicast.start();
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
        Random r = new Random();
        boolean flag = true;
        int puntaje = 0;
        
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
            while(flag){
                try {
                    out.writeUTF("hola");//Nomas por mandar algo que reciba el cliente, es para implementar facil el Fin.
                    int punto = in.readInt();
                    puntaje = punto;
                        System.out.println("El puntaje de: "+ Thread.currentThread().getName() + " es de : " + puntaje); //Se que suena absurdo tener un if para algo que se hace en ambas partes, pero no funciona si no, no tocar.
                    if(puntaje == 10){
                        flag=!flag;
                        MulticastServer2.setStatus(1);
                        MulticastServer2.setGanador(Thread.currentThread().getName());
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

class MulticastServer2 extends Thread{
    static int status = 0;
    static String ganador = "";

    public static String getGanador() {
        return ganador;
    }

    public static void setGanador(String ganador) {
        MulticastServer2.ganador = ganador;
    }

    public static void setStatus(int status) {
        MulticastServer2.status = status;
    }

    public static int getStatus() {
        return status;
    }
    	public void run(){ 
	MulticastSocket s =null;
   	 try {
                InetAddress group = InetAddress.getByName("228.5.8.7");
	    	s = new MulticastSocket(6889);
	   	s.joinGroup(group); 
                while(true){
                    if(status == 0){
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
                    else{
                        String victorioso = getGanador();
                        String victoria="El juego se acabó, lo ganó: " + victorioso;
                        byte [] m = victoria.getBytes();
                        DatagramPacket messageOut = new DatagramPacket(m, m.length, group, 6889);
                        s.send(messageOut);
                        setStatus(0);
                        Thread.sleep(10000);
                    }
                }		
 	    }
         catch (SocketException e){
             System.out.println("Socket: " + e.getMessage());
	 }
         catch (IOException e){
             System.out.println("IO: " + e.getMessage());
         }      catch (InterruptedException ex) {
                    Logger.getLogger(MulticastServer2.class.getName()).log(Level.SEVERE, null, ex);
                }
	 finally {
            if(s != null) s.close();
        }
    }		     
}