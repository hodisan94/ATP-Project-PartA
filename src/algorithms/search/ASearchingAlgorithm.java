package algorithms.search;

public abstract class ASearchingAlgorithm implements ISearchingAlgorithm{
    private int numOfStates;
    protected AState start;
    protected AState goal;



    public ASearchingAlgorithm() {
        this.numOfStates = 0;
    }

    public abstract Solution solve(ISearchable is);

    public int getNumberOfVisitedNodes(){
        return numOfStates;
    }
}
