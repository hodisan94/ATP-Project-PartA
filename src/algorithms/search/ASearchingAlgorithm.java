package algorithms.search;

import java.util.ArrayList;
import java.util.PriorityQueue;

public abstract class ASearchingAlgorithm implements ISearchingAlgorithm{
    private int numOfStates;
    protected AState start;
    protected AState goal;
    protected String name;
    protected PriorityQueue<AState> openList;

    public ASearchingAlgorithm() {
        this.numOfStates = 0;
    }

    public abstract Solution solve(ISearchable is);

    public int getNumberOfNodesEvaluated(){
        return numOfStates;
    }

    public void setNumberOfNodes(){
        this.numOfStates++;
    }

    public PriorityQueue<AState> getOpenList(){
        return openList;
    }

    public abstract ArrayList<AState> findPath();

}
