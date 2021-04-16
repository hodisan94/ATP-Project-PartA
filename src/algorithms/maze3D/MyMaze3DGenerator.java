package algorithms.maze3D;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyMaze3DGenerator extends AMaze3DGenerator{


    @Override
    public Maze3D generate(int depth, int rows, int col) {

        Maze3D myMaze = new Maze3D(depth,rows,col);
        myMaze.setMyMaze3D(1);

        Position3D initail_cell = new Position3D(myMaze.getStartPosition().getDepthIndex() , myMaze.getStartPosition().getRowIndex(),myMaze.getStartPosition().getColumnIndex());

        List<Position3D> myList = new ArrayList<>();

        myList.add(initail_cell);

        while (!myList.isEmpty()) {
            Random rd = new Random();
            int rdNeighbour = rd.nextInt(myList.size());
            Position3D current = myList.get(rdNeighbour);
            myList.remove(rdNeighbour);
            if (myMaze.in_bound3D(current.getDepthIndex(), current.getRowIndex() + 2, current.getColumnIndex())) {
                if (myMaze.getMap()[current.getDepthIndex()][current.getRowIndex() + 2][current.getColumnIndex()] != 0) {

                    myMaze.setMazeBlockZero3D(current.getDepthIndex(), current.getRowIndex() + 1, current.getColumnIndex());
                    myMaze.setMazeBlockZero3D(current.getDepthIndex(), current.getRowIndex() + 2, current.getColumnIndex());

                    Position3D neighbour = new Position3D(current.getDepthIndex(), current.getRowIndex() + 2, current.getColumnIndex());

                    if (!myList.contains(neighbour)) {
                        myList.add(neighbour);
                    }
                }
            }

            if (myMaze.in_bound3D(current.getDepthIndex(), current.getRowIndex() - 2, current.getColumnIndex())) {
                if (myMaze.getMap()[current.getDepthIndex()][current.getRowIndex() - 2][current.getColumnIndex()] != 0) {

                    myMaze.setMazeBlockZero3D(current.getDepthIndex(), current.getRowIndex() - 1, current.getColumnIndex());
                    myMaze.setMazeBlockZero3D(current.getDepthIndex(), current.getRowIndex() - 2, current.getColumnIndex());

                    Position3D neighbour = new Position3D(current.getDepthIndex(), current.getRowIndex() - 2, current.getColumnIndex());

                    if (!myList.contains(neighbour)) {
                        myList.add(neighbour);
                    }
                }
            }

            if (myMaze.in_bound3D(current.getDepthIndex(), current.getRowIndex(), current.getColumnIndex() + 2)) {
                if (myMaze.getMap()[current.getDepthIndex()][current.getRowIndex()][current.getColumnIndex() + 2] != 0) {

                    myMaze.setMazeBlockZero3D(current.getDepthIndex(), current.getRowIndex(), current.getColumnIndex() + 1);
                    myMaze.setMazeBlockZero3D(current.getDepthIndex(), current.getRowIndex(), current.getColumnIndex() + 2);

                    Position3D neighbour = new Position3D(current.getDepthIndex(), current.getRowIndex(), current.getColumnIndex() + 2);

                    if (!myList.contains(neighbour)) {
                        myList.add(neighbour);
                    }
                }
            }

            if (myMaze.in_bound3D(current.getDepthIndex(), current.getRowIndex(), current.getColumnIndex() - 2)) {
                if (myMaze.getMap()[current.getDepthIndex()][current.getRowIndex()][current.getColumnIndex() - 2] != 0) {

                    myMaze.setMazeBlockZero3D(current.getDepthIndex(), current.getRowIndex(), current.getColumnIndex() - 1);
                    myMaze.setMazeBlockZero3D(current.getDepthIndex(), current.getRowIndex(), current.getColumnIndex() - 2);

                    Position3D neighbour = new Position3D(current.getDepthIndex(), current.getRowIndex(), current.getColumnIndex() - 2);

                    if (!myList.contains(neighbour)) {
                        myList.add(neighbour);
                    }
                }
            }

            if (myMaze.in_bound3D(current.getDepthIndex() + 2, current.getRowIndex(), current.getColumnIndex())) {
                if (myMaze.getMap()[current.getDepthIndex() + 2][current.getRowIndex()][current.getColumnIndex()] != 0) {

                    myMaze.setMazeBlockZero3D(current.getDepthIndex() + 1, current.getRowIndex(), current.getColumnIndex());
                    myMaze.setMazeBlockZero3D(current.getDepthIndex() + 2, current.getRowIndex(), current.getColumnIndex());

                    Position3D neighbour = new Position3D(current.getDepthIndex() + 2, current.getRowIndex(), current.getColumnIndex());

                    if (!myList.contains(neighbour)) {
                        myList.add(neighbour);
                    }
                }
            }

            if (myMaze.in_bound3D(current.getDepthIndex() - 2, current.getRowIndex(), current.getColumnIndex())) {
                if (myMaze.getMap()[current.getDepthIndex() - 2][current.getRowIndex()][current.getColumnIndex()] != 0) {

                    myMaze.setMazeBlockZero3D(current.getDepthIndex() - 1, current.getRowIndex(), current.getColumnIndex());
                    myMaze.setMazeBlockZero3D(current.getDepthIndex() - 2, current.getRowIndex(), current.getColumnIndex());

                    Position3D neighbour = new Position3D(current.getDepthIndex() - 2, current.getRowIndex(), current.getColumnIndex());

                    if (!myList.contains(neighbour)) {
                        myList.add(neighbour);
                    }
                }
            }
        }

            if ((myMaze.getRows() <= 3 || myMaze.getColumns() <= 3 || myMaze.getDepth() <=3 )) {
                myMaze.setMazeBlockZero3D(myMaze.getGoalPosition().getDepthIndex(),myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex());

                if ((myMaze.in_bound3D(myMaze.getGoalPosition().getDepthIndex(),myMaze.getGoalPosition().getRowIndex()+1,myMaze.getGoalPosition().getColumnIndex())))
                    myMaze.setMazeBlockZero3D(myMaze.getGoalPosition().getDepthIndex(),myMaze.getGoalPosition().getRowIndex()+1,myMaze.getGoalPosition().getColumnIndex());

                else if ((myMaze.in_bound3D(myMaze.getGoalPosition().getDepthIndex(),myMaze.getGoalPosition().getRowIndex()-1,myMaze.getGoalPosition().getColumnIndex())))
                    myMaze.setMazeBlockZero3D(myMaze.getGoalPosition().getDepthIndex(),myMaze.getGoalPosition().getRowIndex()-1,myMaze.getGoalPosition().getColumnIndex());

                if ((myMaze.in_bound3D(myMaze.getGoalPosition().getDepthIndex(),myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex()+1)))
                    myMaze.setMazeBlockZero3D(myMaze.getGoalPosition().getDepthIndex(),myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex()+1);

                else if ((myMaze.in_bound3D(myMaze.getGoalPosition().getDepthIndex(),myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex()-1)))
                    myMaze.setMazeBlockZero3D(myMaze.getGoalPosition().getDepthIndex(),myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex()-1);

                if ((myMaze.in_bound3D(myMaze.getGoalPosition().getDepthIndex()+1,myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex())))
                    myMaze.setMazeBlockZero3D(myMaze.getGoalPosition().getDepthIndex()+1,myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex());

                else if ((myMaze.in_bound3D(myMaze.getGoalPosition().getDepthIndex()-1,myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex())))
                    myMaze.setMazeBlockZero3D(myMaze.getGoalPosition().getDepthIndex()-1,myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex());
                if (myMaze.in_bound3D(myMaze.getGoalPosition().getDepthIndex(),myMaze.getGoalPosition().getRowIndex()-1,myMaze.getGoalPosition().getColumnIndex()-1))
                    myMaze.setMazeBlockZero3D(myMaze.getGoalPosition().getDepthIndex(),myMaze.getGoalPosition().getRowIndex()-1,myMaze.getGoalPosition().getColumnIndex()-1);
                if (myMaze.in_bound3D(myMaze.getGoalPosition().getDepthIndex(),myMaze.getGoalPosition().getRowIndex()-1,myMaze.getGoalPosition().getColumnIndex()+1))
                    myMaze.setMazeBlockZero3D(myMaze.getGoalPosition().getDepthIndex(),myMaze.getGoalPosition().getRowIndex()-1,myMaze.getGoalPosition().getColumnIndex()+1);
                if (myMaze.in_bound3D(myMaze.getGoalPosition().getDepthIndex(),myMaze.getGoalPosition().getRowIndex()+1,myMaze.getGoalPosition().getColumnIndex()-1))
                    myMaze.setMazeBlockZero3D(myMaze.getGoalPosition().getDepthIndex(),myMaze.getGoalPosition().getRowIndex()+1,myMaze.getGoalPosition().getColumnIndex()-1);
                if (myMaze.in_bound3D(myMaze.getGoalPosition().getDepthIndex(),myMaze.getGoalPosition().getRowIndex()+1,myMaze.getGoalPosition().getColumnIndex()+1))
                    myMaze.setMazeBlockZero3D(myMaze.getGoalPosition().getDepthIndex(),myMaze.getGoalPosition().getRowIndex()+1,myMaze.getGoalPosition().getColumnIndex()+1);
                if (myMaze.in_bound3D(myMaze.getGoalPosition().getDepthIndex()-1,myMaze.getGoalPosition().getRowIndex()-1,myMaze.getGoalPosition().getColumnIndex()))
                    myMaze.setMazeBlockZero3D(myMaze.getGoalPosition().getDepthIndex()-1,myMaze.getGoalPosition().getRowIndex()-1,myMaze.getGoalPosition().getColumnIndex());
                if (myMaze.in_bound3D(myMaze.getGoalPosition().getDepthIndex()+1,myMaze.getGoalPosition().getRowIndex()-1,myMaze.getGoalPosition().getColumnIndex()))
                    myMaze.setMazeBlockZero3D(myMaze.getGoalPosition().getDepthIndex()+1,myMaze.getGoalPosition().getRowIndex()-1,myMaze.getGoalPosition().getColumnIndex());
                if (myMaze.in_bound3D(myMaze.getGoalPosition().getDepthIndex()+1,myMaze.getGoalPosition().getRowIndex()+1,myMaze.getGoalPosition().getColumnIndex()))
                    myMaze.setMazeBlockZero3D(myMaze.getGoalPosition().getDepthIndex()+1,myMaze.getGoalPosition().getRowIndex()+1,myMaze.getGoalPosition().getColumnIndex());
                if (myMaze.in_bound3D(myMaze.getGoalPosition().getDepthIndex()-1,myMaze.getGoalPosition().getRowIndex()+1,myMaze.getGoalPosition().getColumnIndex()))
                    myMaze.setMazeBlockZero3D(myMaze.getGoalPosition().getDepthIndex()-1,myMaze.getGoalPosition().getRowIndex()+1,myMaze.getGoalPosition().getColumnIndex());
                if (myMaze.in_bound3D(myMaze.getGoalPosition().getDepthIndex()-1,myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex()-1))
                    myMaze.setMazeBlockZero3D(myMaze.getGoalPosition().getDepthIndex()-1,myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex()-1);
                if (myMaze.in_bound3D(myMaze.getGoalPosition().getDepthIndex()+1,myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex()-1))
                    myMaze.setMazeBlockZero3D(myMaze.getGoalPosition().getDepthIndex()+1,myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex()-1);
                if (myMaze.in_bound3D(myMaze.getGoalPosition().getDepthIndex()-1,myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex()+1))
                    myMaze.setMazeBlockZero3D(myMaze.getGoalPosition().getDepthIndex()-1,myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex()+1);
                if (myMaze.in_bound3D(myMaze.getGoalPosition().getDepthIndex()+1,myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex()+1))
                    myMaze.setMazeBlockZero3D(myMaze.getGoalPosition().getDepthIndex()+1,myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex()+1);

                if ((myMaze.getRows() < 3 || myMaze.getColumns() < 3 || myMaze.getDepth() <3 )) {
                    if (myMaze.in_bound3D(myMaze.getStartPosition().getDepthIndex()-1,myMaze.getStartPosition().getRowIndex(),myMaze.getStartPosition().getColumnIndex()))
                        myMaze.setMazeBlockZero3D(myMaze.getStartPosition().getDepthIndex()-1,myMaze.getStartPosition().getRowIndex(),myMaze.getStartPosition().getColumnIndex());
                    if (myMaze.in_bound3D(myMaze.getStartPosition().getDepthIndex()+1,myMaze.getStartPosition().getRowIndex(),myMaze.getStartPosition().getColumnIndex()))
                        myMaze.setMazeBlockZero3D(myMaze.getStartPosition().getDepthIndex()+1,myMaze.getStartPosition().getRowIndex(),myMaze.getStartPosition().getColumnIndex());
                    if (myMaze.in_bound3D(myMaze.getStartPosition().getDepthIndex(),myMaze.getStartPosition().getRowIndex()+1,myMaze.getStartPosition().getColumnIndex()))
                        myMaze.setMazeBlockZero3D(myMaze.getStartPosition().getDepthIndex(),myMaze.getStartPosition().getRowIndex()+1,myMaze.getStartPosition().getColumnIndex());
                    if (myMaze.in_bound3D(myMaze.getStartPosition().getDepthIndex()+1,myMaze.getStartPosition().getRowIndex()-1,myMaze.getStartPosition().getColumnIndex()))
                        myMaze.setMazeBlockZero3D(myMaze.getStartPosition().getDepthIndex()+1,myMaze.getStartPosition().getRowIndex()-1,myMaze.getStartPosition().getColumnIndex());
                    if (myMaze.in_bound3D(myMaze.getStartPosition().getDepthIndex()+1,myMaze.getStartPosition().getRowIndex(),myMaze.getStartPosition().getColumnIndex()+1))
                        myMaze.setMazeBlockZero3D(myMaze.getStartPosition().getDepthIndex()+1,myMaze.getStartPosition().getRowIndex(),myMaze.getStartPosition().getColumnIndex()+1);
                    if (myMaze.in_bound3D(myMaze.getStartPosition().getDepthIndex()+1,myMaze.getStartPosition().getRowIndex(),myMaze.getStartPosition().getColumnIndex()-1))
                        myMaze.setMazeBlockZero3D(myMaze.getStartPosition().getDepthIndex()+1,myMaze.getStartPosition().getRowIndex(),myMaze.getStartPosition().getColumnIndex()-1);
                }

            }

            if (myMaze.getMap()[myMaze.getGoalPosition().getDepthIndex()][myMaze.getGoalPosition().getRowIndex()][myMaze.getGoalPosition().getColumnIndex()]==1) {
                myMaze.setMazeBlockZero3D(myMaze.getGoalPosition().getDepthIndex(),myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex());

                if (myMaze.in_bound3D(myMaze.getGoalPosition().getDepthIndex()+1,myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex()))
                    myMaze.setMazeBlockZero3D(myMaze.getGoalPosition().getDepthIndex()+1,myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex());

                 if ((myMaze.in_bound3D(myMaze.getGoalPosition().getDepthIndex()-1,myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex())))
                    myMaze.setMazeBlockZero3D(myMaze.getGoalPosition().getDepthIndex()-1,myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex());

                if ((myMaze.in_bound3D(myMaze.getGoalPosition().getDepthIndex(),myMaze.getGoalPosition().getRowIndex()+1,myMaze.getGoalPosition().getColumnIndex())))
                    myMaze.setMazeBlockZero3D(myMaze.getGoalPosition().getDepthIndex(),myMaze.getGoalPosition().getRowIndex()+1,myMaze.getGoalPosition().getColumnIndex());

                 if ((myMaze.in_bound3D(myMaze.getGoalPosition().getDepthIndex(),myMaze.getGoalPosition().getRowIndex()-1,myMaze.getGoalPosition().getColumnIndex())))
                    myMaze.setMazeBlockZero3D(myMaze.getGoalPosition().getDepthIndex(),myMaze.getGoalPosition().getRowIndex()-1,myMaze.getGoalPosition().getColumnIndex());

                if ((myMaze.in_bound3D(myMaze.getGoalPosition().getDepthIndex(),myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex()+1)))
                    myMaze.setMazeBlockZero3D(myMaze.getGoalPosition().getDepthIndex(),myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex()+1);

                 if ((myMaze.in_bound3D(myMaze.getGoalPosition().getDepthIndex(),myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex()-1)))
                    myMaze.setMazeBlockZero3D(myMaze.getGoalPosition().getDepthIndex(),myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex()-1);

                else {
                    // else ifim
                    if ((myMaze.in_bound3D(myMaze.getGoalPosition().getDepthIndex(),myMaze.getGoalPosition().getRowIndex()-1,myMaze.getGoalPosition().getColumnIndex()-1) && myMaze.getMap()[myMaze.getGoalPosition().getDepthIndex()][myMaze.getGoalPosition().getRowIndex()-1][myMaze.getGoalPosition().getColumnIndex()-1]==0)||(myMaze.in_bound3D(myMaze.getGoalPosition().getDepthIndex(),myMaze.getGoalPosition().getRowIndex()+1,myMaze.getGoalPosition().getColumnIndex()-1) && myMaze.getMap()[myMaze.getGoalPosition().getDepthIndex()][myMaze.getGoalPosition().getRowIndex()+1][myMaze.getGoalPosition().getColumnIndex()-1]==0)) {
                        myMaze.setMazeBlockZero3D(myMaze.getGoalPosition().getDepthIndex(),myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex()-1);
                    }

                    if ((myMaze.in_bound3D(myMaze.getGoalPosition().getDepthIndex(),myMaze.getGoalPosition().getRowIndex()-1,myMaze.getGoalPosition().getColumnIndex()+1) && myMaze.getMap()[myMaze.getGoalPosition().getDepthIndex()][myMaze.getGoalPosition().getRowIndex()-1][myMaze.getGoalPosition().getColumnIndex()+1]==0)||(myMaze.in_bound3D(myMaze.getGoalPosition().getDepthIndex(),myMaze.getGoalPosition().getRowIndex()+1,myMaze.getGoalPosition().getColumnIndex()+1) && myMaze.getMap()[myMaze.getGoalPosition().getDepthIndex()][myMaze.getGoalPosition().getRowIndex()+1][myMaze.getGoalPosition().getColumnIndex()+1]==0)) {
                        myMaze.setMazeBlockZero3D(myMaze.getGoalPosition().getDepthIndex(),myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex()+1);
                    }

                    if ((myMaze.in_bound3D(myMaze.getGoalPosition().getDepthIndex()+1,myMaze.getGoalPosition().getRowIndex()-1,myMaze.getGoalPosition().getColumnIndex()) && myMaze.getMap()[myMaze.getGoalPosition().getDepthIndex()+1][myMaze.getGoalPosition().getRowIndex()-1][myMaze.getGoalPosition().getColumnIndex()]==0)||(myMaze.in_bound3D(myMaze.getGoalPosition().getDepthIndex()+1,myMaze.getGoalPosition().getRowIndex()+1,myMaze.getGoalPosition().getColumnIndex()) && myMaze.getMap()[myMaze.getGoalPosition().getDepthIndex()+1][myMaze.getGoalPosition().getRowIndex()+1][myMaze.getGoalPosition().getColumnIndex()]==0)) {
                        myMaze.setMazeBlockZero3D(myMaze.getGoalPosition().getDepthIndex()+1,myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex());
                    }

                    if ((myMaze.in_bound3D(myMaze.getGoalPosition().getDepthIndex()-1,myMaze.getGoalPosition().getRowIndex()-1,myMaze.getGoalPosition().getColumnIndex()) && myMaze.getMap()[myMaze.getGoalPosition().getDepthIndex()-1][myMaze.getGoalPosition().getRowIndex()-1][myMaze.getGoalPosition().getColumnIndex()]==0)||(myMaze.in_bound3D(myMaze.getGoalPosition().getDepthIndex()-1,myMaze.getGoalPosition().getRowIndex()+1,myMaze.getGoalPosition().getColumnIndex()) && myMaze.getMap()[myMaze.getGoalPosition().getDepthIndex()-1][myMaze.getGoalPosition().getRowIndex()+1][myMaze.getGoalPosition().getColumnIndex()]==0)) {
                        myMaze.setMazeBlockZero3D(myMaze.getGoalPosition().getDepthIndex()-1,myMaze.getGoalPosition().getRowIndex(),myMaze.getGoalPosition().getColumnIndex());
                    }


                }
            }

        return myMaze;
    }
}
