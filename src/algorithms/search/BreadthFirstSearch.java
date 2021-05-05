package algorithms.search;


import java.util.*;

public class BreadthFirstSearch extends ASearchingAlgorithm{

    /**
     * A constructor
     */
    public BreadthFirstSearch() {
        name = "BreadthFirstSearch";
        openList = new LinkedList<>();
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
        return ((Queue<AState>)openList).poll();
    }


    /**
     * An abstract method that adds a new element to openList
     * @param state is the element to add to the openList
     */
    @Override
    public void addToOpenList(AState state) throws Exception {
        if (state == null)
            throw new IllegalArgumentException("State cannot be null");

        openList.add(state);
    }

    @Override
    public Object copyalgo() {
        return new BreadthFirstSearch();
    }
}
