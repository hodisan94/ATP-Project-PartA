package algorithms.search;

import algorithms.mazeGenerators.Position;

import java.util.ArrayList;
import java.util.Objects;

public class MazeState extends AState {

    private Position position;

    public MazeState(int stepCost, Position positionState) {
        super(stepCost);
        this.position = new Position(positionState);
    }

    public MazeState(Position position){
        this.position = new Position(position);
    }

    public Position getPosition() {
        return position;
    }


    @Override
    public boolean equals(Object obj) {
        if(obj instanceof MazeState) {
            MazeState mazeState = (MazeState) obj;
            return position.equals(mazeState.position);
        }
        return false;
    }

    @Override
    public int hashCode(){
        return position.toString().hashCode();
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
