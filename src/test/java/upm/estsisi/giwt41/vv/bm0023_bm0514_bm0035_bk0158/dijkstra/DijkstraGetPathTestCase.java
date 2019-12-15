package upm.estsisi.giwt41.vv.bm0023_bm0514_bm0035_bk0158.dijkstra;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import upm.estsisi.giwt41.vv.bm0023_bm0514_bm0035_bk0158.dijkstra.Dijkstra;

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
	public void testCase1EquivalenceClassGetPath() {
		diklstraNentriesTres.computeShortestPath(0, 2);
		ArrayList<Integer> path = diklstraNentriesTres.getPath(0, 2);
	}
	
	@Test
	public void testCase2EquivalenceClassGetPath() {
		diklstraNentriesTres.computeShortestPath(0, 1);
		ArrayList<Integer> path = diklstraNentriesTres.getPath(0, 1);
		ArrayList<Integer> pathEsperado = new ArrayList<Integer>();
		pathEsperado.add(new Integer(1));
		pathEsperado.add(new Integer(0));

	
		assertTrue(path.equals(pathEsperado));
	}
	
	@Test(expected = Exception.class)
	public void testCase4EquivalenceClassGetPath() {
		diklstraNentriesTres.setExec(true);
		ArrayList<Integer> path = diklstraNentriesTres.getPath(null, -5);
	}
	
	@Test(expected = Exception.class)
	public void testCase5EquivalenceClassGetPath() {
		diklstraNentriesTres.setExec(true);
		ArrayList<Integer> path = diklstraNentriesTres.getPath(-1, 10);
	}
	
	@Test(expected = Exception.class)
	public void testCase6EquivalenceClassGetPath() {
		diklstraNentriesTres.setExec(true);
		ArrayList<Integer> path = diklstraNentriesTres.getPath(6, null);
	}
	
	/*****************************  FIN CLASES DE EQUIVALENCIA **********************************/
	
	/***************************************** VALORES LÍMITES *****************************************/
	/*Debería dar un error pero no es así*/
	
	@Test(expected = Exception.class)
	public void testCase1LimitValuesGetPath() {
		dijkstra.setExec(true);
		ArrayList<Integer> path = dijkstra.getPath(-1, -1);
	}
	@Test(expected = Exception.class)
	public void testCase2LimitValuesGetPath() {
		dijkstra.setExec(true);
		ArrayList<Integer> path = dijkstra.getPath(-1, 0);
	}
	@Test(expected = Exception.class)
	public void testCase3LimitValuesGetPath() {
		dijkstra.setExec(true);
		ArrayList<Integer> path = dijkstra.getPath(-1, 1);
	}
	@Test(expected = Exception.class)
	public void testCase4LimitValuesGetPath() {
		dijkstra.setExec(true);
		ArrayList<Integer> path = dijkstra.getPath(-1, 2);
	}
	@Test(expected = Exception.class)
	public void testCase5LimitValuesGetPath() {
		dijkstra.setExec(true);
		ArrayList<Integer> path = dijkstra.getPath(-1, 3);
	}
	@Test(expected = Exception.class)
	public void testCase6LimitValuesGetPath() {
		dijkstra.setExec(true);
		ArrayList<Integer> path = dijkstra.getPath(-1, 4);
	}
	@Test(expected = Exception.class)
	public void testCase7LimitValuesGetPath() {
		dijkstra.setExec(true);
		ArrayList<Integer> path = dijkstra.getPath(-1, 5);
	}
	@Test(expected = Exception.class)
	public void testCase8LimitValuesGetPath() {
		
		Integer[] prev = new Integer[] {-1, 3, 0, 0, 2};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(0, -1);
	}
	@Test
	public void testCase9LimitValuesGetPath() {
		
		Integer[] prev = new Integer[] {-1, 3, 0, 0, 2};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(0, 0);
		
		ArrayList<Integer> pathEsperado = new ArrayList<Integer>();
		pathEsperado.add(new Integer(0));
		

	
		assertTrue(path.equals(pathEsperado));
	}
	@Test
	public void testCase10LimitValuesGetPath() {
		
		Integer[] prev = new Integer[] {-1, 3, 0, 0, 2};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(0, 1);
		
		ArrayList<Integer> pathEsperado = new ArrayList<Integer>();
		pathEsperado.add(new Integer(1));
		pathEsperado.add(new Integer(3));
		pathEsperado.add(new Integer(0));

	
		assertTrue(path.equals(pathEsperado));
	}
	@Test
	public void testCase11LimitValuesGetPath() {
		
		Integer[] prev = new Integer[] {-1, 3, 0, 0, 2};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(0, 2);
		
		ArrayList<Integer> pathEsperado = new ArrayList<Integer>();
		pathEsperado.add(new Integer(2));
		pathEsperado.add(new Integer(0));
		

	
		assertTrue(path.equals(pathEsperado));
	}
	@Test
	public void testCase12LimitValuesGetPath() {
		
		Integer[] prev = new Integer[] {-1, 3, 0, 0, 2};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(0, 3);
		
		ArrayList<Integer> pathEsperado = new ArrayList<Integer>();
		pathEsperado.add(new Integer(3));
		pathEsperado.add(new Integer(0));
		

	
		assertTrue(path.equals(pathEsperado));
	}
	@Test
	public void testCase13LimitValuesGetPath() {
		
		Integer[] prev = new Integer[] {-1, 3, 0, 0, 2};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(0, 4);
		
		ArrayList<Integer> pathEsperado = new ArrayList<Integer>();
		pathEsperado.add(new Integer(4));
		pathEsperado.add(new Integer(2));
		pathEsperado.add(new Integer(0));
		

	
		assertTrue(path.equals(pathEsperado));
	}
	@Test(expected = Exception.class)
	public void testCase14LimitValuesGetPath() {
		
		Integer[] prev = new Integer[] {-1, 3, 0, 0, 2};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(0, 5);
	}
	@Test(expected = Exception.class)
	public void testCase15LimitValuesGetPath() {
		
		Integer[] prev = new Integer[] {3, -1, 3, 1, 2};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(1, -1);
	}
	@Test
	public void testCase16LimitValuesGetPath() {
		
		Integer[] prev = new Integer[] {3, -1, 3, 1, 2};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(1, 0);
		
		ArrayList<Integer> pathEsperado = new ArrayList<Integer>();
		pathEsperado.add(new Integer(0));
		pathEsperado.add(new Integer(3));
		pathEsperado.add(new Integer(1));
		

	
		assertTrue(path.equals(pathEsperado));
	}
	@Test
	public void testCase17LimitValuesGetPath() {
		
		Integer[] prev = new Integer[] {3, -1, 3, 1, 2};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(1, 1);
		
		ArrayList<Integer> pathEsperado = new ArrayList<Integer>();
		pathEsperado.add(new Integer(1));
		

	
		assertTrue(path.equals(pathEsperado));
	}
	@Test
	public void testCase18LimitValuesGetPath() {
		
		Integer[] prev = new Integer[] {3, -1, 3, 1, 2};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(1, 2);
		
		ArrayList<Integer> pathEsperado = new ArrayList<Integer>();
		pathEsperado.add(new Integer(2));
		pathEsperado.add(new Integer(3));
		pathEsperado.add(new Integer(1));
		

	
		assertTrue(path.equals(pathEsperado));
	}
	@Test
	public void testCase19LimitValuesGetPath() {
		
		Integer[] prev = new Integer[] {3, -1, 3, 1, 2};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(1, 3);
		
		ArrayList<Integer> pathEsperado = new ArrayList<Integer>();
		pathEsperado.add(new Integer(3));
		pathEsperado.add(new Integer(1));
		

	
		assertTrue(path.equals(pathEsperado));
	}
	@Test
	public void testCase20LimitValuesGetPath() {
		
		Integer[] prev = new Integer[] {3, -1, 3, 1, 2};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(1, 4);
		
		ArrayList<Integer> pathEsperado = new ArrayList<Integer>();
		pathEsperado.add(new Integer(4));
		pathEsperado.add(new Integer(2));
		pathEsperado.add(new Integer(3));
		pathEsperado.add(new Integer(1));
		

	
		assertTrue(path.equals(pathEsperado));
	}
	@Test(expected = Exception.class)
	public void testCase21LimitValuesGetPath() {
		
		Integer[] prev = new Integer[] {3, -1, 3, 1, 2};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(1, 5);
	}
	@Test(expected = Exception.class)
	public void testCase22LimitValuesGetPath() {
		
		Integer[] prev = new Integer[] {2, 3, -1, 2, 2};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(2, -1);
	}
	@Test
	public void testCase23LimitValuesGetPath() {
		
		Integer[] prev = new Integer[] {2, 3, -1, 2, 2};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(2, 0);
		
		ArrayList<Integer> pathEsperado = new ArrayList<Integer>();
		pathEsperado.add(new Integer(0));
		pathEsperado.add(new Integer(2));
		

	
		assertTrue(path.equals(pathEsperado));
	}
	@Test
	public void testCase24LimitValuesGetPath() {
		
		Integer[] prev = new Integer[] {2, 3, -1, 2, 2};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(2, 1);
		
		ArrayList<Integer> pathEsperado = new ArrayList<Integer>();
		pathEsperado.add(new Integer(1));
		pathEsperado.add(new Integer(3));
		pathEsperado.add(new Integer(2));
		

	
		assertTrue(path.equals(pathEsperado));
	}
	@Test
	public void testCase25LimitValuesGetPath() {
		
		Integer[] prev = new Integer[] {2, 3, -1, 2, 2};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(2, 2);
		
		ArrayList<Integer> pathEsperado = new ArrayList<Integer>();
		pathEsperado.add(new Integer(2));
		

	
		assertTrue(path.equals(pathEsperado));
	}
	@Test
	public void testCase26LimitValuesGetPath() {
		
		Integer[] prev = new Integer[] {2, 3, -1, 2, 2};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(2, 3);
		
		ArrayList<Integer> pathEsperado = new ArrayList<Integer>();
		pathEsperado.add(new Integer(3));
		pathEsperado.add(new Integer(2));
		

	
		assertTrue(path.equals(pathEsperado));
	}
	@Test
	public void testCase27LimitValuesGetPath() {
		
		Integer[] prev = new Integer[] {2, 3, -1, 2, 2};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(2, 4);
		
		ArrayList<Integer> pathEsperado = new ArrayList<Integer>();
		pathEsperado.add(new Integer(4));
		pathEsperado.add(new Integer(2));
		

	
		assertTrue(path.equals(pathEsperado));
	}
	
	
	@Test(expected = Exception.class)
	public void testCase28LimitValuesGetPath() {
		
		Integer[] prev = new Integer[] {2, 3, -1, 2, 2};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(2, 5);
	}
	@Test(expected = Exception.class)
	public void testCase29LimitValuesGetPath() {
		
		Integer[] prev = new Integer[] {3, 3, 3, -1, 2};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(3, -1);
	}
	@Test
	public void testCase30LimitValuesGetPath() {
		
		Integer[] prev = new Integer[] {3, 3, 3, -1, 2};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(3, 0);
		
		ArrayList<Integer> pathEsperado = new ArrayList<Integer>();
		pathEsperado.add(new Integer(0));
		pathEsperado.add(new Integer(3));
		

	
		assertTrue(path.equals(pathEsperado));	
	}
	@Test
	public void testCase31LimitValuesGetPath() {
		
		Integer[] prev = new Integer[] {3, 3, 3, -1, 2};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(3, 1);
		
		ArrayList<Integer> pathEsperado = new ArrayList<Integer>();
		pathEsperado.add(new Integer(1));
		pathEsperado.add(new Integer(3));
		

	
		assertTrue(path.equals(pathEsperado));	
	}
	@Test
	public void testCase32LimitValuesGetPath() {
		
		Integer[] prev = new Integer[] {3, 3, 3, -1, 2};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(3, 2);
		
		ArrayList<Integer> pathEsperado = new ArrayList<Integer>();
		pathEsperado.add(new Integer(2));
		pathEsperado.add(new Integer(3));
		

	
		assertTrue(path.equals(pathEsperado));	
	}
	@Test
	public void testCase33LimitValuesGetPath() {
		
		Integer[] prev = new Integer[] {3, 3, 3, -1, 2};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(3, 3);
		
		ArrayList<Integer> pathEsperado = new ArrayList<Integer>();
		pathEsperado.add(new Integer(3));
		

	
		assertTrue(path.equals(pathEsperado));	
	}
	@Test
	public void testCase34LimitValuesGetPath() {
		
		Integer[] prev = new Integer[] {3, 3, 3, -1, 2};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(3, 4);
		
		ArrayList<Integer> pathEsperado = new ArrayList<Integer>();
		pathEsperado.add(new Integer(4));
		pathEsperado.add(new Integer(2));
		pathEsperado.add(new Integer(3));
		

	
		assertTrue(path.equals(pathEsperado));	
	}

	@Test(expected = Exception.class)
	public void testCase35LimitValuesGetPath() {
		
		Integer[] prev = new Integer[] {3, 3, 3, -1, 2};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(3, 5);
	}
	@Test(expected = Exception.class)
	public void testCase36LimitValuesGetPath() {
		
		Integer[] prev = new Integer[] {2, 3, 4, 2, -1};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(4, -1);
	}
	@Test
	public void testCase37LimitValuesGetPath() {
		
		Integer[] prev = new Integer[] {2, 3, 4, 2, -1};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(4, 0);
		
		ArrayList<Integer> pathEsperado = new ArrayList<Integer>();
		pathEsperado.add(new Integer(0));
		pathEsperado.add(new Integer(2));
		pathEsperado.add(new Integer(4));
		

	
		assertTrue(path.equals(pathEsperado));	
	}
	@Test
	public void testCase38LimitValuesGetPath() {
		
		Integer[] prev = new Integer[] {2, 3, 4, 2, -1};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(4, 1);
		
		ArrayList<Integer> pathEsperado = new ArrayList<Integer>();
		pathEsperado.add(new Integer(1));
		pathEsperado.add(new Integer(3));
		pathEsperado.add(new Integer(2));
		pathEsperado.add(new Integer(4));
		

	
		assertTrue(path.equals(pathEsperado));	
	}
	@Test
	public void testCase39LimitValuesGetPath() {
		
		Integer[] prev = new Integer[] {2, 3, 4, 2, -1};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(4, 2);
		
		ArrayList<Integer> pathEsperado = new ArrayList<Integer>();
		pathEsperado.add(new Integer(2));
		pathEsperado.add(new Integer(4));
		

	
		assertTrue(path.equals(pathEsperado));	
	}
	@Test
	public void testCase40LimitValuesGetPath() {
		
		Integer[] prev = new Integer[] {2, 3, 4, 2, -1};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(4, 3);
		
		ArrayList<Integer> pathEsperado = new ArrayList<Integer>();
		pathEsperado.add(new Integer(3));
		pathEsperado.add(new Integer(2));
		pathEsperado.add(new Integer(4));
		

	
		assertTrue(path.equals(pathEsperado));	
	}
	@Test
	public void testCase41LimitValuesGetPath() {
		
		Integer[] prev = new Integer[] {2, 3, 4, 2, -1};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(4, 4);
		
		ArrayList<Integer> pathEsperado = new ArrayList<Integer>();
		pathEsperado.add(new Integer(4));
		

	
		assertTrue(path.equals(pathEsperado));	
	}
	@Test(expected = Exception.class)
	public void testCase42LimitValuesGetPath() {
		
		Integer[] prev = new Integer[] {2, 3, 4, 2, -1};
		
		dijkstra.setPrev(prev);
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(4, 5);
	}
	@Test(expected = Exception.class)
	public void testCase43LimitValuesGetPath() {
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(5, -1);
	}
	@Test(expected = Exception.class)
	public void testCase44LimitValuesGetPath() {
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(5, 0);
	}
	@Test(expected = Exception.class)
	public void testCase45LimitValuesGetPath() {
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(5, 1);
	}
	@Test(expected = Exception.class)
	public void testCase46LimitValuesGetPath() {
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(5, 2);
	}
	@Test(expected = Exception.class)
	public void testCase47LimitValuesGetPath() {
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(5, 3);
	}
	@Test(expected = Exception.class)
	public void testCase48LimitValuesGetPath() {
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(5, 4);
	}
	@Test(expected = Exception.class)
	public void testCase49LimitValuesGetPath() {
		dijkstra.setExec(true);		
		ArrayList<Integer> path = dijkstra.getPath(5, 5);
	}
	/***************************************** VALORES LÍMITES *****************************************/
}
