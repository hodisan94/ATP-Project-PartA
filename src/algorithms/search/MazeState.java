package algorithms.search;

import algorithms.mazeGenerators.Position;


public class MazeState extends AState {

    private Position position;

    /**
     * A constructor
     * @param stepCost
     * @param positionState
     */
    public MazeState(int stepCost, Position positionState) {
        super(stepCost);
        this.position = new Position(positionState);
    }

    /**
     * A constructor
     * @param position the new position
     */
    public MazeState(Position position){
        this.position = new Position(position);
    }

    /**
     * @return the position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * @param obj is an object to compare to
     * @return true if obj and the MazeState are equals anf false if not
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof MazeState) {
            MazeState mazeState = (MazeState) obj;
            return position.equals(mazeState.position);
        }
        return false;
    }

    /**
     * @return the mazeState's hash code
     */
    @Override
    public int hashCode(){
        return position.toString().hashCode();
    }

    /**
     * @return the row of the mazeState
     */
    public int getRowPosition(){
        return this.position.getRowIndex();
    }

    /**
     * @return the column of the mazeState
     */
    public int getColumnPosition(){
        return this.position.getColumnIndex();
    }

    /**
     * @return the state as a string
     */
    @Override
    public String toString() {
        return this.position.toString();
    }

}
