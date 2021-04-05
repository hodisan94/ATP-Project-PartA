package algorithms.search;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BestFirstSearch extends BreadthFirstSearch {

    public BestFirstSearch() {
        super();
        name = "BestFirstSearch";
        Comparator<AState> costComparator = new Comparator<AState>() {

            @Override
            public int compare(AState o1, AState o2) {
                if (o1.getStepCost() > o2.getStepCost())
                    return 1;
                else if (o1.getStepCost() < o2.getStepCost())
                    return -1;
                else
                    return 0;
            }
        };

        PriorityQueue<AState> openList = new PriorityQueue<AState>(costComparator);
    }

    public String getName(){
        return name;
    }

    public void addToOpenList(AState state) {
        openList.add(state);
    }

    /*@Override
    public boolean openListContains(AState state) {

        for (int i = 0; i < openList.size(); i++){
            if (((Queue<AState>)openList).get(i).equal(state))
                return true;
        }

        return false;
    }*/



}
