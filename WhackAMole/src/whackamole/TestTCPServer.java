package whackamole;

import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;

public class TestTCPServer {

    public static void main(String args[]) {
        try {
            int sPort = 7897;
            ServerSocket eSocket = new ServerSocket(sPort);
            MulticastGameServer2 MGS2 = new MulticastGameServer2();
            MGS2.start();
            while (true) {
                Socket cSocket = eSocket.accept();
                Conn conn = new Conn(cSocket);
                conn.start();
            }
        } catch (IOException e) {
            System.out.println("Listen :" + e.getMessage());
        }
    }
}

class Conn extends Thread {

    DataInputStream in;
    DataOutputStream out;
    Socket cSocket;
    Random rng = new Random();
    boolean end = true;
    int score = 0, prevScore = 0;
    double tStart, tResponse, time;

    public Conn(Socket acs) {
        try {
            cSocket = acs;
            in = new DataInputStream(cSocket.getInputStream());
            out = new DataOutputStream(cSocket.getOutputStream());
        } catch (IOException e) {
            System.out.println("Connection:" + e.getMessage());
        }
    }

    @Override
    public void run() {
        while (end) {
            try {
                prevScore = score;
                tStart = System.currentTimeMillis();
                out.writeUTF("");
                int hits = in.readInt();
                score = hits;
                if(prevScore != score){
                tResponse = System.currentTimeMillis(); 
                time = tResponse - tStart;
                System.out.println(time);
                tStart = System.currentTimeMillis();
                tResponse = 0.0;
                }
                if (score >= 10) {
                    MulticastGameServer2.setStatus(1);
                    MulticastGameServer2.setWinner(Thread.currentThread().getName());
                }
            } catch (EOFException e) {
                System.out.println("EOF:" + e.getMessage());
            } catch (IOException e) {
                System.out.println("IO:" + e.getMessage());
            }
        }
        try {
            out.writeUTF("End");
        } catch (IOException ex) {
            Logger.getLogger(Conn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class MulticastGameServer2 extends Thread {

    static int status = 0;
    static String winner = "";

    public static String getWinner() {
        return winner;
    }

    public static void setWinner(String ganador) {
        MulticastGameServer2.winner = ganador;
    }

    public static void setStatus(int status) {
        MulticastGameServer2.status = status;
    }

    public static int getStatus() {
        return status;
    }

    public void run() {
        MulticastSocket s = null;
        try {
            InetAddress group = InetAddress.getByName("228.5.8.7");
            s = new MulticastSocket(7897);
            s.joinGroup(group);
            while (true) {
                if (status == 0) {
                    Random rng = new Random();
                    int moles = rng.nextInt(5), hit, i = 0;
                    String hits = "";
                    while (i < moles && hits.length() < 9) {
                        hit = rng.nextInt(2);
                        if (hit == 1) {
                            i++;
                        }
                        hits += hit;
                    }
                    while (hits.length() < 9) {
                        hits += 0;
                    }
                    byte[] uMessage = hits.getBytes();
                    DatagramPacket out = new DatagramPacket(uMessage, uMessage.length, group, 7897);
                    s.send(out);
                    Thread.sleep(1000);
                } else {
                    String victor = getWinner();
                    String victory = "The winner is: " + victor;
                    System.out.println("fin"); //Esto solo es para la prueba de tiempo
                    byte[] m = victory.getBytes();
                    DatagramPacket out = new DatagramPacket(m, m.length, group, 7897);
                    s.send(out);
                    setStatus(0);
                    Thread.sleep(10000);
                }
            }
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } catch (InterruptedException ex) {
            Logger.getLogger(MulticastGameServer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (s != null) {
                s.close();
            }
        }

    }
}
