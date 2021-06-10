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
    private static int threadPoolSize = 1;
    private static String mazeGeneratingAlgorithm;
    private static String mazeSearchingAlgorithm;
    private static InputStream input = null;

    private static Configurations single_instance = null;

    private Configurations() {
        try {
            String filename = "resources\\config.properties";
            //input = new FileInputStream("C:\\ATP-Project-PartA\\resources\\config.properties");
            input = new FileInputStream(filename);
            properties.load(input);
        } catch (FileNotFoundException var2) {
            var2.printStackTrace();
        } catch (IOException var3) {
            var3.printStackTrace();
        }
    }

    public static Configurations getInstance() {
        if (single_instance == null) {
            single_instance = new Configurations();
        }
        return single_instance;
    }

    public static ASearchingAlgorithm getMazeSearchingAlgorithm() {
        String maze_test = properties.getProperty("mazeGeneratingAlgorithm");
        String maze_search_name = properties.getProperty("mazeSearchingAlgorithm");
        if (maze_search_name.equals("BreadthFirstSearch")){
            return new BreadthFirstSearch();
        } else {
            return (ASearchingAlgorithm)(maze_search_name.equals("DepthFirstSearch") ? new DepthFirstSearch() : new BestFirstSearch());
        }
    }

    public static AMazeGenerator getMazeGeneratingAlgorithm() {
        String maze_generate_name = properties.getProperty("mazeGeneratingAlgorithm");
        return (AMazeGenerator)(maze_generate_name.equals("SimpleMazeGenerator") ? new SimpleMazeGenerator() : new MyMazeGenerator());
    }

    public static int getThreadPoolSize() {
        String thread_size = properties.getProperty("threadPoolSize");
        int size = Integer.valueOf(thread_size);
        return size > 0 ? size : 1;
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
