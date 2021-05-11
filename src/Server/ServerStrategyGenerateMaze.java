package Server;

import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.*;

import IO.MyCompressorOutputStream;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.mazeGenerators.AMazeGenerator;
import algorithms.mazeGenerators.Maze;



public class ServerStrategyGenerateMaze implements IServerStrategy{



    @Override
    public void ServerStrategy(InputStream inFromClient, OutputStream outToClient) {

        try {

            ObjectOutputStream toClient = new ObjectOutputStream(outToClient);
            ObjectInputStream fromClient = new ObjectInputStream(inFromClient);

            OutputStream out = new ByteArrayOutputStream();
            MyCompressorOutputStream myCompressorOutputStream = new MyCompressorOutputStream(out);

            int[] arrayForMaze = (int[])fromClient.readObject();
            int rows = arrayForMaze[0];
            int cols = arrayForMaze[1];
            AMazeGenerator aMazeGenerator = Configurations.getMazeGeneratingAlgorithm();  // hmm??
            Maze clinetMaze = aMazeGenerator.generate(rows,cols);

            byte[] byteMaze = clinetMaze.toByteArray();

            myCompressorOutputStream.write(clinetMaze.toByteArray());
            toClient.writeObject(((ByteArrayOutputStream)myCompressorOutputStream.out).toByteArray());
            toClient.flush();



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
