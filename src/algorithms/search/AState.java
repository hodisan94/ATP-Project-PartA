package algorithms.search;

import algorithms.mazeGenerators.Position;

public abstract class AState {

    private int stepCost;
    private Position cameFrom;

    public AState(int stepCost, Position cameFrom) {

        this.stepCost = stepCost;
        this.cameFrom = cameFrom;
    }

    public AState(int stepCost) {

        this.stepCost = stepCost;
        this.cameFrom = null;
    }

    public AState(){
        this.stepCost = 0;
    }

    public int getStepCost() {
        return stepCost;
    }

    public void setStepCost(int stepCost) {
        this.stepCost = stepCost;
    }

    public abstract boolean equal(Object obj);

    public abstract int getRowPosition();

    public abstract int getColumnPosition();

    public abstract String toString();

}
