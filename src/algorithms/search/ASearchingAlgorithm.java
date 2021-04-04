package algorithms.search;

import java.util.*;

public abstract class ASearchingAlgorithm implements ISearchingAlgorithm{
    private int numOfStates;
    protected AState start;
    protected AState goal;
    protected String name;
    protected Collection<AState> openList;
    protected Map<AState, AState> stepsMap;
    protected LinkedList<AState> visited;

    public ASearchingAlgorithm() {
        this.stepsMap = new HashMap<>();
        this.numOfStates = 0;
    }

    public abstract Solution solve(ISearchable is);

    public int getNumberOfNodesEvaluated(){
        return numOfStates;
    }

    public void setNumberOfNodes(){
        this.numOfStates++;
    }

    public abstract AState removeFromOpenList();

    public abstract void addToOpenList(AState state);


    public ArrayList<AState> findPath(){

        ArrayList<AState> path = new ArrayList<>();

        AState addToPath = openList.poll();
        path.add(addToPath);
        AState cell = openList.poll();

        while (stepsMap.get(cell) != null){
            if(cell.equal(stepsMap.get(addToPath))){
                path.add(0, cell);
                addToPath = cell;
            }
            cell = openList.poll();
        }

        return path;

    }


}
