package algorithms.search;

import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

class BestFirstSearchTest {
    private BestFirstSearch best = new BestFirstSearch();

    @Test
    public void testGetName() throws Exception {
        assertEquals("BestFirstSearch", best.getName());
    }

    @Test
    public void testAddToOpenList() throws Exception {

        try{
            best.addToOpenList(null);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.toString());
        }

    }

    @Test
    public void testSolve() throws Exception {

        try{
            best.solve(null);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.toString());
        }

    }

}