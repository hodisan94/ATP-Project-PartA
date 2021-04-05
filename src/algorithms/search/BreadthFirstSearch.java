package algorithms.search;

import algorithms.mazeGenerators.Position;

import java.util.*;

public class BreadthFirstSearch extends ASearchingAlgorithm{

    public BreadthFirstSearch() {
        name = "BreadthFirstSearch";
        openList = new LinkedList<AState>();
    }

    @Override
    public String getName() {
        return this.name;
    }

 /*   @Override
    public Solution solve(ISearchable is) {
        start = is.getStartState();
        goal = is.getGoalState();

        //bfs(start, goal, is);

        Solution sol = new Solution();
        sol.setStates(findPath());

        return sol;
    }*/

    @Override
    public AState removeFromOpenList() {
        return ((Queue<AState>)openList).poll();
    }


    @Override
    public void addToOpenList(AState state) {
        openList.add(state);
    }


    @Override
    public boolean openListContains(AState state) {

        for (int i = 0; i < openList.size(); i++){
            if (((LinkedList<AState>)openList).get(i).equal(state))
                return true;
        }

        return false;
    }


/*    public void bfs(AState start, AState goal, ISearchable is){
        //Queue<AState> stateQueue = new LinkedList<>();
        //boolean[][] visited = new boolean[is.getRows()][is.getColumns()];

        *//*for (int i = 0; i < is.getRows(); i++ ){
            for (int j = 0; j < is.getColumns(); j++ ){
                visited[i][j] = false;
            }
        }*//*

        //stateQueue.add(start);
        stepsMap.put(start, null);
        openList.add(start);
        //visited[start.getRowPosition()][start.getColumnPosition()] = true;
        visited.add(start);


        while (!openList.isEmpty()){
            AState cell = openList.poll();
            setNumberOfNodes();

            if (cell.equal(goal)){
                break;
            }
            else{
                List<AState> neighbors = is.getAllSuccessors(cell);
                for (AState neighbor : neighbors) {
                    if(!visited.contains(neighbor))
                        continue;
                    if(!openList.contains(neighbor)){
                        stepsMap.put(neighbor, cell);
                        //neighbor.setStepCost();
                        openList.add(neighbor);
                    }

                    *//*if (visited[neighbor.getRowPosition()][neighbor.getColumnPosition()] == false){
                        visited[neighbor.getRowPosition()][neighbor.getColumnPosition()] = true;
                        stateQueue.add(neighbor);
                        openList.add(neighbor);
                    }*//*
                }
                visited.add(cell);
            }
        }
    }*/

}
