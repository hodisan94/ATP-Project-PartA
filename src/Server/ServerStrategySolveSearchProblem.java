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
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.HashSet;


public class ServerStrategySolveSearchProblem implements IServerStrategy{


    public ASearchingAlgorithm algo;
    private String tempDirectoryPath;
    //private int mazeNum = 0;
    //private HashSet<File> map = new HashSet<>();
    private HashMap<File,File> map = new HashMap<>();

    public ServerStrategySolveSearchProblem() {
        this.tempDirectoryPath = System.getProperty("java.io.tmpdir");
        this.algo = Configurations.getMazeSearchingAlgorithm();

        File[] files = new File(tempDirectoryPath).listFiles();

        String name = "Maze - ";
        for (File f: files) {
            if(f.getName().startsWith(name)) {
                String name2 = f.getName().substring(7);
                for (File f2 : files) {
                    if (f2.getName().endsWith(name2)) {
                        map.put(f, f2);
                        break;
                    }
                }
            }

        }

    }

    @Override
    public void serverStrategy(InputStream inFromClient, OutputStream outToClient) {

        try {
            ObjectOutputStream toClient = new ObjectOutputStream(outToClient);
            ObjectInputStream fromClient = new ObjectInputStream(inFromClient);

            Maze myMaze = (Maze)fromClient.readObject();

            Solution solve = findOrSave(myMaze);
            toClient.writeObject(solve);
            toClient.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void save_sol(Maze myMaze , Solution sol , String s ){


        //String s = myMaze.ArrayToString(myMaze);
        //String s = ArrayToString(myMaze, );


        File mazeFile = new File(tempDirectoryPath + "Maze - " + s);

        File solFile = new File(tempDirectoryPath + "Solution - " + s);

        //map.add(nameFileMaze);

        try{

            //System.out.println("line 82 - passed");
            OutputStream out = new MyCompressorOutputStream(new FileOutputStream(mazeFile));
            out.write(myMaze.toByteArray());
            out.flush();


            //System.out.println("line 86 - passed");
            ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(solFile));
            //System.out.println("line 88 - passed");
            objOut.writeObject(sol);
            //System.out.println("line 90 - passed");
            objOut.flush();
            //out.flush();

            map.put(mazeFile, solFile);


        }catch(Exception e){
            //System.out.println("line 91");
            System.out.println(e.getMessage());
        }
    }

    public Solution findOrSave(Maze myMaze){

        /*String filePath = tempDirectoryPath + "Maze - " + myMaze.getRows() + ", " + myMaze.getColumns() + ", "+ myMaze.getStartPosition().getRowIndex() +
                ", " + myMaze.getStartPosition().getColumnIndex() + ", " + myMaze.getGoalPosition().getRowIndex() + ", " + myMaze.getGoalPosition().getColumnIndex()+"," ;*/

        System.out.println("la la la lal la ");

        int mazeNum = 0;

        //String s = myMaze.ArrayToString(myMaze);
        String s = ArrayToString(myMaze, mazeNum);



        Object solved = null;

        File mazePath = new File(tempDirectoryPath+ "Maze - " + s + ", " + mazeNum);
        File solPath = new File(tempDirectoryPath+ "Solution - " + s + ", " + mazeNum);

        //File newFile = new File(filePath + num);

        if (!map.isEmpty()){
            if (map.containsKey(mazePath)){
                try {
                    System.out.println("im here..");

                    InputStream in = new MyDecompressorInputStream(new FileInputStream(mazePath));

                    byte[] bytesArrayMaze = myMaze.toByteArray();

                    byte[] read = new byte[bytesArrayMaze.length];

                    in.read(read);


                    if(Arrays.equals(bytesArrayMaze, read)){
                        ObjectInputStream input = new ObjectInputStream(new FileInputStream(solPath));

                        solved = input.readObject();

                        return (Solution) solved;
                    }

                    mazeNum++;

                } catch (IOException e) {
                    System.out.println("line 155");
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    System.out.println("line 158");
                    e.printStackTrace();
                }

                //return (Solution) solved;
                }


            }

 /*       while (newFile.exists()){
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

        }*/
        if (solved == null){

            ISearchable iSearchable = new SearchableMaze(myMaze);
            ASearchingAlgorithm algorithm = (ASearchingAlgorithm)algo.copyalgo();
            try {
                solved = algorithm.solve(iSearchable);
            } catch (Exception e) {
                //System.out.println("line 209");
                e.printStackTrace();
            }
            save_sol(myMaze,(Solution) solved, (s + mazeNum));

        }

        return (Solution) solved;
    }


    private String ArrayToString(Maze maze, int mazeNum){
        String fileName = "";

        byte[] b = maze.toByteArray();

        /*int length = 0;

        if((maze.getRows()*maze.getColumns()) < 8)
            length = 1;
        else
            length = (maze.getRows()*maze.getColumns())/8 + 1;*/

        byte[] bytes = new byte[13];

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


        /*for (int i = 27; i < b.length; i +=32 ){
            String s = "";

            for(int j = i; j < i + 32; j += 4) {
                if (j > b.length)
                    break;
                s += b[j];
            }

            bytes[counter] = (byte)(int)Integer.valueOf(s,2);
            //bytes[counter] = (Byte.parseByte(s, 2));
            counter++;
        }*/

        for (int i = 0; i < bytes.length - 1; i++){
            /*if(i == bytes.length - 1)
                fileName += bytes[i];
            else*/
            fileName += bytes[i] + ", ";
        }

        fileName += mazeNum;

        return fileName;
    }

}
