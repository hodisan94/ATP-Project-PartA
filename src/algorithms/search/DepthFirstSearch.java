package algorithms.search;

import java.util.ArrayDeque;

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

    /**
     * A method that removes an element from openList
     * @return the removed element
     */
    @Override
    public AState removeFromOpenList() {
        return  ((ArrayDeque<AState>)openList).removeFirst();
    }

    /**
     * An abstract method that adds a new element to openList
     * @param state is the element to add to the openList
     */
    @Override
    public void addToOpenList(AState state) {
        if (state == null)
            throw new IllegalArgumentException("State cannot be null");
        ((ArrayDeque<AState>)openList).addFirst(state);
    }




}
