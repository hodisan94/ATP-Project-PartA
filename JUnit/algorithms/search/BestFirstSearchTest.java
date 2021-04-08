package algorithms.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestFirstSearchTest {
    private BestFirstSearch best = new BestFirstSearch();

    @Test
    public void testGetName() {
        assertEquals("BestFirstSearch", best.getName());
    }

    @Test
    public void testAddToOpenList() throws Exception {
        //best.addToOpenList(null);

    }


}