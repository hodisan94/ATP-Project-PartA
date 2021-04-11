package algorithms.search;

import java.util.Stack;

public class DepthFirstSearch extends ASearchingAlgorithm {

    public DepthFirstSearch() {
        name = "DepthFirstSearch";
        openList = new Stack<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public AState removeFromOpenList() {
        return ((Stack<AState>)openList).pop();
    }

    @Override
    public void addToOpenList(AState state) {
        if (state == null)
            throw new IllegalArgumentException("State cannot be null");
        ((Stack<AState>)openList).push(state);
    }




}
