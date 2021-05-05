package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private int port;
    private int listeningIntervalMS;
    private IServerStrategy strategy;
    private volatile boolean stop;
    private ExecutorService threadPool;



    public Server(int port, int listeningIntervalMS, IServerStrategy strategy) {
        this.port = port;
        this.listeningIntervalMS = listeningIntervalMS;
        this.strategy = strategy;
        this.threadPool = Executors.newFixedThreadPool(2); // just for now before part C
    }


    public void run(){
        ServerSocket serverSocket =null;
        try{

            serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(listeningIntervalMS);

            while(!stop){
                try{
                    Socket clientSocket = serverSocket.accept();

                    threadPool.execute(()->{
                        handleClient(clientSocket);
                    });

                }
                catch (SocketTimeoutException e ){
                    e.printStackTrace();
                }

            }
            serverSocket.close();
            threadPool.shutdown();

        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void start(){
        new Thread(()->{
            run();
        }).start();
    }


    public void stop(){
        this.stop = true;
    }



    private void handleClient(Socket clientSocket){
        try {
            strategy.serverStrategy(clientSocket.getInputStream(),clientSocket.getOutputStream());
            clientSocket.getInputStream().close();
            clientSocket.getOutputStream().close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}