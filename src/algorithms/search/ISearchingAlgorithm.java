package algorithms.search;

public interface ISearchingAlgorithm {

    public MazeState search(ISearchingAlgorithm isa);

    public int getNumberOfVisitedNodes();
}
