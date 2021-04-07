package algorithms.mazeGenerators;

import java.util.Random;

public class SimpleMazeGenerator extends AMazeGenerator {
    /**
     * @param rows is the number of the maze rows
     * @param cols is the number of the maze columns
     * @return the simple maze that was created with start and goal positions that were chosen
     */
    @Override
    public Maze generate(int rows, int cols) {
        Maze myMaze = new Maze(rows, cols);
        myMaze.setMyMaze(1);
        myMaze.setMazeBlockZero(myMaze.getStartPosition().getRowIndex(), myMaze.getStartPosition().getColumnIndex());
        Position current_place =new Position(myMaze.getStartPosition().getRowIndex(),myMaze.getStartPosition().getColumnIndex());
        boolean finised = false;
        while (!finised) {
            if (current_place.getRowIndex() > myMaze.getGoalPosition().getRowIndex())
            {
                current_place.setX_pos(((current_place.getRowIndex())-1));
                myMaze.setMazeBlockZero(current_place.getRowIndex(), current_place.getColumnIndex());

            }
            if(current_place.getRowIndex() < myMaze.getGoalPosition().getRowIndex())
            {
                current_place.setX_pos(current_place.getRowIndex()+1);
                myMaze.setMazeBlockZero(current_place.getRowIndex(), current_place.getColumnIndex());

            }
            if (current_place.getColumnIndex()> myMaze.getGoalPosition().getColumnIndex())
            {
                current_place.setY_pos(current_place.getColumnIndex()-1);
                myMaze.setMazeBlockZero(current_place.getRowIndex(), current_place.getColumnIndex());

            }
            if (current_place.getColumnIndex() <  myMaze.getGoalPosition().getColumnIndex())
            {
                current_place.setY_pos(current_place.getColumnIndex()+1);
                myMaze.setMazeBlockZero(current_place.getRowIndex(), current_place.getColumnIndex());

            }

            if (current_place.getRowIndex() == myMaze.getGoalPosition().getRowIndex() && current_place.getColumnIndex() == myMaze.getGoalPosition().getColumnIndex()) {
                finised = true;
            }

        }

        int arr[] = {0,1};
        for (int i = 0; i < myMaze.getMyMaze().length ; i++) {
            for (int j = 0 ; j < myMaze.getMyMaze()[0].length ; j++){
                Random rd = new Random();
                int rdNum = rd.nextInt(arr.length);
                if (myMaze.getMyMaze()[i][j] !=0)
                {
                    myMaze.getMyMaze()[i][j] = rdNum;

                }

            }

        }

        return myMaze;
    }
}


