package algorithms.maze3D;

import algorithms.search.AState;
import algorithms.search.ISearchable;

import java.util.ArrayList;
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

        if(!(state instanceof Maze3DState))
            return null;

        Maze3DState maze3DState = (Maze3DState)state;

        List<AState> successors = new ArrayList<>();

        if(maze3D.in_bound3D(maze3DState.getDepth() - 1 , maze3DState.getRow(), maze3DState.getColumn()) && this.maze3D.getMap()[maze3DState.getDepth() -1][maze3DState.getRow()][maze3DState.getColumn()] != 1){
            successors.add(new Maze3DState(maze3DState.getStepCost() + 10, new Position3D(maze3DState.getDepth() -1 , maze3DState.getRow(), maze3DState.getColumn())));
        }

        if(maze3D.in_bound3D(maze3DState.getDepth() , maze3DState.getRow() - 1, maze3DState.getColumn()) && this.maze3D.getMap()[maze3DState.getDepth()][maze3DState.getRow() - 1][maze3DState.getColumn()] != 1){
            successors.add(new Maze3DState(maze3DState.getStepCost() + 10, new Position3D(maze3DState.getDepth() , maze3DState.getRow() - 1, maze3DState.getColumn())));
        }

        if(maze3D.in_bound3D(maze3DState.getDepth(), maze3DState.getRow(), maze3DState.getColumn() - 1) && this.maze3D.getMap()[maze3DState.getDepth()][maze3DState.getRow()][maze3DState.getColumn() - 1] != 1){
            successors.add(new Maze3DState(maze3DState.getStepCost() + 10, new Position3D(maze3DState.getDepth(), maze3DState.getRow(), maze3DState.getColumn() - 1)));
        }

        if(maze3D.in_bound3D(maze3DState.getDepth() + 1 , maze3DState.getRow(), maze3DState.getColumn()) && this.maze3D.getMap()[maze3DState.getDepth() + 1][maze3DState.getRow()][maze3DState.getColumn()] != 1){
            successors.add(new Maze3DState(maze3DState.getStepCost() + 10, new Position3D(maze3DState.getDepth() + 1 , maze3DState.getRow(), maze3DState.getColumn())));
        }

        if(maze3D.in_bound3D(maze3DState.getDepth() , maze3DState.getRow() + 1, maze3DState.getColumn()) && this.maze3D.getMap()[maze3DState.getDepth()][maze3DState.getRow() + 1][maze3DState.getColumn()] != 1){
            successors.add(new Maze3DState(maze3DState.getStepCost() + 10, new Position3D(maze3DState.getDepth() , maze3DState.getRow() + 1, maze3DState.getColumn())));
        }

        if(maze3D.in_bound3D(maze3DState.getDepth(), maze3DState.getRow(), maze3DState.getColumn() + 1) && this.maze3D.getMap()[maze3DState.getDepth()][maze3DState.getRow()][maze3DState.getColumn() + 1] != 1){
            successors.add(new Maze3DState(maze3DState.getStepCost() + 10, new Position3D(maze3DState.getDepth(), maze3DState.getRow(), maze3DState.getColumn() + 1)));
        }

        return successors;
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
