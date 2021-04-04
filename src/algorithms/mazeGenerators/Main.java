package algorithms.mazeGenerators;

public class Main {

    public static void main(String[] args) {
        SimpleMazeGenerator maze = new SimpleMazeGenerator();
        MyMazeGenerator mazemaze = new MyMazeGenerator();
        long time = mazemaze.measureAlgorithmTimeMillis(3,3);
        System.out.println(time);

    }
}
