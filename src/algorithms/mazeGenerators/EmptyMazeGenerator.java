package algorithms.mazeGenerators;

public class EmptyMazeGenerator extends AMazeGenerator{
    @Override
    public Maze generate(int rows, int cols) {
        Maze myMaze = new Maze(rows, cols);
        myMaze.setMyMaze(0);


        //yuval
        return myMaze;
    }
}
