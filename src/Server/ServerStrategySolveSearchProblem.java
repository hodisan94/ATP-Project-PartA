package Server;

import IO.MyDecompressorInputStream;
import algorithms.mazeGenerators.Maze;
import algorithms.search.ASearchingAlgorithm;
import algorithms.search.ISearchable;
import algorithms.search.ISearchingAlgorithm;
import algorithms.search.SearchableMaze;
import algorithms.search.Solution;
import algorithms.search.*;


import java.io.*;


public class ServerStrategySolveSearchProblem implements IServerStrategy{


    private ASearchingAlgorithm algo;
    private String tempDirectoryPath;
    private static int num = 0;

    public ServerStrategySolveSearchProblem() {
        this.tempDirectoryPath = System.getProperty("java.io.tmpdir");

    }

    @Override
    public void serverStrategy(InputStream inFromClient, OutputStream outToClient) {

        try {
            ObjectOutputStream toClient = new ObjectOutputStream(outToClient);
            ObjectInputStream fromClient = new ObjectInputStream(inFromClient);

            try {
                Maze myMaze = (Maze)fromClient.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            Solution solve = null;
            toClient.writeObject(solve);
            toClient.flush();



        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void save_sol(Maze myMaze , Solution sol ){



        byte[] bytes = myMaze.toByteArray();
        String solv = "solution: - ";
        for (int i = 0 ; i < bytes.length; i++){
            solv += bytes[i];
            solv += ",";
        }
        File solution = new File(tempDirectoryPath+" "+solv );

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(solution));
            out.writeObject(sol);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public Solution findOrSave(Maze myMaze){

        Object solved = null;

        byte[] bytes = myMaze.toByteArray();
        String solv = "solution: - ";
        for (int i = 0 ; i < bytes.length; i++){
            solv += bytes[i];
            solv += ",";
        }

        String ourPath = this.tempDirectoryPath + " " + solv;



        File newFile = new File(ourPath);
        while (newFile.exists()){
            try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(ourPath));
                Object read = (Object)in.read();
                if (((String)read).equals(myMaze.toByteArray())) {
                    solved = in.read();
                    return (Solution) solved;
                }


            } catch (IOException e) {
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
}
