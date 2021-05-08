package Server;

import IO.MyCompressorOutputStream;
import IO.MyDecompressorInputStream;
import algorithms.mazeGenerators.Maze;
import algorithms.search.ASearchingAlgorithm;
import algorithms.search.ISearchable;
import algorithms.search.ISearchingAlgorithm;
import algorithms.search.SearchableMaze;
import algorithms.search.Solution;
import algorithms.search.*;


import java.io.*;
import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.HashMap;


public class ServerStrategySolveSearchProblem implements IServerStrategy{


    public ASearchingAlgorithm algo;
    private String tempDirectoryPath;
    private int num = 0;
    //private HashSet<String> map;

    public ServerStrategySolveSearchProblem() {
        this.tempDirectoryPath = System.getProperty("java.io.tmpdir");
        this.algo = Configurations.getMazeSearchingAlgorithm();
    }

    @Override
    public void serverStrategy(InputStream inFromClient, OutputStream outToClient) {

        try {
            ObjectOutputStream toClient = new ObjectOutputStream(outToClient);
            ObjectInputStream fromClient = new ObjectInputStream(inFromClient);

            Maze myMaze = (Maze)fromClient.readObject();

            //String s = ArrayToString(myMaze);

            Solution solve = findOrSave(myMaze);
            toClient.writeObject(solve);
            toClient.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void save_sol(Maze myMaze , Solution sol ){

        String fileName = myMaze.getRows() + ", " + myMaze.getColumns() + ", "+ myMaze.getStartPosition().getRowIndex() +
                ", " + myMaze.getStartPosition().getColumnIndex() + ", " + myMaze.getGoalPosition().getRowIndex() + ", " + myMaze.getGoalPosition().getColumnIndex()+"," + num;

        //File dirFile = new File(tempDirectoryPath);

        File nameFileMaze = new File(tempDirectoryPath + "Maze - " + fileName);
        File nameFileSol = new File(tempDirectoryPath + "Solution - " + fileName);

        try{
            OutputStream out = new MyCompressorOutputStream(new FileOutputStream(nameFileMaze));
            out.write(myMaze.toByteArray());
            out.flush();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        try{
            ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(nameFileSol));
            objOut.writeObject(sol);
            objOut.flush();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Solution findOrSave(Maze myMaze){

        String filePath = tempDirectoryPath + "Maze - " + myMaze.getRows() + ", " + myMaze.getColumns() + ", "+ myMaze.getStartPosition().getRowIndex() +
                ", " + myMaze.getStartPosition().getColumnIndex() + ", " + myMaze.getGoalPosition().getRowIndex() + ", " + myMaze.getGoalPosition().getColumnIndex()+"," ;


        Object solved = null;

        File newFile = new File(filePath + num);

        while (newFile.exists()){
            try {
                InputStream in = new MyDecompressorInputStream(new FileInputStream(filePath + num));
                String myMaze_byte = "";
                String decompreesed_maze = "";
                byte[] bytesArrayMaze = myMaze.toByteArray();
                byte[] read = new byte[bytesArrayMaze.length];
                for (int i = 0 ; i < bytesArrayMaze.length; i++){
                    myMaze_byte += bytesArrayMaze[i];
                    myMaze_byte += ",";
                }
                in.read(read);
                for (int i = 0; i< read.length ;i++){
                    decompreesed_maze += read[i];
                    decompreesed_maze += ",";
                }
                if (decompreesed_maze.equals(myMaze_byte)) {
                    ObjectInputStream input = new ObjectInputStream(new FileInputStream(tempDirectoryPath + "Solution - " + myMaze.getRows() + ", " + myMaze.getColumns() + ", "+ myMaze.getStartPosition().getRowIndex() +
                            ", " + myMaze.getStartPosition().getColumnIndex() + ", " + myMaze.getGoalPosition().getRowIndex() + ", " + myMaze.getGoalPosition().getColumnIndex()+"," + num ));
                    num++;
                    solved = input.readObject();

                    return (Solution) solved;
                }

                newFile = new File(filePath + num);


            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        if (solved == null){

            ISearchable iSearchable = new SearchableMaze(myMaze);
            ASearchingAlgorithm algorithm = (ASearchingAlgorithm)algo.copyalgo();
            try {
                solved = algorithm.solve(iSearchable);
            } catch (Exception e) {
                e.printStackTrace();
            }
            save_sol(myMaze,(Solution) solved);

        }

        return (Solution) solved;
    }


    private String ArrayToString(Maze maze){
        String fileName = "";

        byte[] b = maze.toByteArray();

        int length = 0;

        if((maze.getRows()*maze.getColumns()) < 7)
            length = 1;
        else
            length = (maze.getRows()*maze.getColumns())/7;

        byte[] bytes = new byte[12 + length];

        int counter = 0;

        for (int i = 4; i <= 24; i += 4) {
            if (b[i - 2] != 0) {
                bytes[counter] = b[i - 2];
            } else {
                bytes[counter] = (byte) 0x00;
            }
            counter++;
            bytes[counter] = b[i - 1]; // now we have the rows the cols the start pos and goal pos
            counter++;
        }


        for (int i = 27; i < b.length; i +=28 ){
            String s = "";

            for(int j = i; j < i + 28; j += 4) {
                if (j > b.length)
                    break;
                s += b[j];
            }

            bytes[counter] = (Byte.parseByte(s, 2));
            counter++;
        }

        for (int i = 0; i < bytes.length; i++){
            if(i == bytes.length - 1)
                fileName += bytes[i];
            else
                fileName += bytes[i] + ", ";
        }

        return fileName;
    }

}
