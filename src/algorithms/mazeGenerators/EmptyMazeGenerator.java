package algorithms.mazeGenerators;

public class EmptyMazeGenerator extends AMazeGenerator{
    /**
     * @param rows is the number of the maze rows
     * @param cols is the number of the maze columns
     * @return the empty maze that was created with start ant goal positions that were chosen
     */
    @Override
    public Maze generate(int rows, int cols) {

        Maze myMaze = new Maze(rows, cols);
        myMaze.setMyMaze(0);

        return myMaze;
    }
}
