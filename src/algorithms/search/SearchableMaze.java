package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;
import java.util.List;

public class SearchableMaze implements ISearchable {

    private Maze myMaze;

    /**
     * A constructor
     * @param myMaze is the new maze
     */
    public SearchableMaze(Maze myMaze) {
        this.myMaze = myMaze;
    }

    /**
     * @return the start state of the maze
     */
    @Override
    public AState getStartState() {
        return new MazeState(myMaze.getStartPosition());
    }


    /**
     * @return the goal state of the maze
     */
    @Override
    public AState getGoalState() {
        return new MazeState(myMaze.getGoalPosition());
    }


    /**
     * @param state
     * @return a list of all the successors' state
     */
    @Override
    public List<AState> getAllSuccessors(AState state){

        if(!(state instanceof MazeState))
            return null;

        MazeState mazeState = (MazeState)state;

        List<AState> successors = new ArrayList<>();

        if(this.myMaze.in_bound(mazeState.getRowPosition() - 1, mazeState.getColumnPosition()) && this.myMaze.getMyMaze()[mazeState.getRowPosition()-1][mazeState.getColumnPosition()] != 1){
            successors.add(new MazeState(mazeState.getStepCost() + 10, new Position(mazeState.getRowPosition() - 1, mazeState.getColumnPosition())));
        }

        if(this.myMaze.in_bound(mazeState.getRowPosition(), mazeState.getColumnPosition() + 1) && this.myMaze.getMyMaze()[mazeState.getRowPosition()][mazeState.getColumnPosition()+1] != 1){
            successors.add(new MazeState(mazeState.getStepCost() + 10, new Position(mazeState.getRowPosition(), mazeState.getColumnPosition() + 1)));
        }

        if(this.myMaze.in_bound(mazeState.getRowPosition() + 1, mazeState.getColumnPosition()) && this.myMaze.getMyMaze()[mazeState.getRowPosition()+1][mazeState.getColumnPosition()] != 1){
            successors.add(new MazeState(mazeState.getStepCost() + 10, new Position(mazeState.getRowPosition() + 1, mazeState.getColumnPosition())));
        }

        if(this.myMaze.in_bound(mazeState.getRowPosition(), mazeState.getColumnPosition() - 1) && this.myMaze.getMyMaze()[mazeState.getRowPosition()][mazeState.getColumnPosition()-1] != 1){
            successors.add(new MazeState(mazeState.getStepCost() + 10, new Position(mazeState.getRowPosition(), mazeState.getColumnPosition() - 1)));
        }

        if(this.myMaze.in_bound(mazeState.getRowPosition() - 1, mazeState.getColumnPosition() - 1) && this.myMaze.getMyMaze()[mazeState.getRowPosition()-1][mazeState.getColumnPosition()-1] != 1){
            if (this.myMaze.getMyMaze()[mazeState.getRowPosition()-1][mazeState.getColumnPosition()] == 0 ||this.myMaze.getMyMaze()[mazeState.getRowPosition()][mazeState.getColumnPosition()-1] == 0 )
            successors.add(new MazeState(mazeState.getStepCost() + 15, new Position(mazeState.getRowPosition() - 1, mazeState.getColumnPosition() - 1)));
        }

        if(this.myMaze.in_bound(mazeState.getRowPosition() - 1, mazeState.getColumnPosition() + 1) && this.myMaze.getMyMaze()[mazeState.getRowPosition()-1][mazeState.getColumnPosition()+1] != 1){
            if (this.myMaze.getMyMaze()[mazeState.getRowPosition()-1][mazeState.getColumnPosition()] == 0 ||this.myMaze.getMyMaze()[mazeState.getRowPosition()][mazeState.getColumnPosition()+1] == 0 )
                successors.add(new MazeState(mazeState.getStepCost() + 15, new Position(mazeState.getRowPosition() - 1, mazeState.getColumnPosition() + 1)));
        }

        if(this.myMaze.in_bound(mazeState.getRowPosition() + 1, mazeState.getColumnPosition() + 1) && this.myMaze.getMyMaze()[mazeState.getRowPosition()+1][mazeState.getColumnPosition()+1] != 1){
            if (this.myMaze.getMyMaze()[mazeState.getRowPosition()+1][mazeState.getColumnPosition()] == 0 ||this.myMaze.getMyMaze()[mazeState.getRowPosition()][mazeState.getColumnPosition()+1] == 0 )
                successors.add(new MazeState(mazeState.getStepCost() + 15, new Position(mazeState.getRowPosition() + 1, mazeState.getColumnPosition() + 1)));
        }

        if(this.myMaze.in_bound(mazeState.getRowPosition() + 1, mazeState.getColumnPosition() - 1) && this.myMaze.getMyMaze()[mazeState.getRowPosition()+1][mazeState.getColumnPosition()-1] != 1){
            if (this.myMaze.getMyMaze()[mazeState.getRowPosition()+1][mazeState.getColumnPosition()] == 0 ||this.myMaze.getMyMaze()[mazeState.getRowPosition()][mazeState.getColumnPosition()-1] == 0 )
                successors.add(new MazeState(mazeState.getStepCost() + 15, new Position(mazeState.getRowPosition() + 1, mazeState.getColumnPosition() - 1)));
        }

        return successors;
    }


    public int getRows() {
        return this.myMaze.getRows();
    }


    public int getColumns() {
        return this.myMaze.getColumns();
    }
}
