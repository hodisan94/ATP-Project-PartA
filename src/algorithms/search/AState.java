package algorithms.search;

import algorithms.mazeGenerators.Position;

import java.io.Serializable;

public abstract class AState implements Serializable {
    private int stepCost;

    /**
     * A constructor
     * @param stepCost is the cost of the new state
     */
    public AState(int stepCost) {
        this.stepCost = stepCost;
    }

    /**
     * A constructor
     */
    public AState() {
        this.stepCost = 0;
    }

    /**
     * @return the cost of the state
     */
    public int getStepCost() {
        return stepCost;
    }

    /**
     * @param stepCost is the cost to set of
     */
    public void setStepCost(int stepCost) {
        this.stepCost = stepCost;
    }

    /**
     * An abstract method
     * @param obj is an object to compare to
     * @return true if obj and the state are equals anf false if not
     */
    @Override
    public abstract boolean equals(Object obj);

    /**
     * @return the state's hash code
     */
    @Override
    public abstract int hashCode();

    /**
     * @return the state as a string
     */
    @Override
    public abstract String toString();


    }


