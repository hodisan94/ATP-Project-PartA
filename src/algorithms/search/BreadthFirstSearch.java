package algorithms.search;

import algorithms.mazeGenerators.Position;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch extends ASearchingAlgorithm{

    public BreadthFirstSearch() {
        name = "BreadthFirstSearch";
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Solution solve(ISearchable is) {
        start = is.getStartState();
        goal = is.getGoalState();
        bfs(start, goal, is);




        return null;
    }


    public void bfs(AState start, AState goal, ISearchable is){
        Queue<AState> stateQueue = new LinkedList<>();
        boolean[][] visited = new boolean[is.getRows()][is.getColumns()];

        for (int i = 0; i < is.getRows(); i++ ){
            for (int j = 0; j < is.getColumns(); j++ ){
                visited[i][j] = false;
            }
        }

        stateQueue.add(start);
        visited[start.getRowPosition()][start.getColumnPosition()] = true;

        while (!stateQueue.isEmpty()){
            AState cell = stateQueue.poll();

            if (cell.equal(goal)){
                break;
            }
            else{
                List<AState> neighbors = is.getAllSuccessors(cell);
                for (AState neighbor : neighbors) {
                    if (visited[neighbor.getRowPosition()][neighbor.getColumnPosition()] == false){
                        visited[neighbor.getRowPosition()][neighbor.getColumnPosition()] = true;
                        stateQueue.add(neighbor);
                    }
                }
            }
        }
    }

}
