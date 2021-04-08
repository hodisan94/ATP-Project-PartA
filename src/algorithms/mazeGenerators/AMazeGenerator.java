package algorithms.mazeGenerators;

public abstract class AMazeGenerator implements IMazeGenerator{

    public abstract Maze generate(int rows, int cols);

    /**
     * @param rows is the number of the maze rows
     * @param cols is the number of the maze columns
     * @return a long number that represent the run time of the generate function in milliseconds
     */
    @Override
    public long measureAlgorithmTimeMillis(int rows, int cols) {
        long startTime = System.currentTimeMillis();
        generate(rows,cols);
        long stopTime = System.currentTimeMillis();
        return stopTime-startTime;
    }
}
