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


public class ServerStrategySolveSearchProblem implements IServerStrategy{


    public ASearchingAlgorithm algo;
    private String tempDirectoryPath;
    private int num = 0;

    public ServerStrategySolveSearchProblem() {
        this.tempDirectoryPath = System.getProperty("java.io.tmpdir");
        this.algo = new BreadthFirstSearch();

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

    public void save_sol(Maze myMaze , Solution sol ){

        String fileName = myMaze.getRows() + ", " + myMaze.getColumns() + ", "+ myMaze.getStartPosition().getRowIndex() +
                ", " + myMaze.getStartPosition().getColumnIndex() + ", " + myMaze.getGoalPosition().getRowIndex() + ", " + myMaze.getGoalPosition().getColumnIndex() + ", " + num;

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




        /*byte[] bytes = myMaze.toByteArray();
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
        }*/


    }

    public Solution findOrSave(Maze myMaze){

        String filePath = tempDirectoryPath + "Maze - " + myMaze.getRows() + ", " + myMaze.getColumns() + ", "+ myMaze.getStartPosition().getRowIndex() +
                ", " + myMaze.getStartPosition().getColumnIndex() + ", " + myMaze.getGoalPosition().getRowIndex() + ", " + myMaze.getGoalPosition().getColumnIndex() + ", " + num;

        Object solved = null;

        /*byte[] bytes = myMaze.toByteArray();
        String solv = "solution: - ";
        for (int i = 0 ; i < bytes.length; i++){
            solv += bytes[i];
            solv += ",";
        }*/

        //String ourPath = this.tempDirectoryPath + " " + solv;



        File newFile = new File(filePath);

        while (newFile.exists()){
            try {
                InputStream in = new MyDecompressorInputStream(new FileInputStream(filePath));
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
                            ", " + myMaze.getStartPosition().getColumnIndex() + ", " + myMaze.getGoalPosition().getRowIndex() + ", " + myMaze.getGoalPosition().getColumnIndex() + ", " + num));
                    solved =input.readObject();

                    return (Solution) solved;
                }


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
}
