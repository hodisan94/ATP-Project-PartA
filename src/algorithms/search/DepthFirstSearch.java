package algorithms.search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

public class DepthFirstSearch extends ASearchingAlgorithm {

    public DepthFirstSearch() {
        name = "DepthFirstSearch";
        openList = new ArrayDeque<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public AState removeFromOpenList() {
        //AState aState = ((ArrayList<AState>)openList).get(0);
        return  ((ArrayDeque<AState>)openList).removeFirst();
        //return aState;
        //return ((Stack<AState>)openList).pop();
    }

    @Override
    public void addToOpenList(AState state) {
        if (state == null)
            throw new IllegalArgumentException("State cannot be null");
        ((ArrayDeque<AState>)openList).addFirst(state);
        //((Stack<AState>)openList).push(state);
    }




}
