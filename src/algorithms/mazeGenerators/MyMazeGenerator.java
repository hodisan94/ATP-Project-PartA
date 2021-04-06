package algorithms.mazeGenerators;

import java.util.*;

public class MyMazeGenerator extends AMazeGenerator{
    @Override
    public Maze generate(int rows, int cols) {
        Maze myMaze = new Maze(rows,cols);
        myMaze.setMyMaze(1);
        Position initial_cell = new Position(myMaze.getStartPosition().getRowIndex(),myMaze.getStartPosition().getColumnIndex());
        List<Position> myList = new ArrayList<>();
        myList.add(initial_cell);
        while (!myList.isEmpty())
        {
            Random rd = new Random();
            int rdNeighbour = rd.nextInt(myList.size());
            Position current = myList.get(rdNeighbour);
            myList.remove(rdNeighbour);
            if(myMaze.in_bound(current.getRowIndex()+2,current.getColumnIndex()))
            {
                if (myMaze.getMyMaze()[current.getRowIndex()+2][current.getColumnIndex()] != 0)
                {
                    myMaze.setMazeBlockZero(current.getRowIndex()+1,current.getColumnIndex());
                    myMaze.setMazeBlockZero(current.getRowIndex()+2,current.getColumnIndex());
                    Position neighbour = new Position(current.getRowIndex()+2,current.getColumnIndex());
                    if (!myList.contains(neighbour)){
                        myList.add(neighbour);
                    }

                }
            }
            if(myMaze.in_bound(current.getRowIndex()-2,current.getColumnIndex()))
            {
                if (myMaze.getMyMaze()[current.getRowIndex()-2][current.getColumnIndex()] != 0)
                {
                    myMaze.setMazeBlockZero(current.getRowIndex()-1,current.getColumnIndex());
                    myMaze.setMazeBlockZero(current.getRowIndex()-2,current.getColumnIndex());
                    Position neighbour = new Position(current.getRowIndex()-2,current.getColumnIndex());
                    if (!myList.contains(neighbour)){
                        myList.add(neighbour);
                    }
                }

            }
            if(myMaze.in_bound(current.getRowIndex(),current.getColumnIndex()+2))
            {
                if (myMaze.getMyMaze()[current.getRowIndex()][current.getColumnIndex()+2] != 0)
                {
                    myMaze.setMazeBlockZero(current.getRowIndex(),current.getColumnIndex()+1);
                    myMaze.setMazeBlockZero(current.getRowIndex(),current.getColumnIndex()+2);
                    Position neighbour = new Position(current.getRowIndex(),current.getColumnIndex()+2);
                    if (!myList.contains(neighbour)){
                        myList.add(neighbour);
                    }
                }
            }
            if(myMaze.in_bound(current.getRowIndex(),current.getColumnIndex()-2))
            {
                if (myMaze.getMyMaze()[current.getRowIndex()][current.getColumnIndex()-2] != 0)
                {
                    myMaze.setMazeBlockZero(current.getRowIndex(),current.getColumnIndex()-1);
                    myMaze.setMazeBlockZero(current.getRowIndex(),current.getColumnIndex()-2);
                    Position neighbour = new Position(current.getRowIndex(),current.getColumnIndex()-2);
                    if (!myList.contains(neighbour)){
                        myList.add(neighbour);
                    }
                }
            }
        }
        if (myMaze.getMyMaze()[myMaze.getGoalPosition().getRowIndex()][myMaze.getGoalPosition().getColumnIndex()] == 1)
        {
            myMaze.setMazeBlockZero(myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex());
            if (myMaze.in_bound(myMaze.getGoalPosition().getRowIndex()+1,myMaze.getGoalPosition().getColumnIndex()) && myMaze.getMyMaze()[myMaze.getGoalPosition().getRowIndex()+1][myMaze.getGoalPosition().getColumnIndex()] == 0)
                myMaze.setMazeBlockZero(myMaze.getGoalPosition().getRowIndex()+1,myMaze.getGoalPosition().getColumnIndex());
            else if (myMaze.in_bound(myMaze.getGoalPosition().getRowIndex()-1,myMaze.getGoalPosition().getColumnIndex()) && myMaze.getMyMaze()[myMaze.getGoalPosition().getRowIndex()-1][myMaze.getGoalPosition().getColumnIndex()] == 0)
                myMaze.setMazeBlockZero(myMaze.getGoalPosition().getRowIndex()-1,myMaze.getGoalPosition().getColumnIndex());
            else if (myMaze.in_bound(myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex()+1) && myMaze.getMyMaze()[myMaze.getGoalPosition().getRowIndex()][myMaze.getGoalPosition().getColumnIndex()+1] == 0)
                myMaze.setMazeBlockZero(myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex()+1);
            else if (myMaze.in_bound(myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex()-1) && myMaze.getMyMaze()[myMaze.getGoalPosition().getRowIndex()][myMaze.getGoalPosition().getColumnIndex()-1] == 0)
                myMaze.setMazeBlockZero(myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex()-1);
            else{
                if ((myMaze.in_bound(myMaze.getGoalPosition().getRowIndex()-1,myMaze.getGoalPosition().getColumnIndex()-1) && myMaze.getMyMaze()[myMaze.getGoalPosition().getRowIndex()-1][myMaze.getGoalPosition().getColumnIndex()-1] == 0)|| myMaze.in_bound(myMaze.getGoalPosition().getRowIndex()+1,myMaze.getGoalPosition().getColumnIndex()-1) && myMaze.getMyMaze()[myMaze.getGoalPosition().getRowIndex()+1][myMaze.getGoalPosition().getColumnIndex()-1] == 0)
                {
                    myMaze.setMazeBlockZero(myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex()-1);
                }
                else if ((myMaze.in_bound(myMaze.getGoalPosition().getRowIndex()-1,myMaze.getGoalPosition().getColumnIndex()+1) && myMaze.getMyMaze()[myMaze.getGoalPosition().getRowIndex()-1][myMaze.getGoalPosition().getColumnIndex()+1] == 0) || myMaze.in_bound(myMaze.getGoalPosition().getRowIndex()+1,myMaze.getGoalPosition().getColumnIndex()+1) && myMaze.getMyMaze()[myMaze.getGoalPosition().getRowIndex()+1][myMaze.getGoalPosition().getColumnIndex()+1] == 0 )
                {
                    myMaze.setMazeBlockZero(myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex()+1);

                }
            }
        }
        //myMaze.printMaze();
        //myMaze.print();

        return myMaze;
    }


    public Maze generate1(int rows, int cols) {
        Maze myMaze = new Maze(rows,cols);
        myMaze.setMyMaze(0);





        return myMaze;
    }

}
