package whackamole;

public class TestLauncher {
    public static void main (String args[]) {
        for (int i = 0; i < 250; i++) {
            TestTCPClient TCPClientInstancing = new TestTCPClient();
            TCPClientInstancing.start();            
        }
    }
} 