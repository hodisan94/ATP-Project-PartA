package algorithms.search;

import algorithms.mazeGenerators.Position;

public class MazeState extends AState {

    private Position position;


    public MazeState(int stepCost, Position positionState) {
        super(stepCost);
        this.position = new Position(positionState);
    }

    public Position getPosition() {
        return position;
    }
}
