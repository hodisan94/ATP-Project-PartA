package Server;

import algorithms.mazeGenerators.AMazeGenerator;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.mazeGenerators.SimpleMazeGenerator;
import algorithms.search.ASearchingAlgorithm;
import algorithms.search.BestFirstSearch;
import algorithms.search.BreadthFirstSearch;
import algorithms.search.DepthFirstSearch;

import java.io.*;
import java.util.Properties;

public class Configurations {

    private static Properties properties = new Properties();
    private static int threadPoolSize = 1; //defult;
    private static String mazeGeneratingAlgorithm;
    private static String mazeSearchingAlgorithm;
    private static InputStream input = null;

    private static Configurations single_instance = null;

    private Configurations(){
        try {
            String filename = "resources\\config.properties";
            //input = new FileInputStream("C:\\ATP-Project-PartA\\resources\\config.properties");
            input = new FileInputStream(filename);
            properties.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * @return its a singelton class so if the object exists already we will return him.
     */
    public static Configurations getInstance(){
        if (single_instance == null){
            single_instance = new Configurations();
        }
        return single_instance;
    }

    /**
     * @return the type of searching algorithm
     */
    public static ASearchingAlgorithm getMazeSearchingAlgorithm(){
        String maze_test = properties.getProperty("mazeGeneratingAlgorithm");
        String maze_search_name = properties.getProperty("mazeSearchingAlgorithm");
        if (maze_search_name.equals("BreadthFirstSearch")){
            return new BreadthFirstSearch();
        }
        else if (maze_search_name.equals("DepthFirstSearch")){
            return new DepthFirstSearch();
        }
        else
            return new BestFirstSearch(); // defult
    }

    /**
     * @return the maze algorithm that we will use
     */
    public static AMazeGenerator getMazeGeneratingAlgorithm() {
        String maze_generate_name = properties.getProperty("mazeGeneratingAlgorithm");
        if (maze_generate_name.equals("SimpleMazeGenerator")){
            return new SimpleMazeGenerator();
        }
        else
        return new MyMazeGenerator();
    }

    public static int getThreadPoolSize() {
        String thread_size = properties.getProperty("threadPoolSize");
        int size = Integer.valueOf(thread_size);
        if (size > 0 ){
            return size;
        }
        else
        return 1;//defult size of 1 thread.
    }
    public static void setProp(int size, String mazeGeneratingAlgorithm, String mazeSearchingAlgorithm) {
        OutputStream output = null;
        try {
            output = new FileOutputStream("src/config.properties");
            Properties prop = new Properties();
            prop.setProperty("threadPoolSize", Integer.toString(size));
            prop.setProperty("mazeGeneratingAlgorithm", mazeGeneratingAlgorithm);
            prop.setProperty("mazeSearchingAlgorithm", mazeSearchingAlgorithm);
            prop.store(output, null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }


}
