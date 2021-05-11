package Server;

import IO.MyCompressorOutputStream;
import IO.MyDecompressorInputStream;
import algorithms.mazeGenerators.Maze;
import algorithms.search.ASearchingAlgorithm;
import algorithms.search.ISearchable;
import algorithms.search.SearchableMaze;
import algorithms.search.Solution;


import java.io.*;
import java.util.Arrays;
import java.util.HashMap;


public class ServerStrategySolveSearchProblem implements IServerStrategy{


    public ASearchingAlgorithm algo;
    private String tempDirectoryPath;
    private HashMap<File,File> map = new HashMap<>();

    public ServerStrategySolveSearchProblem() {
        this.tempDirectoryPath = System.getProperty("java.io.tmpdir");
        this.algo = Configurations.getMazeSearchingAlgorithm();

        File[] files = new File(tempDirectoryPath).listFiles();

        String name = "Maze - ";
        for (File f: files) {
            if(f.getName().startsWith(name)) {
                String name2 = "Solution - " + f.getName().substring(7);
                for (File f2 : files) {
                    if (f2.getName().equals(name2)) {
                        map.put(f, f2);
                        break;
                    }
                }
            }
        }

    }

    @Override
    public void ServerStrategy(InputStream inFromClient, OutputStream outToClient) {

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

        File mazeFile = new File(tempDirectoryPath + "Maze - " + s);

        File solFile = new File(tempDirectoryPath + "Solution - " + s);


        try{
            OutputStream out = new MyCompressorOutputStream(new FileOutputStream(mazeFile));
            out.write(myMaze.toByteArray());
            out.flush();

            ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(solFile));
            objOut.writeObject(sol);
            objOut.flush();


            map.put(mazeFile, solFile);


        }catch(Exception e){

            e.printStackTrace();
        }
    }

    public Solution findOrSave(Maze myMaze){

        int mazeNum = 0;

        String s = ArrayToString(myMaze, mazeNum);



        Object solved = null;

        File mazePath = new File(tempDirectoryPath+ "Maze - " + s);
        File solPath = new File(tempDirectoryPath+ "Solution - " + s);


        if (!map.isEmpty()){
            while (map.containsKey(mazePath)){
                try {

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
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                }

            }

        if (solved == null){

            ISearchable iSearchable = new SearchableMaze(myMaze);
            ASearchingAlgorithm algorithm = (ASearchingAlgorithm)algo.copyalgo();
            try {
                solved = algorithm.solve(iSearchable);
            } catch (Exception e) {
                //System.out.println("line 209");
                e.printStackTrace();
            }
            save_sol(myMaze,(Solution) solved, s);

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
