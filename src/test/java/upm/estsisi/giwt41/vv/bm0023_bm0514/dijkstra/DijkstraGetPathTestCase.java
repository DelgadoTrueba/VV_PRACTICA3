package upm.estsisi.giwt41.vv.bm0023_bm0514.dijkstra;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DijkstraGetPathTestCase {
	
	private static Double[][] matriz3x3;
	private static Double[][] matriz5x5;
	
	private Dijkstra dijkstra;
	private Dijkstra diklstraNentriesTres;
	
	@BeforeClass
	public static void inicializarVariables() {
		matriz5x5 = new Double[][]{
			{0.0, 7.0, 5.0, 2.0, 0.0},
			{7.0, 0.0, 0.0, 3.0, 0.0},
			{5.0, 0.0, 0.0, 4.0, 6.0},
			{2.0, 3.0, 4.0, 0.0, 0.0},
			{0.0, 0.0, 6.0, 0.0, 0.0},
		};
		
		matriz3x3 = new Double[][]{
			{0.0, 2.0, 0.0},
			{0.0, 0.0, 0.0},
			{0.0, 0.0, 0.0},
		};
		
	}
	
	@Before  
    public void setUp() {   
		dijkstra = new Dijkstra(matriz5x5, 5);
		diklstraNentriesTres = new Dijkstra(matriz3x3,3);
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
		Integer[] prev = new Integer[] {-1, 3, 0, 0, 2};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);

		ArrayList<Integer> path = dijkstra.getPath(0, 2);
		ArrayList<Integer> pathEsperado = new ArrayList<Integer>();
		pathEsperado.add(new Integer(2));
		pathEsperado.add(new Integer(0));

	
		assertTrue(path.equals(pathEsperado));
	}
	/***************************** FIN CAMINOS MÍNIMOS **********************************/

	/*****************************  CLASES DE EQUIVALENCIA **********************************/
	@Test(expected = Exception.class)
	public void testCase1EquivalenceClassShortestPath() {
		diklstraNentriesTres.computeShortestPath(0, 2);
		ArrayList<Integer> path = diklstraNentriesTres.getPath(0, 2);
	}
	
	@Test
	public void testCase2EquivalenceClassShortestPath() {
		diklstraNentriesTres.computeShortestPath(0, 1);
		ArrayList<Integer> path = diklstraNentriesTres.getPath(0, 1);
		ArrayList<Integer> pathEsperado = new ArrayList<Integer>();
		pathEsperado.add(new Integer(1));
		pathEsperado.add(new Integer(0));

	
		assertTrue(path.equals(pathEsperado));
	}
	
	@Test(expected = Exception.class)
	public void testCase4EquivalenceClassShortestPath() {
		diklstraNentriesTres.setExec(true);
		ArrayList<Integer> path = diklstraNentriesTres.getPath(null, -5);
	}
	
	@Test(expected = Exception.class)
	public void testCase5EquivalenceClassShortestPath() {
		diklstraNentriesTres.setExec(true);
		ArrayList<Integer> path = diklstraNentriesTres.getPath(-1, 10);
	}
	
	@Test(expected = Exception.class)
	public void testCase6EquivalenceClassShortestPath() {
		diklstraNentriesTres.setExec(true);
		ArrayList<Integer> path = diklstraNentriesTres.getPath(6, null);
	}
	
	/*****************************  FIN CLASES DE EQUIVALENCIA **********************************/
}
