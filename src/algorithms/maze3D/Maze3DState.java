package algorithms.maze3D;

import algorithms.search.AState;
import algorithms.search.MazeState;

public class Maze3DState extends AState {

    private Position3D position;

    public Maze3DState(int stepCost, Position3D position) {
        super(stepCost);
        this.position = position;
    }

    public Maze3DState(Position3D position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Maze3DState) {
            Maze3DState maze3DState = (Maze3DState) obj;
            return position.equals(maze3DState.position);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return position.toString().hashCode();
    }

    @Override
    public String toString() {
        return this.position.toString();
    }
}
