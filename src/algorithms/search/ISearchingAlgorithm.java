package algorithms.search;

public interface ISearchingAlgorithm {

    public Solution solve(ISearchable is) throws Exception;

    public int getNumberOfNodesEvaluated();

    public String getName();

    public Object copyalgo();

}
