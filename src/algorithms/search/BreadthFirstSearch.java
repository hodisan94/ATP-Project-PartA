package algorithms.search;

import algorithms.mazeGenerators.Position;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch extends ASearchingAlgorithm{
    private Queue<Position> positionQueue;
    private boolean[][] visited;

    public BreadthFirstSearch(int rows, int cols){
        positionQueue = new LinkedList<>();
        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++ ){
            for (int j = 0; j < cols; j++ ){
                visited[i][j] = false;
            }
        }
    }


    @Override
    public MazeState search(ISearchingAlgorithm isa) {
        return null;
    }

    @Override
    public int getNumberOfVisitedNodes() {
        return 0;
    }
}
