package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.List;

public class SearchableMaze implements ISearchable {

    private Maze myMaze;

    public SearchableMaze(Maze myMaze) {
        this.myMaze = myMaze;
    }

    @Override
    public AState getStartState() {
        return new MazeState(myMaze.getStartPosition());
    }

    @Override
    public AState getGoalState() {
        return new MazeState(myMaze.getGoalPosition());
    }

    @Override
    public List<AState> getAllSuccessors(AState state) {
        return null;
    }
}
