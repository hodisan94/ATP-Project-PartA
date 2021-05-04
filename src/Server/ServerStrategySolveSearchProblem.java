package Server;

import algorithms.mazeGenerators.Maze;
import algorithms.search.ASearchingAlgorithm;
import algorithms.search.Solution;

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
                Maze myMaze = (Maze) fromClient.readObject();
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

    public void save_sol(Maze myMaze , Solution sol , int num){

        int rows = myMaze.getRows();
        int cols = myMaze.getColumns();
        int start_x_pos = myMaze.getStartPosition().getRowIndex();
        int start_y_pos = myMaze.getStartPosition().getColumnIndex();
        int goal_x_pos = myMaze.getGoalPosition().getRowIndex();
        int goal_y_pos = myMaze.getGoalPosition().getColumnIndex();

        String Name = "sol-" + rows + "," + cols + "," + start_x_pos+ "," + start_y_pos + "," +goal_x_pos + "," + goal_y_pos + "," + num;

        File solution = new File(tempDirectoryPath+" "+Name);

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(solution));
            out.writeObject(sol);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public Solution findOrSave(Maze myMaze){

        Solution solved = null;

        int rows = myMaze.getRows();
        int cols = myMaze.getColumns();
        int start_x_pos = myMaze.getStartPosition().getRowIndex();
        int start_y_pos = myMaze.getStartPosition().getColumnIndex();
        int goal_x_pos = myMaze.getGoalPosition().getRowIndex();
        int goal_y_pos = myMaze.getGoalPosition().getColumnIndex();

        String path = this.tempDirectoryPath + "," + rows + "," + cols + "," + start_x_pos + "," + start_y_pos + "," + goal_x_pos + "," +goal_y_pos;
        File newFile = new File(path);



        return solved;
    }
}
