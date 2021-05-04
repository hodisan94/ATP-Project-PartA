package Client;

import java.net.InetAddress;
import java.net.Socket;

public class Client {

    private InetAddress setverIP;
    private int serverPort;
    private IClientStrategy strategy;

    public Client(InetAddress setverIP, int serverPort, IClientStrategy strategy) {
        this.setverIP = setverIP;
        this.serverPort = serverPort;
        this.strategy = strategy;
    }

    public void communicateWithServer(){
        try{
            Socket serverSocket = new Socket(setverIP,serverPort);
            System.out.println("Connected to server - IP + " + setverIP + ", Port = " + serverPort);
            strategy.clientStrategy(serverSocket.getInputStream(),serverSocket.getOutputStream());
            serverSocket.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
