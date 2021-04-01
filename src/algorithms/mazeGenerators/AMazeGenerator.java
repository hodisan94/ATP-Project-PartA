package algorithms.mazeGenerators;

public abstract class AMazeGenerator implements IMazeGenerator{

    public abstract Maze generate(int rows, int cols);

    /**
     * @param rows is the number of the maze rows
     * @param cols is the number of the maze columns
     * @return a long number that represent in milliseconds the run time that took to the generate function
     */
    @Override
    public long measureAlgorithmTimeMillis(int rows, int cols) {
        long startTime = System.currentTimeMillis();
        generate(rows,cols);
        long stopTime = System.currentTimeMillis();
        return stopTime-startTime;
    }
}
