package algorithms.maze3D;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Maze3D {

    private Position3D startPosition;
    private Position3D goalPosition;
    private int[][][] map;

    /**
     * This function is the maze3D's constructor
     * @param depth is the number of the maze depth
     * @param rows is the number of the maze rows
     * @param cols is the number of the maze columns
     */
    public Maze3D(int depth , int rows , int cols) {
        if (depth < 2 || rows < 2 || cols < 2)
            throw new IllegalArgumentException("The maze3D cannot be smaller than 2*2*2");

        map = new int[depth][rows][cols];
    }

    /**
     * @return the start position3D of the maze
     */
    public Position3D getStartPosition() {
        return startPosition;
    }

    /**
     * @return the goal position3D of the maze
     */
    public Position3D getGoalPosition() {
        return goalPosition;
    }

    /**
     * @return the maze3D
     */
    public int[][][] getMap() {
        return map;
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
        if (d < 0 || r < 0 || c < 0 || d > map.length -1  || r > map[0].length -1 || c > map[0][0].length -1  )
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
        map[d][r][c] = 0;
    }

    /**
     * The function sets the values in the maze3D, choose the start and the goal positions
     * @param x is the value to which the maze3D values are changed
     */
    public void setMyMaze3D(int x){
        /*if ( x == null)
            throw new IllegalArgumentException("The value to set to cannot be 0");*/


        for (int d= 0  ; d < map.length ; d++)
        {
            for (int r=0 ; r< map[0].length; r++)
            {
                for (int c = 0 ; c < map[0][0].length ; c++ )
                {
                    map[d][r][c] = x;
                }
            }
        }

        List<Position3D> position3DList = new ArrayList<>();
        int d;
        for (d = 0 ; d< map.length ; d++)
        {
            int i;
            for (i = 0 ; i < map[0][0].length-1 ; i++){ // First row
                position3DList.add(new Position3D(d , 0 ,i));
            }
            for (i = 1 ; i < map[0].length ; i++){ // First column
                position3DList.add(new Position3D(d,i , 0));
            }

            for (i = 1 ; i < map[0][0].length ; i++){ // Last row
                position3DList.add(new Position3D(d , map[0].length-1 , i));
            }

            for (i = 1 ; i < map[0].length-1; i++){ // Last column
                position3DList.add(new Position3D(d,i, map[0][0].length-1));
            }
        }

        Random rd = new Random();
        int start = rd.nextInt(position3DList.size());
        startPosition = position3DList.get(start);

        position3DList.remove(start);

        boolean near_it = true;
        while (near_it)
        {
            if (map.length > 2 )
            {
                int end = rd.nextInt(position3DList.size());
                goalPosition = position3DList.get(end);
                if (((goalPosition.getColumnIndex() +1 == startPosition.getColumnIndex() && goalPosition.getRowIndex() == startPosition.getRowIndex() && goalPosition.getDepthIndex() == startPosition.getDepthIndex()) || (goalPosition.getColumnIndex() -1 == startPosition.getColumnIndex() && goalPosition.getRowIndex() == startPosition.getRowIndex() && goalPosition.getDepthIndex() == startPosition.getDepthIndex())||(goalPosition.getColumnIndex()  == startPosition.getColumnIndex() && goalPosition.getRowIndex()+1 == startPosition.getRowIndex() && goalPosition.getDepthIndex() == startPosition.getDepthIndex()) ||(goalPosition.getColumnIndex()  == startPosition.getColumnIndex() && goalPosition.getRowIndex() -1 == startPosition.getRowIndex() && goalPosition.getDepthIndex() == startPosition.getDepthIndex()) || (goalPosition.getColumnIndex()  == startPosition.getColumnIndex() && goalPosition.getRowIndex() == startPosition.getRowIndex() && goalPosition.getDepthIndex() + 1  == startPosition.getDepthIndex()) || (goalPosition.getColumnIndex()  == startPosition.getColumnIndex() && goalPosition.getRowIndex() == startPosition.getRowIndex() && goalPosition.getDepthIndex() -1 == startPosition.getDepthIndex()) ||(goalPosition.getColumnIndex()  == startPosition.getColumnIndex() && goalPosition.getRowIndex() == startPosition.getRowIndex() && goalPosition.getDepthIndex()  == startPosition.getDepthIndex())) || (goalPosition.getDepthIndex() - startPosition.getDepthIndex()) % 2 != 0 )
                {
                    //if ((goalPosition.getDepthIndex() - startPosition.getDepthIndex()) % 2 != 0 )
                    near_it = true;
                    position3DList.remove(end);
/*                else
                    near_it = false;*/
                }

                else
                    near_it = false;
            }
            else
            {
                int end = rd.nextInt(position3DList.size());
                goalPosition = position3DList.get(end);
                if (((goalPosition.getColumnIndex() +1 == startPosition.getColumnIndex() && goalPosition.getRowIndex() == startPosition.getRowIndex() && goalPosition.getDepthIndex() == startPosition.getDepthIndex()) || (goalPosition.getColumnIndex() -1 == startPosition.getColumnIndex() && goalPosition.getRowIndex() == startPosition.getRowIndex() && goalPosition.getDepthIndex() == startPosition.getDepthIndex())||(goalPosition.getColumnIndex()  == startPosition.getColumnIndex() && goalPosition.getRowIndex()+1 == startPosition.getRowIndex() && goalPosition.getDepthIndex() == startPosition.getDepthIndex()) ||(goalPosition.getColumnIndex()  == startPosition.getColumnIndex() && goalPosition.getRowIndex() -1 == startPosition.getRowIndex() && goalPosition.getDepthIndex() == startPosition.getDepthIndex()) || (goalPosition.getColumnIndex()  == startPosition.getColumnIndex() && goalPosition.getRowIndex() == startPosition.getRowIndex() && goalPosition.getDepthIndex() + 1  == startPosition.getDepthIndex()) || (goalPosition.getColumnIndex()  == startPosition.getColumnIndex() && goalPosition.getRowIndex() == startPosition.getRowIndex() && goalPosition.getDepthIndex() -1 == startPosition.getDepthIndex()) ||(goalPosition.getColumnIndex()  == startPosition.getColumnIndex() && goalPosition.getRowIndex() == startPosition.getRowIndex() && goalPosition.getDepthIndex()  == startPosition.getDepthIndex()))  )
                {
                    //if ((goalPosition.getDepthIndex() - startPosition.getDepthIndex()) % 2 != 0 )
                    near_it = true;
                    //position3DList.remove(end);
/*                else
                    near_it = false;*/
                }

                else
                    near_it = false;
            }


        }

    }

    /**
     * @return the number of rows in the maze3D
     */
    public int getRows(){
        return this.map[0].length;
    }

    /**
     * @return the number of columns in the maze3D
     */
    public int getColumns(){
        return this.map[0][0].length;
    }

    /**
     * @return the number of depth in the maze3D
     */
    public int getDepth(){
        return this.map.length;
    }

    /**
     * This method prints the maze
     * 0 is for pass way
     * 1 is for a wall
     */
/*    public void print() {
        int depth = this.map.length;
        int rows = this.map[0].length;
        int cols = this.map[0][0].length;
        System.out.println("{");
        for (int d = 0; d < depth; d++) {
            for (int r = 0; r < rows; r++) {
                System.out.print("{ ");
                for (int c = 0; c < cols; c++) {
                    if (this.startPosition.getDepthIndex() == d && this.startPosition.getRowIndex() == r && this.startPosition.getColumnIndex() == c)
                        System.out.print("S ");
                    else if (this.goalPosition.getDepthIndex() == d && this.goalPosition.getRowIndex() == r && this.goalPosition.getColumnIndex() == c)
                        System.out.print("E ");
                    else
                        System.out.print(this.map[d][r][c] + " ");
                }
                System.out.println("}");

            }
            if (d != depth-1) {
                for (int i = 0; i < (map[0][0].length + 2) * 2 - 1; i++) {
                    System.out.print("-");
                }
                System.out.println();
            }

        }
        System.out.println("}");
    }*/

    public void print(){
        System.out.println("{");
        for(int depth = 0; depth < map.length; depth++){
            for(int row = 0; row < map[0].length; row++) {
                System.out.print("{ ");
                for (int col = 0; col < map[0][0].length; col++) {
                    if (depth == startPosition.getDepthIndex() && row == startPosition.getRowIndex() && col == startPosition.getColumnIndex()) // if the position is the start - mark with S
                        System.out.print("S ");
                    else {
                        if (depth == goalPosition.getDepthIndex() && row == goalPosition.getRowIndex() && col == goalPosition.getColumnIndex()) // if the position is the goal - mark with E
                            System.out.print("E ");
                        else
                            System.out.print(map[depth][row][col] + " ");
                    }
                }
                System.out.println("}");
            }
            if(depth < map.length - 1) {
                System.out.print("---");
                for (int i = 0; i < map[0][0].length; i++)
                    System.out.print("--");
                System.out.println();
            }
        }
        System.out.println("}");
    }

}
