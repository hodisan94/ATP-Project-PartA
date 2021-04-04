package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;
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
    public List<AState> getAllSuccessors(AState state){
        List<AState> successors = new ArrayList<>();

        if(this.myMaze.in_bound(state.getRowPosition() - 1, state.getColumnPosition() - 1) && this.myMaze.getMyMaze()[state.getRowPosition()-1][state.getColumnPosition()-1] != 1){
            if (this.myMaze.getMyMaze()[state.getRowPosition()-1][state.getColumnPosition()] == 0 ||this.myMaze.getMyMaze()[state.getRowPosition()][state.getColumnPosition()-1] == 0 )
            successors.add(new MazeState(15, new Position(state.getRowPosition() - 1, state.getColumnPosition() - 1)));
        }

        else if(this.myMaze.in_bound(state.getRowPosition() - 1, state.getColumnPosition()) && this.myMaze.getMyMaze()[state.getRowPosition()-1][state.getColumnPosition()] != 1){
            successors.add(new MazeState(10, new Position(state.getRowPosition() - 1, state.getColumnPosition())));
        }

        else if(this.myMaze.in_bound(state.getRowPosition() - 1, state.getColumnPosition() + 1) && this.myMaze.getMyMaze()[state.getRowPosition()-1][state.getColumnPosition()+1] != 1){
            if (this.myMaze.getMyMaze()[state.getRowPosition()-1][state.getColumnPosition()] == 0 ||this.myMaze.getMyMaze()[state.getRowPosition()][state.getColumnPosition()+1] == 0 )
                successors.add(new MazeState(15, new Position(state.getRowPosition() - 1, state.getColumnPosition() + 1)));
        }

        else if(this.myMaze.in_bound(state.getRowPosition(), state.getColumnPosition() - 1) && this.myMaze.getMyMaze()[state.getRowPosition()][state.getColumnPosition()-1] != 1){
            successors.add(new MazeState(10, new Position(state.getRowPosition(), state.getColumnPosition() - 1)));
        }

        else if(this.myMaze.in_bound(state.getRowPosition(), state.getColumnPosition() + 1) && this.myMaze.getMyMaze()[state.getRowPosition()][state.getColumnPosition()+1] != 1){
            successors.add(new MazeState(10, new Position(state.getRowPosition(), state.getColumnPosition() + 1)));
        }

        else if(this.myMaze.in_bound(state.getRowPosition() + 1, state.getColumnPosition() - 1) && this.myMaze.getMyMaze()[state.getRowPosition()+1][state.getColumnPosition()-1] != 1){
            if (this.myMaze.getMyMaze()[state.getRowPosition()+1][state.getColumnPosition()] == 0 ||this.myMaze.getMyMaze()[state.getRowPosition()][state.getColumnPosition()-1] == 0 )
                successors.add(new MazeState(15, new Position(state.getRowPosition() + 1, state.getColumnPosition() - 1)));
        }

        else if(this.myMaze.in_bound(state.getRowPosition() + 1, state.getColumnPosition()) && this.myMaze.getMyMaze()[state.getRowPosition()+1][state.getColumnPosition()] != 1){
            successors.add(new MazeState(10, new Position(state.getRowPosition() + 1, state.getColumnPosition())));
        }

        else if(this.myMaze.in_bound(state.getRowPosition() + 1, state.getColumnPosition() + 1) && this.myMaze.getMyMaze()[state.getRowPosition()+1][state.getColumnPosition()+1] != 1){
            if (this.myMaze.getMyMaze()[state.getRowPosition()+1][state.getColumnPosition()] == 0 ||this.myMaze.getMyMaze()[state.getRowPosition()][state.getColumnPosition()+1] == 0 )
                successors.add(new MazeState(15, new Position(state.getRowPosition() + 1, state.getColumnPosition() + 1)));
        }

        return successors;
    }

    @Override
    public int getRows() {
        return this.myMaze.getRows();
    }

    @Override
    public int getColumns() {
        return this.myMaze.getColumns();
    }
}
