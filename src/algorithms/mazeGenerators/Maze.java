package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Maze {
    private Position startPosition;
    private Position goalPosition;
    private int[][] myMaze;

    public Maze(int rows, int cols) {
        myMaze = new int[rows][cols];
    }



    public void setMazeBlockZero(int i , int j){
        myMaze[i][j] = 0;
    }

    public boolean in_bound(int i , int j ){
        if(i > myMaze.length -1 || j > myMaze[0].length  -1 || i< 0 || j < 0 )
            return false;
        return true;

    }

    public void setMyMaze(int x){
        for( int i = 0; i < myMaze.length; i++) {
            for (int j = 0; j < myMaze[0].length; j++) {
                myMaze[i][j] = x;
            }
        }

        List<Position> positionList = new ArrayList<>();

        int i;
        for(i = 0; i < myMaze[0].length; i++){ // first row
            positionList.add(new Position(0,i));
        }

        for(i = 1; i < myMaze.length; i++){
            positionList.add(new Position(i,0));
        }

        for(i = 1; i < myMaze[0].length; i++){
            positionList.add(new Position(myMaze.length - 1 ,i));
        }

        for(i = 1; i < myMaze.length-1; i++){
            positionList.add(new Position(i, myMaze[0].length - 1));
        }

        Random rd = new Random();
        int start = rd.nextInt(positionList.size());
        startPosition = positionList.get(start);

        positionList.remove(start);

/*        if (startPosition.getRowIndex() == 0){
            if( startPosition.getColumnIndex() == 0) {

                int  k = positionList.indexOf(new Position(0,1));
                //positionList.remove(k);
                positionList.remove(new Position(1, 0));
            }
            else if( startPosition.getColumnIndex() == myMaze.length - 1){
                positionList.remove(new Position(0,myMaze.length - 2));
                positionList.remove(new Position(1, myMaze.length - 1));
            }
            else {
                positionList.remove(new Position(0, startPosition.getColumnIndex() - 1));
                positionList.remove(new Position(0, startPosition.getColumnIndex() + 1));
            }
        }

        else if (startPosition.getRowIndex() == myMaze[0].length - 1) {
            if (startPosition.getColumnIndex() == 0) {
                positionList.remove(new Position(myMaze[0].length - 2, 0));
                positionList.remove(new Position(myMaze[0].length - 1, 1));
            }
            else if (startPosition.getColumnIndex() == myMaze.length - 1) {
                positionList.remove(new Position(myMaze[0].length - 1, myMaze.length - 2));
                positionList.remove(new Position(myMaze[0].length - 2, myMaze.length - 1));
            }
            else{
                positionList.remove(new Position(myMaze[0].length - 1, startPosition.getColumnIndex() - 1));
                positionList.remove(new Position(myMaze[0].length - 1, startPosition.getColumnIndex() + 1));

            }
        }
        else if(startPosition.getColumnIndex() == 0){
            positionList.remove(new Position(myMaze[0].length - 1, 0));
            positionList.remove(new Position(myMaze[0].length + 1, 0));
        }
        else{
            positionList.remove(new Position(myMaze[0].length - 1, myMaze.length - 1));
            positionList.remove(new Position(myMaze[0].length + 1, myMaze.length - 1));
        }*/
        boolean near_it = true;
        while (near_it){
            int end = rd.nextInt(positionList.size());
            goalPosition = positionList.get(end);
            if ((goalPosition.getColumnIndex() + 1 == startPosition.getColumnIndex() && goalPosition.getRowIndex() == startPosition.getRowIndex()) || (goalPosition.getColumnIndex() -1 == startPosition.getColumnIndex() && goalPosition.getRowIndex() == startPosition.getRowIndex()) || (goalPosition.getRowIndex() + 1 == startPosition.getRowIndex() && getGoalPosition().getColumnIndex() == startPosition.getColumnIndex()) || (goalPosition.getRowIndex() -1 == startPosition.getRowIndex()&& getGoalPosition().getColumnIndex() == startPosition.getColumnIndex()))
                near_it = true;
            else
                near_it = false;
        }

       // int end = rd.nextInt(positionList.size());
        //goalPosition = positionList.get(end);
    }

    public void printMaze()
    {
        int rows = this.myMaze.length;
        int cols  = this.myMaze[0].length;
        String smaze = this.toString();
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

    public void print() {
        int rows = this.myMaze.length;
        int cols = this.myMaze[0].length;
        String smaze = this.toString();
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



    /**
     * @return the start position of the maze
     */

    public int[][] getMyMaze() {
        return myMaze;
    }

    public Position getStartPosition() {
        return startPosition;
    }

    /**
     * @return the end position of the maze
     */
    public Position getGoalPosition() {
        return goalPosition;
    }

    public int getCellValue(int i , int j ){
        return myMaze[i][j];
    }

    /**
     * This method prints the maze
     */

}
