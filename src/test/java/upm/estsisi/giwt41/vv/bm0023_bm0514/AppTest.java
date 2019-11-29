package upm.estsisi.giwt41.vv.bm0023_bm0514;

import java.lang.reflect.Array;
import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import upm.estsisi.giwt41.vv.bm0023_bm0514.dijkstra.Dijkstra;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	int nVertices = 6;
    	Double[][] adjMatrix = new Double[][]{
						    		{0.0, 7.0, 5.0, 2.0, 0.0, 0.0},
									{7.0, 0.0, 0.0, 3.0, 0.0, 0.0},
									{5.0, 0.0, 0.0, 4.0, 6.0, 0.0},
									{2.0, 3.0, 4.0, 0.0, 0.0, 8.0},
									{0.0, 0.0, 6.0, 0.0, 0.0, 1.0},
									{0.0, 0.0, 0.0, 8.0, 1.0, 0.0}
    							};
    	int ini = 0;
    	int end = 0;
    	Dijkstra dijkstra = new Dijkstra(adjMatrix, nVertices);
    	double lenght = dijkstra.computeShortestPath(ini, end);
    	ArrayList<Integer> shortestpath = dijkstra.getPath(ini, end);
    	System.out.println(shortestpath.toString()+" :"+lenght);
        assertTrue( true );
    }
}
