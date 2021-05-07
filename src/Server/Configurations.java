package Server;

import algorithms.search.ASearchingAlgorithm;
import algorithms.search.BreadthFirstSearch;

import java.io.InputStream;
import java.util.Properties;

public class Configurations {

    private static Properties properties = new Properties();
    private static int thread_num = 1; //defult;
    private static ASearchingAlgorithm algorithm = new BreadthFirstSearch();//defult
    private static InputStream input = null;

    private static Configurations single_instance = null;


    public static Configurations getInstance(){
        if (single_instance == null){
            single_instance = new Configurations();
        }
        return single_instance;
    }




}
