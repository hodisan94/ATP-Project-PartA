package algorithms.search;

public interface ISearchingAlgorithm {

    public Solution solve(ISearchable is);

    public int getNumberOfVisitedNodes();
}
