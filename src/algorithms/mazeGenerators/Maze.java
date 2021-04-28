package algorithms.mazeGenerators;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Maze {
    private Position startPosition;
    private Position goalPosition;
    private int[][] myMaze;

    /**
     * The function is a maze constructor
     * @param rows is the number of the maze rows
     * @param cols is the number of the maze columns
     */
    public Maze(int rows, int cols) {
        if (rows < 2 || cols < 2)
            throw new IllegalArgumentException("The maze cannot be smaller than 2*2");
        myMaze = new int[rows][cols];
    }

    /**
     * This function sets the position (i,j) in the maze to 0
     * @param i is the x position
     * @param j is the y position
     */
    public void setMazeBlockZero(int i , int j){
        myMaze[i][j] = 0;
    }


    /**
     * This function finds if a position is in the bound of the maze
     * @param i is the x position
     * @param j is the y position
     * @return true if the position is in bound and false if not
     */
    public boolean in_bound(int i , int j ){
        if(i > myMaze.length -1 || j > myMaze[0].length  -1 || i< 0 || j < 0 )
            return false;
        return true;
    }

    /**
     * The function sets the values in the maze, choose the start and the goal positions
     * @param x is the value to which the maze values are changed
     */
    public void setMyMaze(int x){
        for( int i = 0; i < myMaze.length; i++) {
            for (int j = 0; j < myMaze[0].length; j++) {
                myMaze[i][j] = x;
            }
        }

        List<Position> positionList = new ArrayList<>();

        int i;
        for(i = 0; i < myMaze[0].length; i++){ // First row
            positionList.add(new Position(0,i));
        }

        for(i = 1; i < myMaze.length; i++){ //First column
            positionList.add(new Position(i,0));
        }

        for(i = 1; i < myMaze[0].length; i++){ //Last row
            positionList.add(new Position(myMaze.length - 1 ,i));
        }

        for(i = 1; i < myMaze.length-1; i++){ //Last column
            positionList.add(new Position(i, myMaze[0].length - 1));
        }

        Random rd = new Random();
        int start = rd.nextInt(positionList.size());
        startPosition = positionList.get(start);

        positionList.remove(start);

        boolean near_it = true;
        while (near_it){
            int end = rd.nextInt(positionList.size());
            goalPosition = positionList.get(end);
            if ((goalPosition.getColumnIndex() + 1 == startPosition.getColumnIndex() && goalPosition.getRowIndex() == startPosition.getRowIndex()) || (goalPosition.getColumnIndex() -1 == startPosition.getColumnIndex() && goalPosition.getRowIndex() == startPosition.getRowIndex()) || (goalPosition.getRowIndex() + 1 == startPosition.getRowIndex() && getGoalPosition().getColumnIndex() == startPosition.getColumnIndex()) || (goalPosition.getRowIndex() -1 == startPosition.getRowIndex()&& getGoalPosition().getColumnIndex() == startPosition.getColumnIndex()) ||(goalPosition.getRowIndex()  == startPosition.getRowIndex()&& getGoalPosition().getColumnIndex() == startPosition.getColumnIndex()) )
                near_it = true;
            else
                near_it = false;
        }

    }

    /**
     * This method prints the maze
     * " " is for pass way
     * # is for a wall
     */
    public void printMaze() // for fun
    {
        int rows = this.myMaze.length;
        int cols  = this.myMaze[0].length;
        for (int i = 0; i < rows; i++) {
            System.out.print("{ ");
            for (int j = 0; j < cols; j++) {
                if (this.startPosition.getRowIndex() == i && this.startPosition.getColumnIndex() == j)
                    System.out.print("S ");
                else if (this.goalPosition.getRowIndex() == i && this.goalPosition.getColumnIndex() == j)
                    System.out.print("E ");
                else if (this.getMyMaze()[i][j] == 1)
                {
                    System.out.print("# ");
                }
                else
                    System.out.print("  ");
            }
            System.out.println("}");

        }

    }

    /**
     * This method prints the maze
     * 0 is for pass way
     * 1 is for a wall
     */
    public void print() {
        int rows = this.myMaze.length;
        int cols = this.myMaze[0].length;
        for (int i = 0; i < rows; i++) {
            System.out.print("{ ");
            for (int j = 0; j < cols; j++) {
                if (this.startPosition.getRowIndex() == i && this.startPosition.getColumnIndex() == j)
                    System.out.print("S ");
                else if (this.goalPosition.getRowIndex() == i && this.goalPosition.getColumnIndex() == j)
                    System.out.print("E ");
                else
                    System.out.print(this.myMaze[i][j] + " ");
            }
            System.out.println("}");
        }
    }


    public byte[] toByteArray(){
        byte[] b ;
        ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES*(6+(this.getRows()*this.getColumns())));
        int rows = this.getRows();
        int cols = this.getColumns();
        Position start = new Position(this.getStartPosition());
        Position goal = new Position(this.getGoalPosition());
        buffer.putInt(rows);
        buffer.putInt(cols);
        buffer.putInt(start.getRowIndex());
        buffer.putInt(start.getColumnIndex());
        buffer.putInt(goal.getRowIndex());
        buffer.putInt(goal.getColumnIndex());
/*        b[0] = (byte)rows;
        b[1] = (byte)cols;
        b[2] = (byte)start.getRowIndex();
        b[3] = (byte)start.getColumnIndex();
        b[4] = (byte)goal.getRowIndex();
        b[5] = (byte)goal.getColumnIndex();
        int counter = 6;*/
        for (int i = 0 ; i < this.getRows(); i ++){
            for(int j = 0 ; j < this.getColumns(); j++) {
                buffer.putInt(this.myMaze[i][j]);
            }
        }
        b = buffer.array();
        return b;

    }

    public Maze(byte[] b){

        ByteBuffer bb = ByteBuffer.allocate(b.length);
        for(int i = 0 ; i< b.length ; i ++){
            bb.put(b[i]);
        }
        bb.rewind();


        int rows = bb.getInt();
        int cols = bb.getInt();
        int start_row = bb.getInt();
        int start_col  = bb.getInt();
        int goal_row = bb.getInt();
        int goal_col = bb.getInt();

        this.myMaze = new int[rows][cols];
        this.startPosition = new Position(start_row,start_col);
        this.goalPosition = new Position(goal_row ,goal_col);


        for(int s = 0 ; s< this.myMaze.length; s++){
            for (int e = 0 ; e<this.myMaze[0].length;e++){
                this.myMaze[s][e] = bb.getInt();
            }
        }


    }


    /**
     * @return the maze
     */
    public int[][] getMyMaze() {
        return myMaze;
    }

    /**
     * @return the start position of the maze
     */
    public Position getStartPosition() {
        return startPosition;
    }

    /**
     * @return the goal position of the maze
     */
    public Position getGoalPosition() {
        return goalPosition;
    }

    /**
     * @param i is the row position
     * @param j is the column position
     * @return the value of the position
     */
    public int getCellValue(int i , int j ){
        return myMaze[i][j];
    }

    /**
     * @return the number of rows in the maze
     */
    public int getRows() {
        return myMaze.length;
    }

    /**
     * @return the number of columns in the maze
     */
    public int getColumns() {
        return myMaze[0].length;
    }
}
