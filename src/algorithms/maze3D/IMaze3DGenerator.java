package algorithms.maze3D;

public interface IMaze3DGenerator {

    public Maze3D generate(int depth, int row, int column);

    public long measureAlgorithmTimeMillis(int depth, int row, int column);
}
