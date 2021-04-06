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

    public ASearchingAlgorithm() {
        this.stepsMap = new HashMap<>();
        this.numOfStates = 0;
        visited = new HashSet<>();
    }

    public Solution solve(ISearchable is) {
        start = is.getStartState();
        goal = is.getGoalState();
        stepsMap.put(start, null);
        addToOpenList(start);
        //visited.add(start);

        while (!openList.isEmpty()) {
            AState nextState = removeFromOpenList();
            numOfStates++;
            if (nextState.equals(goal)) {
                return findPath(nextState);
                //break; // WTF
            }
            List<AState> neighbors = is.getAllSuccessors(nextState);
            for (AState neighbor : neighbors) {
                if (visited.contains(neighbor))
                    continue;
                //continue;
                if (!openList.contains(neighbor)) {
                    stepsMap.put(neighbor, nextState);
                    addToOpenList(neighbor);
                }
            }
            visited.add(nextState);

        }
        return null;
    }

    public int getNumberOfNodesEvaluated () {
        return numOfStates;
    }

    public void setNumberOfNodes () {
        this.numOfStates++;
    }

    public abstract AState removeFromOpenList ();

    public abstract void addToOpenList (AState state);

    public abstract boolean openListContains(AState state);

    /*private boolean visitedContains(AState state) {
        Iterator<AState> stateIterator = visited.iterator();

        while (stateIterator.hasNext()){
            if(stateIterator.next().equal(state))
                return true;
        }

        return false;

        *//*if(visited.contains(state.hashCode()))
            return true;
        return false;*//*
    }*/


    public Solution findPath(AState goalState) {

            Stack<AState> path  = new Stack<>();

            AState cell = goalState;

            while(cell != null){
                path.push(cell);
                cell = stepsMap.get(cell);
            }


            //ArrayList<AState> path = new ArrayList<>();

            /*AState addToPath = removeFromOpenList();
            path.push(goalState);
            AState cell = removeFromOpenList();

            while (stepsMap.get(cell) != null) {
                if (cell.equal(stepsMap.get(addToPath))) {
                    path.push(cell);
                    addToPath = cell;
                }
                cell = removeFromOpenList();
            }*/

            return new Solution(path);

        }

    }

