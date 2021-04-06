package algorithms.maze3D;

import algorithms.search.AState;
import algorithms.search.ISearchable;

import java.util.List;


public class SearchableMaze3D implements ISearchable {

    private Maze3D maze3D;

    public SearchableMaze3D(Maze3D maze3D) {
        this.maze3D = maze3D;
    }

    @Override
    public AState getStartState() {
        return new Maze3DState(maze3D.getStartPosition());
    }

    @Override
    public AState getGoalState() {
        return new Maze3DState(maze3D.getGoalPosition());
    }

    @Override
    public List<AState> getAllSuccessors(AState state) {
        return null;
    }

    public int getRows() {
        return maze3D.getRows();
    }

    public int getColumns() {
        return maze3D.getColumns();
    }

    public int getDepth(){
        return maze3D.getDepth();
    }
}
