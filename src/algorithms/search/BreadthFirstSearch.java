package algorithms.search;

import algorithms.mazeGenerators.Position;

import java.util.*;

public class BreadthFirstSearch extends ASearchingAlgorithm{

    public BreadthFirstSearch() {
        name = "BreadthFirstSearch";
        openList = new LinkedList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }



    @Override
    public AState removeFromOpenList() {
        return ((Queue<AState>)openList).poll();
    }


    @Override
    public void addToOpenList(AState state) {
        openList.add(state);
    }




}
