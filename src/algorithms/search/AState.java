package algorithms.search;

public abstract class AState {

    private int stepCost;

    public AState(int stepCost) {
        this.stepCost = stepCost;
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
