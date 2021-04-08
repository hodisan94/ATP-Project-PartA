package algorithms.search;

import algorithms.mazeGenerators.Position;

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
    public void addToOpenList(AState state) {
        openList.add(state);
    }




}
