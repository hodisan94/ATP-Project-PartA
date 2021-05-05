package algorithms.search;

import java.util.*;

public abstract class ASearchingAlgorithm implements ISearchingAlgorithm{
    private int numOfStates;
    protected AState start;
    protected AState goal;
    protected String name;
    protected Collection<AState> openList;
    protected Map<AState, AState> stepsMap;
    protected HashSet<AState> visited;

    /**
     * A constructor of searching algorithms
     */
    public ASearchingAlgorithm() {
        this.stepsMap = new HashMap<>();
        this.numOfStates = 0;
        visited = new HashSet<>();
    }

    /**
     * @param is is the searchable object
     * @return the solution of the searchable object
     */
    public Solution solve(ISearchable is) throws Exception {

        if(is == null)
            throw new IllegalArgumentException("ISearchable cannot be null");

        start = is.getStartState();
        goal = is.getGoalState();
        stepsMap.put(start, null);
        addToOpenList(start);

        while (!openList.isEmpty()) {
            AState nextState = removeFromOpenList();
            numOfStates++;

            if (nextState.equals(goal)) {
                return findPath(nextState);
            }

            List<AState> neighbors = is.getAllSuccessors(nextState);

            for (AState neighbor : neighbors) {

                if (visited.contains(neighbor))
                    continue;

                if (!openList.contains(neighbor)  ){//.contains(neighbor)) {
                    stepsMap.put(neighbor, nextState);
                    addToOpenList(neighbor);
                }
            }
            visited.add(nextState);
        }
        return null;
    }

    /**
     * @return the number of nodes that were evaluated
     */
    public int getNumberOfNodesEvaluated () {
        return numOfStates;
    }

    /**
     * The method is setting the value of numOfStates that were evaluated by plus 1
     */
    public void setNumberOfNodes () {
        this.numOfStates++;
    }

    /**
     * An abstract method that removes an element from openList
     * @return the removed element
     */
    public abstract AState removeFromOpenList ();

    /**
     * An abstract method that adds a new element to openList
     * @param state is the element to add to the openList
     */
    public abstract void addToOpenList (AState state) throws Exception;

   // public abstract Object copyalgo();


    /**
     * @param goalState is the last state of the path
     * @return the solution of the searchable object
     */
    public Solution findPath(AState goalState) {

            Stack<AState> path  = new Stack<>();

            AState cell = goalState;

            while(cell != null){
                path.push(cell);
                cell = stepsMap.get(cell);
            }

            return new Solution(path);

        }



    }

