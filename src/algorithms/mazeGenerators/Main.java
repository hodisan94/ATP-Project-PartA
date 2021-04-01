package algorithms.mazeGenerators;

public class Main {

    public static void main(String[] args) {
        SimpleMazeGenerator maze = new SimpleMazeGenerator();
        MyMazeGenerator mazemaze = new MyMazeGenerator();
        //mazemaze.measureAlgorithmTimeMillis(5,5);
        long time = mazemaze.measureAlgorithmTimeMillis(20,30);
        System.out.println(time);

        //maze.setMyMaze(1);
        //maze.printMaze();
        //hodisan was here
    }
}
