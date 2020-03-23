package whackamole;

class TCPClientInstancing extends Thread {
    public TCPClientInstancing () {
    }
    public void run(){
        TestTCPClient cliente = new TestTCPClient();
    }
} 