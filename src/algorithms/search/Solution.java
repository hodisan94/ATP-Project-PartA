package algorithms.search;


import java.util.ArrayList;

public class Solution {

    private ArrayList<AState> states;

    public void setStates(ArrayList<AState> arrayList){
        this.states = arrayList;
    }


    public ArrayList<AState> getSolutionPath(){
        return states;
    }

}
