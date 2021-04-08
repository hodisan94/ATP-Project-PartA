package algorithms.maze3D;

import algorithms.search.AState;

public class Maze3DState extends AState {

    private Position3D position;

    /**
     * A constructor
     * @param stepCost
     * @param position
     */
    public Maze3DState(int stepCost, Position3D position) {
        super(stepCost);
        this.position = position;
    }

    /**
     * A constructor
     * @param position
     */
    public Maze3DState(Position3D position) {
        this.position = position;
    }

    /**
     * @param obj is an object to compare to
     * @return true if obj and the Maze3DState are equals anf false if not
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Maze3DState) {
            Maze3DState maze3DState = (Maze3DState) obj;
            return position.equals(maze3DState.position);
        }
        return false;
    }

    /**
     * @return the maze3DState's hash code
     */
    @Override
    public int hashCode() {
        return position.toString().hashCode();
    }

    /**
     * @return the state as a string
     */
    @Override
    public String toString() {
        return this.position.toString();
    }

    /**
     * @return the row of the maze3DState
     */
    public int getRow(){
        return position.getRowIndex();
    }

    /**
     * @return the column of the maze3DState
     */
    public int getColumn(){
        return position.getColumnIndex();
    }

    /**
     * @return the depth of the maze3DState
     */
    public int getDepth(){
        return position.getDepthIndex();
    }
}
