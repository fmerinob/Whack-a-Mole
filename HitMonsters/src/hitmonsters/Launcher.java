package hitmonsters;

public class Launcher {
    public static void main (String args[]) {
        for (int i = 0; i < 250; i++) {
            ClientThread clientThread = new ClientThread();
            clientThread.start();            
        }
    }
} 
