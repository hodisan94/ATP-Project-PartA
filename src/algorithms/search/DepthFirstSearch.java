package algorithms.search;

import algorithms.mazeGenerators.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch extends ASearchingAlgorithm {

    public DepthFirstSearch() {
        name = "DepthFirstSearch";
        openList = new Stack<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Solution solve(ISearchable is) {
        start = is.getStartState();
        goal = is.getGoalState();
        //dfs(start, goal, is);

        return null;
    }

    @Override
    public AState removeFromOpenList() {
        return ((Stack<AState>)openList).pop();
    }

    @Override
    public void addToOpenList(AState state) {

        ((Stack<AState>)openList).push(state);
    }


/*    public void dfs(AState start, AState goal, ISearchable is) {
        Stack<AState> stack = new Stack<>();
        boolean[][] visited = new boolean[is.getRows()][is.getColumns()];

        for (int i = 0; i < is.getRows(); i++) {
            for (int j = 0; j < is.getColumns(); j++) {
                visited[i][j] = false;

                stack.push(start);
                while (!stack.isEmpty()) {
                    AState tmp = stack.pop();
                    visited[tmp.getRowPosition()][tmp.getColumnPosition()] = true;

                    if (tmp.getRowPosition() == goal.getRowPosition() && tmp.getColumnPosition() == goal.getColumnPosition()) {
                        goal.setCameFrom(new Position(tmp.getRowPosition(), tmp.getColumnPosition()));
                        break;
                    } else {
                        List<AState> neighbors = is.getAllSuccessors(tmp);
                        for (AState neighbor : neighbors) {
                            if (visited[neighbor.getRowPosition()][neighbor.getColumnPosition()] == false) {
                                visited[neighbor.getRowPosition()][neighbor.getColumnPosition()] = true;
                                stack.push(neighbor);
                                neighbor.setCameFrom(new Position(tmp.getRowPosition(), tmp.getColumnPosition()));

                            }
                        }
                    }
                }
            }
        }
    }*/
}
