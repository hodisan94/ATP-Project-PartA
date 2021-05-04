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
    public void serverStrategy(InputStream inFromClient, OutputStream outToClient) {

        try {

            ObjectOutputStream toClient = new ObjectOutputStream(outToClient);
            ObjectInputStream fromClient = new ObjectInputStream(inFromClient);

            int[] arrayForMaze = (int[])fromClient.readObject();
            int rows = arrayForMaze[0];
            int cols = arrayForMaze[1];
            AMazeGenerator aMazeGenerator = new MyMazeGenerator();  // hmm??
            Maze clinetMaze = aMazeGenerator.generate(rows,cols);

            byte[] byteMaze = clinetMaze.toByteArray();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            MyCompressorOutputStream myCompressorOutputStream = new MyCompressorOutputStream(byteArrayOutputStream);

            myCompressorOutputStream.write(byteMaze);
            toClient.writeObject(byteArrayOutputStream.toByteArray());
            toClient.flush();



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
