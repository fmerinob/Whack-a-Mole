package hitmonsters;

class ClientThread extends Thread {
    public ClientThread () {
    }
    public void run(){
        TCPClient cliente = new TCPClient();
    }
} 