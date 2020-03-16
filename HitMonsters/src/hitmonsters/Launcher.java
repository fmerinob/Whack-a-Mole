package hitmonsters;

public class Launcher {
    public static void main (String args[]) {
        for (int i = 0; i < 100; i++) {
            TCPClient clientThread = new TCPClient();
            clientThread.start();            
        }
    }
} 
