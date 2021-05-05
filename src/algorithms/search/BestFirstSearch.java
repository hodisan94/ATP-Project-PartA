package algorithms.search;

import java.util.Comparator;
import java.util.PriorityQueue;


public class BestFirstSearch extends BreadthFirstSearch {

    /**
     * A constructor method
     */
    public BestFirstSearch() {
        super();
        name = "BestFirstSearch";

        Comparator<AState> costComparator = new Comparator<AState>() {

            /**
             * @param o1
             * @param o2
             * @return 1 if o1's stepCost is bigger than o2's stepCost, return -1 if o1's stepCost is smaller than o2's stepCost and 0 if they have the same stepCost
             */
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

        openList = new PriorityQueue<>(costComparator);
    }

    /**
     * @return the name of the solver algorithm
     */
    public String getName() {
        return name;
    }

    /**
     * A method that add a new element to openList
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
        return new BestFirstSearch();
    }
}
