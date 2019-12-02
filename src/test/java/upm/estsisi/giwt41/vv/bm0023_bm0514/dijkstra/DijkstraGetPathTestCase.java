package upm.estsisi.giwt41.vv.bm0023_bm0514.dijkstra;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DijkstraGetPathTestCase {
	
	private static Double[][] matriz5x5;
	private Dijkstra dijkstra;
	
	@BeforeClass
	public static void inicializarVariables() {
		matriz5x5 = new Double[][]{
			{0.0, 7.0, 5.0, 2.0, 0.0, 0.0},
			{7.0, 0.0, 0.0, 3.0, 0.0, 0.0},
			{5.0, 0.0, 0.0, 4.0, 6.0, 0.0},
			{2.0, 3.0, 4.0, 0.0, 0.0, 8.0},
			{0.0, 0.0, 6.0, 0.0, 0.0, 1.0},
			{0.0, 0.0, 0.0, 8.0, 1.0, 0.0}
		};
	}
	
	@Before  
    public void setUp() {   
		dijkstra = new Dijkstra(matriz5x5, 5);
	}
	
	/*****************************  CAMINOS MÍNIMOS **********************************/
	@Test
	public void testCase1GetPath(){
		//Integer[] prev = new Integer[] {true, true, false, true, false, false};
		
		//dijkstra.setPrev(prev);

		ArrayList<Integer> resul = dijkstra.getPath(0, 4);
	
		assertTrue(resul == null);
	}
	
	@Test
	public void testCase2GetPath(){
		//Integer[] prev = new Integer[] {true, true, false, true, false, false};
		
		//dijkstra.setPrev(prev);
		dijkstra.setExec(true);
		
		ArrayList<Integer> path = dijkstra.getPath(0, 0);
		ArrayList<Integer> pathEsperado = new ArrayList<Integer>();
		pathEsperado.add(new Integer(0));
	
		assertTrue(path.equals(pathEsperado));
	}
	
	@Test
	public void testCase3GetPath(){
		Integer[] prev = new Integer[] {-1, 3, 0, 0, 2, 3};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);

		ArrayList<Integer> path = dijkstra.getPath(0, 5);
		ArrayList<Integer> pathEsperado = new ArrayList<Integer>();
		pathEsperado.add(new Integer(5));
		pathEsperado.add(new Integer(3));
		pathEsperado.add(new Integer(0));

	
		assertTrue(path.equals(pathEsperado));
	}
	/***************************** FIN CAMINOS MÍNIMOS **********************************/

}
