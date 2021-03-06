package Client;

import java.net.InetAddress;
import java.net.Socket;

public class Client {

    private InetAddress serverIP;
    private int serverPort;
    private IClientStrategy strategy;

    public Client(InetAddress serverIP, int serverPort, IClientStrategy strategy) { // same as we saw in the tirgol
        this.serverIP = serverIP;
        this.serverPort = serverPort;
        this.strategy = strategy;
    }

    public void communicateWithServer(){
        try{
            Socket serverSocket = new Socket(serverIP,serverPort);
            strategy.clientStrategy(serverSocket.getInputStream(),serverSocket.getOutputStream());
            serverSocket.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
