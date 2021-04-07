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



    public abstract String toString();


    }


