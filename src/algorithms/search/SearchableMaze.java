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

        if(!(state instanceof MazeState))
            return null;

        MazeState mazeState = (MazeState)state;

        List<AState> successors = new ArrayList<>();

        if(this.myMaze.in_bound(mazeState.getRowPosition() - 1, mazeState.getColumnPosition() - 1) && this.myMaze.getMyMaze()[mazeState.getRowPosition()-1][mazeState.getColumnPosition()-1] != 1){
            if (this.myMaze.getMyMaze()[mazeState.getRowPosition()-1][mazeState.getColumnPosition()] == 0 ||this.myMaze.getMyMaze()[mazeState.getRowPosition()][mazeState.getColumnPosition()-1] == 0 )
            successors.add(new MazeState(15, new Position(mazeState.getRowPosition() - 1, mazeState.getColumnPosition() - 1), new Position(mazeState.getPosition())));
        }

        else if(this.myMaze.in_bound(mazeState.getRowPosition() - 1, mazeState.getColumnPosition()) && this.myMaze.getMyMaze()[mazeState.getRowPosition()-1][mazeState.getColumnPosition()] != 1){
            successors.add(new MazeState(10, new Position(mazeState.getRowPosition() - 1, mazeState.getColumnPosition()), new Position(mazeState.getPosition())));
        }

        else if(this.myMaze.in_bound(mazeState.getRowPosition() - 1, mazeState.getColumnPosition() + 1) && this.myMaze.getMyMaze()[mazeState.getRowPosition()-1][mazeState.getColumnPosition()+1] != 1){
            if (this.myMaze.getMyMaze()[mazeState.getRowPosition()-1][mazeState.getColumnPosition()] == 0 ||this.myMaze.getMyMaze()[mazeState.getRowPosition()][mazeState.getColumnPosition()+1] == 0 )
                successors.add(new MazeState(15, new Position(mazeState.getRowPosition() - 1, mazeState.getColumnPosition() + 1), new Position(mazeState.getPosition())));
        }

        else if(this.myMaze.in_bound(mazeState.getRowPosition(), mazeState.getColumnPosition() - 1) && this.myMaze.getMyMaze()[mazeState.getRowPosition()][mazeState.getColumnPosition()-1] != 1){
            successors.add(new MazeState(10, new Position(mazeState.getRowPosition(), mazeState.getColumnPosition() - 1), new Position(mazeState.getPosition())));
        }

        else if(this.myMaze.in_bound(mazeState.getRowPosition(), mazeState.getColumnPosition() + 1) && this.myMaze.getMyMaze()[mazeState.getRowPosition()][mazeState.getColumnPosition()+1] != 1){
            successors.add(new MazeState(10, new Position(mazeState.getRowPosition(), mazeState.getColumnPosition() + 1), new Position(mazeState.getPosition())));
        }

        else if(this.myMaze.in_bound(mazeState.getRowPosition() + 1, mazeState.getColumnPosition() - 1) && this.myMaze.getMyMaze()[mazeState.getRowPosition()+1][mazeState.getColumnPosition()-1] != 1){
            if (this.myMaze.getMyMaze()[mazeState.getRowPosition()+1][mazeState.getColumnPosition()] == 0 ||this.myMaze.getMyMaze()[mazeState.getRowPosition()][mazeState.getColumnPosition()-1] == 0 )
                successors.add(new MazeState(15, new Position(mazeState.getRowPosition() + 1, mazeState.getColumnPosition() - 1), new Position(mazeState.getPosition())));
        }

        else if(this.myMaze.in_bound(mazeState.getRowPosition() + 1, mazeState.getColumnPosition()) && this.myMaze.getMyMaze()[mazeState.getRowPosition()+1][mazeState.getColumnPosition()] != 1){
            successors.add(new MazeState(10, new Position(mazeState.getRowPosition() + 1, mazeState.getColumnPosition()), new Position(mazeState.getPosition())));
        }

        else if(this.myMaze.in_bound(mazeState.getRowPosition() + 1, mazeState.getColumnPosition() + 1) && this.myMaze.getMyMaze()[mazeState.getRowPosition()+1][mazeState.getColumnPosition()+1] != 1){
            if (this.myMaze.getMyMaze()[mazeState.getRowPosition()+1][mazeState.getColumnPosition()] == 0 ||this.myMaze.getMyMaze()[mazeState.getRowPosition()][mazeState.getColumnPosition()+1] == 0 )
                successors.add(new MazeState(15, new Position(mazeState.getRowPosition() + 1, mazeState.getColumnPosition() + 1), new Position(mazeState.getPosition())));
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
