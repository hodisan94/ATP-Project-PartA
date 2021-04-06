package algorithms.maze3D;

public class Maze3D {

    private Position3D StartPosition;
    private Position3D GoalPosition;
    private int[][][] Map;

    public Maze3D(int depth , int rows , int cols)
    {
        Map = new int[depth][rows][cols];
    }

    public Position3D getStartPosition() {
        return StartPosition;
    }

    public Position3D getGoalPosition() {
        return GoalPosition;
    }

    public int[][][] getMap() {
        return Map;
    }

}
