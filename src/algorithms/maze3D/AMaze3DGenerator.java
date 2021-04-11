package algorithms.maze3D;

public abstract class AMaze3DGenerator implements IMaze3DGenerator{

    public abstract Maze3D generate(int depth , int rows , int col);


    /**
     * @param depth is the number of the maze depth
     * @param row is the number of the maze rows
     * @param column is the number of the maze columns
     * @return a long number that represent the run time of the generate function in milliseconds
     */
    @Override
    public long measureAlgorithmTimeMillis(int depth, int row, int column) {
        if (depth < 2 || row < 2 || column < 2)
            throw new IllegalArgumentException("The maze3D cannot be smaller than 2*2*2");
        long startTime = System.currentTimeMillis();
        generate(depth,row,column);
        long stopTime = System.currentTimeMillis();
        return stopTime-startTime;
    }


}
