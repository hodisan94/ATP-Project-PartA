package algorithms.maze3D;

public abstract class AMaze3DGenerator implements IMaze3DGenerator{

    public abstract Maze3D generate(int depth , int rows , int col);

    @Override
    public long measureAlgorithmTimeMillis(int depth, int row, int column) {
        long startTime = System.currentTimeMillis();
        generate(depth,row,column);
        long stopTime = System.currentTimeMillis();
        return stopTime-startTime;
    }


}
