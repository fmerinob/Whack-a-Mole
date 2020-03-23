package whackamole;

import java.net.*;
import java.io.*;
import java.util.logging.*;

public class TestTCPClient extends Thread {

    private int localScore = 0;
    private int[] gameBoard = new int[9];
    private Socket s2;

    @Override
    public void run() {
        MulticastSocket s = null;
        int attempt;
        int sPort = 7897;
        try {
            s2 = new Socket("localhost", sPort);
            InetAddress group = InetAddress.getByName("228.5.8.7");
            s = new MulticastSocket(7897);
            s.joinGroup(group);
            while (true) {
                byte[] b = new byte[1000];
                DatagramPacket in = new DatagramPacket(b, b.length);
                s.receive(in);
                String endGame = new String(in.getData());
                if (endGame.substring(0, 15).equals("The winner is: ")) {
                    String LMessage = (endGame + "\n" + " Restarting in 10 seconds");
                    localScore = 0;
                    Thread.sleep(10000);
                    localScore = 0;
                } else {
                    for (int i = 0; i < 9; i++) {
                        gameBoard[i] = Integer.parseInt(String.valueOf(endGame.charAt(i)));
                    }
                    attempt = 1;

                    if (gameBoard[attempt] == 1) {
                        DataInputStream tin = new DataInputStream(s2.getInputStream());
                        DataOutputStream out = new DataOutputStream(s2.getOutputStream());
                        String score = tin.readUTF();
                        if (score.equals("End")) {
                            s.close();
                        } else {
                            localScore++;
                            out.writeInt(localScore);
                        }
                    }
                }
            }
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (UnknownHostException e) {
            System.out.println("Sock:" + e.getMessage());
        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } catch (InterruptedException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
}