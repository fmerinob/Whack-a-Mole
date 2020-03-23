package whackamole;

import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameServer {

    private int session;
    private Hashtable<String, Integer> htScore = new Hashtable<String, Integer>();

    public GameServer(String sesion) {
        this.session = Integer.parseInt(sesion);
    }

    public void main() {
        try {
            int sPort = session;
            ServerSocket eSocket = new ServerSocket(sPort);
            MulticastGameServer MGS = new MulticastGameServer(session);
            MGS.start();
            while (true) {
                Socket cSocket = eSocket.accept();
                Conn2 conn = new Conn2(cSocket, htScore);
                conn.start();
                htScore=conn.update();
            }
        } catch (IOException e) {
            System.out.println("Listen :" + e.getMessage());
        }
        
    }
}

class Conn2 extends Thread {

    DataInputStream in;
    DataOutputStream out;
    Socket cSocket;
    Random rng = new Random();
    boolean end = true;
    int score = 0;
    String player;
    Hashtable<String, Integer> htScore;

    public Conn2(Socket acs, Hashtable<String, Integer> hts) {
        try {
            cSocket = acs;
            in = new DataInputStream(cSocket.getInputStream());
            out = new DataOutputStream(cSocket.getOutputStream());
            htScore = hts;
        } catch (IOException e) {
            System.out.println("Connection:" + e.getMessage());
        }
    }

    public Hashtable<String, Integer> update() {
        return htScore;
    }

    @Override
    public void run() {
        while (end) {
            try {
                int points = 0;
                player = in.readUTF();
                System.out.println(player);
                if (htScore.containsKey(player)) {
                    points = htScore.get(player);
                } else {
                    htScore.put(player, points);
                }
                out.writeUTF(String.valueOf(points));
                int hit = in.readInt();
                score = hit;
                htScore.replace(player, score);
                System.out.println("Score of " + player + " is: " + score);
                out.writeUTF(Thread.currentThread().getName());
                if (score == 10) {
                    MulticastGameServer.setStatus(1);
                    MulticastGameServer.setWinner(player);
                    for (String key : htScore.keySet()) {
                        htScore.replace(key, 0);
                    }
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

class MulticastGameServer extends Thread {

    static int status = 0;
    static String winner = "";
    private int session;

    public MulticastGameServer(int sesion) {
        this.session = sesion;
    }

    public static String getWinner() {
        return winner;
    }

    public static void setWinner(String ganador) {
        MulticastGameServer.winner = ganador;
    }

    public static void setStatus(int status) {
        MulticastGameServer.status = status;
    }

    public static int getStatus() {
        return status;
    }

    public void run() {
        MulticastSocket gameSocket = null;
        try {
            InetAddress group = InetAddress.getByName("228.5.8.7");
            gameSocket = new MulticastSocket(session);
            gameSocket.joinGroup(group);
            while (true) {
                if (status == 0) {
                    System.out.println("Sending game state");
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
                    DatagramPacket out = new DatagramPacket(uMessage, uMessage.length, group, session);
                    gameSocket.send(out);
                    Thread.sleep(1000);
                } else {
                    String victor = getWinner();
                    String victory = "The winner is: " + victor;
                    byte[] vMessage = victory.getBytes();
                    DatagramPacket out = new DatagramPacket(vMessage, vMessage.length, group, session);
                    gameSocket.send(out);
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
            if (gameSocket != null) {
                gameSocket.close();
            }
        }
    }
}
