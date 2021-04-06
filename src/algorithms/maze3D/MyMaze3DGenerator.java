package algorithms.maze3D;

import algorithms.mazeGenerators.Maze;

public class MyMaze3DGenerator extends AMaze3DGenerator{


    @Override
    public Maze3D generate(int depth, int rows, int col) {
        Maze3D myMaze = new Maze3D(depth,rows,col);
        myMaze.setMyMaze3D(1);
        myMaze.print();
        return myMaze;
    }
}
