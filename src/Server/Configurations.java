package Server;

import algorithms.mazeGenerators.AMazeGenerator;
import algorithms.mazeGenerators.EmptyMazeGenerator;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.mazeGenerators.SimpleMazeGenerator;
import algorithms.search.ASearchingAlgorithm;
import algorithms.search.BestFirstSearch;
import algorithms.search.BreadthFirstSearch;
import algorithms.search.DepthFirstSearch;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
            String filename = "\\resources\\config.properties";
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
        if (maze_search_name.equals("BreadthFirstSearch")) {
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
        FileOutputStream output = null;

        try {
            output = new FileOutputStream("/config.properties");
            Properties prop = new Properties();
            prop.setProperty("threadPoolSize", Integer.toString(size));
            prop.setProperty("mazeGeneratingAlgorithm", mazeGeneratingAlgorithm);
            prop.setProperty("mazeSearchingAlgorithm", mazeSearchingAlgorithm);
            prop.store(output, (String)null);
        } catch (Exception var13) {
            System.out.println(var13.getMessage());
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException var12) {
                    System.out.println(var12.getMessage());
                }
            }

        }
    }


    public Object[] LoadProperties(){
        try{
            FileInputStream inputStream = new FileInputStream("resources/config.properties");

            Object[] var5;
            try{
                Properties prop = new Properties();
                prop.load(inputStream);
                String[] propArr = new String[]{prop.getProperty("threadPoolSize"), prop.getProperty("mazeGeneratingAlgorithm"), prop.getProperty("mazeSearchingAlgorithm")};
                Object[] objArr = new Object[3];

                objArr[0] = Integer.parseInt(propArr[0]);

                if(propArr[1].equals("EmptyMazeGenerator"))
                    objArr[1] = new EmptyMazeGenerator();
                else if(propArr[1].equals("SimpleMazeGenerator"))
                    objArr[1] = new SimpleMazeGenerator();
                else if(propArr[1].equals("MyMazeGenerator"))
                    objArr[1] = new MyMazeGenerator();

                if(propArr[2].equals("BestFirstSearch"))
                    objArr[2] = new BestFirstSearch();
                else if(propArr[2].equals("BreadthFirstSearch"))
                    objArr[2] = new BreadthFirstSearch();
                else if(propArr[2].equals("DepthFirstSearch"))
                    objArr[2] = new DepthFirstSearch();

                var5 = objArr;

            }catch (Throwable var7){
                try{
                    inputStream.close();
                }catch (Throwable var6){
                    var7.addSuppressed(var6);
                }
                throw var7;
            }

            inputStream.close();
            return var5;


        }catch (IOException e){
            e.printStackTrace();
            return null;
        }

    }

}