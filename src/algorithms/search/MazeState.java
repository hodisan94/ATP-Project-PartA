package algorithms.search;

import algorithms.mazeGenerators.Position;

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
    public boolean equal(Object obj) {
        if(obj instanceof MazeState) {
            MazeState mazeState = (MazeState) obj;
            return position.compare(mazeState.position);
        }
        return false;
    }
}
