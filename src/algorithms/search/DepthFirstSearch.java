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
        ((Stack<AState>)openList).push(state);
    }




}
