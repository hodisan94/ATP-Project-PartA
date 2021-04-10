package algorithms.maze3D;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Maze3D {

    private Position3D StartPosition;
    private Position3D GoalPosition;
    private int[][][] Map;

    /**
     * This function is the maze3D's constructor
     * @param depth is the number of the maze depth
     * @param rows is the number of the maze rows
     * @param cols is the number of the maze columns
     */
    public Maze3D(int depth , int rows , int cols) {

        Map = new int[depth][rows][cols];
    }

    /**
     * @return the start position3D of the maze
     */
    public Position3D getStartPosition() {
        return StartPosition;
    }

    /**
     * @return the goal position3D of the maze
     */
    public Position3D getGoalPosition() {
        return GoalPosition;
    }

    /**
     * @return the maze3D
     */
    public int[][][] getMap() {
        return Map;
    }

    /**
     * This function finds if a position3D is in the bound of the maze
     * @param d is the depth position3D
     * @param r is the row position3D
     * @param c is the column position3D
     * @return
     */
    public boolean in_bound3D(int d , int r , int c)
    {
        if (d < 0 || r < 0 || c < 0 || d > Map.length -1  || r > Map[0].length -1 || c > Map[0][0].length -1  )
            return false;
        return true;
    }


    /**
     * This function sets the position3D (d,r,c) in the maze to 0
     * @param d is the depth position3D
     * @param r is the row position3D
     * @param c is the column position3D
     */
    public void setMazeBlockZero3D(int d ,int r , int c){
        Map[d][r][c] = 0;
    }

    /**
     * The function sets the values in the maze3D, choose the start and the goal positions
     * @param x is the value to which the maze3D values are changed
     */
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
            if ((GoalPosition.getColumnIndex() +1 == StartPosition.getColumnIndex() && GoalPosition.getRowIndex() == StartPosition.getRowIndex() && GoalPosition.getDepthIndex() == StartPosition.getDepthIndex()) || (GoalPosition.getColumnIndex() -1 == StartPosition.getColumnIndex() && GoalPosition.getRowIndex() == StartPosition.getRowIndex() && GoalPosition.getDepthIndex() == StartPosition.getDepthIndex())||(GoalPosition.getColumnIndex()  == StartPosition.getColumnIndex() && GoalPosition.getRowIndex()+1 == StartPosition.getRowIndex() && GoalPosition.getDepthIndex() == StartPosition.getDepthIndex()) ||(GoalPosition.getColumnIndex()  == StartPosition.getColumnIndex() && GoalPosition.getRowIndex() -1 == StartPosition.getRowIndex() && GoalPosition.getDepthIndex() == StartPosition.getDepthIndex()) || (GoalPosition.getColumnIndex()  == StartPosition.getColumnIndex() && GoalPosition.getRowIndex() == StartPosition.getRowIndex() && GoalPosition.getDepthIndex() + 1  == StartPosition.getDepthIndex()) || (GoalPosition.getColumnIndex()  == StartPosition.getColumnIndex() && GoalPosition.getRowIndex() == StartPosition.getRowIndex() && GoalPosition.getDepthIndex() -1 == StartPosition.getDepthIndex()) ||(GoalPosition.getColumnIndex()  == StartPosition.getColumnIndex() && GoalPosition.getRowIndex() == StartPosition.getRowIndex() && GoalPosition.getDepthIndex()  == StartPosition.getDepthIndex()) )
                near_it = true;
            else
                near_it = false;

        }

    }

    /**
     * @return the number of rows in the maze3D
     */
    public int getRows(){
        return this.Map[0].length;
    }

    /**
     * @return the number of columns in the maze3D
     */
    public int getColumns(){
        return this.Map[0][0].length;
    }

    /**
     * @return the number of depth in the maze3D
     */
    public int getDepth(){
        return this.Map.length;
    }

    /**
     * This method prints the maze
     * 0 is for pass way
     * 1 is for a wall
     */
    public void print() {
        int depth = this.Map.length;
        int rows = this.Map[0].length;
        int cols = this.Map[0][0].length;
        System.out.println("{");
        for (int d = 0; d < depth; d++) {
            for (int r = 0; r < rows; r++) {
                System.out.print("{ ");
                for (int c = 0; c < cols; c++) {
                    if (this.StartPosition.getDepthIndex() == d && this.StartPosition.getRowIndex() == r && this.StartPosition.getColumnIndex() == c)
                        System.out.print("S ");
                    else if (this.GoalPosition.getDepthIndex() == d && this.GoalPosition.getRowIndex() == r && this.GoalPosition.getColumnIndex() == c)
                        System.out.print("E ");
                    else
                        System.out.print(this.Map[d][r][c] + " ");
                }
                System.out.println("}");

            }
            if (d != depth-1) {
                for (int i = 0; i < (Map[0][0].length + 2) * 2 - 1; i++) {
                    System.out.print("-");
                }
                System.out.println();
            }

        }
        System.out.println("}");
    }

}
