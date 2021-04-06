package algorithms.maze3D;

import algorithms.mazeGenerators.Maze;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Maze3D {

    private Position3D StartPosition;
    private Position3D GoalPosition;
    private int[][][] Map;

    public Maze3D(int depth , int rows , int cols)
    {
        Map = new int[depth][rows][cols];
    }

    public Position3D getStartPosition() {
        return StartPosition;
    }

    public Position3D getGoalPosition() {
        return GoalPosition;
    }

    public int[][][] getMap() {
        return Map;
    }

    public boolean in_bound3D(int d , int r , int c)
    {
        if (d < 0 || r < 0 || c < 0 || d > Map.length -1  || r > Map[0].length -1 || c > Map[0][0].length -1  )
            return false;
        return true;
    }


    public void setMazeBlockZero3D(int d ,int r , int c){
        Map[d][r][c] = 0;
    }

    public void setMyMaze3D(int x){

        for (int d= 0  ; d < Map.length ; d++)
        {
            for (int r=0 ; r< Map[0].length; r++)
            {
                for (int c = 0 ; c < Map[0][0].length ; c++ )
                {
                    Map[d][r][c] = x;
                }
            }
        }

        List<Position3D> position3DList = new ArrayList<>();
        int d;
        for (d = 0 ; d< Map.length ; d++)
        {
            int i;
            for (i = 0 ; i < Map[0][0].length ; i++){ // First row
                position3DList.add(new Position3D(d , 0 ,i));
            }
            for (i = 1 ; i < Map[0].length ; i++){ // First column
                position3DList.add(new Position3D(d,i , 0));
            }

            for (i = 1 ; i < Map[0][0].length ; i++){ // Last row
                position3DList.add(new Position3D(d , Map[0].length-1 , i));
            }

            for (i = 1 ; i < Map[0].length-1; i++){ // Last column
                position3DList.add(new Position3D(d, Map[0][0].length-1 , i));
            }
        }

        Random rd = new Random();
        int start = rd.nextInt(position3DList.size());
        StartPosition = position3DList.get(start);

        position3DList.remove(start);

        boolean near_it = true;
        while (near_it)
        {
            int end = rd.nextInt(position3DList.size());
            GoalPosition = position3DList.get(end);
            if ((GoalPosition.getColumnIndex() +1 == StartPosition.getColumnIndex() && GoalPosition.getRowIndex() == StartPosition.getRowIndex() && GoalPosition.getDepthIndex() == StartPosition.getDepthIndex()) || (GoalPosition.getColumnIndex() -1 == StartPosition.getColumnIndex() && GoalPosition.getRowIndex() == StartPosition.getRowIndex() && GoalPosition.getDepthIndex() == StartPosition.getDepthIndex())||(GoalPosition.getColumnIndex()  == StartPosition.getColumnIndex() && GoalPosition.getRowIndex()+1 == StartPosition.getRowIndex() && GoalPosition.getDepthIndex() == StartPosition.getDepthIndex()) ||(GoalPosition.getColumnIndex()  == StartPosition.getColumnIndex() && GoalPosition.getRowIndex() -1 == StartPosition.getRowIndex() && GoalPosition.getDepthIndex() == StartPosition.getDepthIndex()) || (GoalPosition.getColumnIndex()  == StartPosition.getColumnIndex() && GoalPosition.getRowIndex() == StartPosition.getRowIndex() && GoalPosition.getDepthIndex() + 1  == StartPosition.getDepthIndex()) || (GoalPosition.getColumnIndex()  == StartPosition.getColumnIndex() && GoalPosition.getRowIndex() == StartPosition.getRowIndex() && GoalPosition.getDepthIndex() -1 == StartPosition.getDepthIndex()) )
                near_it = true;
            else
                near_it = false;

        }

    }

}
