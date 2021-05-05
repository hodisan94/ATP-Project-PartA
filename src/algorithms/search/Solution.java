package algorithms.search;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

public class Solution implements Serializable {

    private ArrayList<AState> states;

    /**
     * A constructor
     * @param path is the path solution
     */
    public Solution(Stack<AState> path)
    {
        this.states = new ArrayList<>();
        this.setStates(path);
    }

    /**
     * @param arrayList is a stuck with the states in the s
     */
    public void setStates(Stack<AState> arrayList){
        while (!arrayList.isEmpty())
            this.states.add(arrayList.pop());
    }


    /**
     * @return an arrayList of the path
     */
    public ArrayList<AState> getSolutionPath(){
        return states;
    }

}
