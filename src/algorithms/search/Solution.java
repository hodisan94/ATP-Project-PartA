package algorithms.search;


import java.util.ArrayList;
import java.util.Stack;

public class Solution {

    private ArrayList<AState> states;

    public Solution(Stack<AState> path)
    {
        this.states = new ArrayList<>();
        this.setStates(path);
    }

    public void setStates(Stack<AState> arrayList){
        while (!arrayList.isEmpty())
        this.states.add(arrayList.pop());
    }


    public ArrayList<AState> getSolutionPath(){
        return states;
    }

}
