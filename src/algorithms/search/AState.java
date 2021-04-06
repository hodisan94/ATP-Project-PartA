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

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract int hashCode();

    /*@Override
    public int compareTo(Object obj) {

        if(!(obj instanceof AState))
            return 0;

        AState state = (AState)obj;
        if (this.stepCost > state.getStepCost())
            return 1;
        else if (this.stepCost < state.getStepCost())
            return -1;
        else
            return 0;

    }*/

    public abstract String toString();

    public int compareTo(Object o) {
        if (!(o instanceof AState))
            return 0;
        AState aState = (AState) o;
        return Double.compare(aState.stepCost, this.stepCost);


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
}
