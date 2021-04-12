package test;

import algorithms.maze3D.IMaze3DGenerator;
import algorithms.maze3D.Maze3D;
import algorithms.maze3D.MyMaze3DGenerator;
import algorithms.maze3D.SearchableMaze3D;
import algorithms.search.*;

import java.util.ArrayList;

public class RunSearchOnMaze3D {
    public static void main(String[] args) throws Exception {
        IMaze3DGenerator mg = new MyMaze3DGenerator();
            Maze3D maze = mg.generate(2,2 ,2);
        SearchableMaze3D searchableMaze = new SearchableMaze3D(maze);
        solveProblem(searchableMaze, new BreadthFirstSearch());
        solveProblem(searchableMaze, new DepthFirstSearch());
        solveProblem(searchableMaze, new BestFirstSearch());
    }
    private static void solveProblem(ISearchable domain, ISearchingAlgorithm searcher) throws Exception {
        //Solve a searching problem with a searcher
        long startTime = System.currentTimeMillis();
        Solution solution = searcher.solve(domain);
        long stopTime = System.currentTimeMillis();


        System.out.println(String.format("'%s' algorithm - nodes evaluated: %s", searcher.getName(), searcher.getNumberOfNodesEvaluated()));

        //Printing Solution Path
        System.out.println("Solution path:");
        ArrayList<AState> solutionPath = solution.getSolutionPath();
        for (int i = 0; i < solutionPath.size(); i++) {
            System.out.println(String.format("%s. %s",i,solutionPath.get(i)));
        }
        System.out.println(stopTime-startTime);
    }
}
