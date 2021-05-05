package algorithms.search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

public class DepthFirstSearch extends ASearchingAlgorithm {

    /**
     * A constructor
     */
    public DepthFirstSearch() {
        name = "DepthFirstSearch";
        openList = new ArrayDeque<>();
    }

    /**
     * @return the name of the solver algorithm
     */
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public AState removeFromOpenList() {
        return  ((ArrayDeque<AState>)openList).removeFirst();

    }

    @Override
    public void addToOpenList(AState state) {
        if (state == null)
            throw new IllegalArgumentException("State cannot be null");
        ((ArrayDeque<AState>)openList).addFirst(state);
    }

    @Override
    public Object copyalgo() {
        return new DepthFirstSearch();
    }
}
