package algorithms.search;

import algorithms.mazeGenerators.Position;

import java.util.ArrayList;
import java.util.Objects;

public class MazeState extends AState {

    //private Position cameFrom;
    private Position position;


    public MazeState(int stepCost, Position positionState) {
        super(stepCost);
        //this.cameFrom = new Position(cameFrom);
        this.position = new Position(positionState);
    }

    public MazeState(Position position){
        this.position = new Position(position);
    }

    public Position getPosition() {
        return position;
    }

/*    public AState getCameFrom(){
        return cameFrom;
    }*/

    @Override
    public boolean equal(Object obj) {
        if(obj instanceof MazeState) {
            MazeState mazeState = (MazeState) obj;
            return position.equals(mazeState.position);
        }
        return false;
    }

    @Override
    public int hashCode(){
        return position.hashCode();
    }

    public int getRowPosition(){
        return this.position.getRowIndex();
    }


    public int getColumnPosition(){
        return this.position.getColumnIndex();
    }


    @Override
    public String toString() {
        return this.position.toString();
    }

}
