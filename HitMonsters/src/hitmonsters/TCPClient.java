package hitmonsters;

import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TCPClient extends Thread {

    private int puntuacionLocal = 0;
    private int[] tablero = new int[9];
    private Random r = new Random();
    private Socket s2;

    @Override
    public void run() {
        MulticastSocket s = null;
        int intento;
        int serverPort = 7897;
        try {
            s2 = new Socket("localhost", serverPort);
            InetAddress group = InetAddress.getByName("228.5.8.7");
            s = new MulticastSocket(6889);
            s.joinGroup(group);
            while (true) {
                System.out.println("Waiting for messages");
                byte[] buffer = new byte[1000];
                DatagramPacket messageIn = new DatagramPacket(buffer, buffer.length);
                s.receive(messageIn);
                String posiciones = new String(messageIn.getData());
                if (posiciones.substring(0, 28).equals("El juego se acabó, lo ganó: ")) {
                    String mensajeLabel = (posiciones + "\n" + " Empezando un nuevo juego en 10 segundos");
                    System.out.println(mensajeLabel);
                    puntuacionLocal = 0;
                    Thread.sleep(10000);
                    puntuacionLocal = 0;
                } else {
                    System.out.println(posiciones);
                    for (int i = 0; i < 9; i++) {
                        tablero[i] = Integer.parseInt(String.valueOf(posiciones.charAt(i)));
                        System.out.print(tablero[i]);
                    }
                    System.out.println("");
                    intento = r.nextInt(9); //Va a simular el intento de darle a un topo;

                    if (tablero[intento] == 1) {//Si le atina va a mandar el mensaje TCP
                        DataInputStream in = new DataInputStream(s2.getInputStream());
                        DataOutputStream out = new DataOutputStream(s2.getOutputStream());
                        String puntuacion = in.readUTF();
                        if (puntuacion.equals("Fin")) {
                            s.close();
                        } else {
                            puntuacionLocal++;
                            out.writeInt(puntuacionLocal);
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
            Logger.getLogger(InterfazGrafica.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
}