package algorithms.search;

import algorithms.mazeGenerators.Position;

public abstract class AState {
    private int stepCost;

    public AState(int stepCost) {
        this.stepCost = stepCost;
    }
    public AState() {
        this.stepCost = 0;
    }

    public int getStepCost() {
        return stepCost;
    }

    public void setStepCost(int stepCost) {
        this.stepCost = stepCost;
    }

    public abstract boolean equal(Object obj);

    public abstract String toString();






    //public abstract int getRowPosition();

    //public abstract int getColumnPosition();



   /* public void setCameFrom(Position cameFrom) {
        this.cameFrom = cameFrom;
    }

    public Position getCameFrom() {
        return cameFrom;
    }
    public int getStepCost() {
        return stepCost;
    }

    public void setStepCost(int stepCost) {
        this.stepCost = stepCost;
    }*/
}
