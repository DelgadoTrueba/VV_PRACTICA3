package upm.estsisi.giwt41.vv.bm0023_bm0514_bm0035_bk0158.dijkstra;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import upm.estsisi.giwt41.vv.bm0023_bm0514_bm0035_bk0158.dijkstra.Dijkstra;

public class DijkstraInitializeDataStructuresTestCase {

	private static Double[][] matriz0x0;
	private static Double[][] matriz2x2;

	private Dijkstra diklstraNentriesCero;
	private Dijkstra diklstraNentriesDos;

	@BeforeClass
	public static void inicializarVariables() {
		matriz0x0 = new Double[][]{
    		{},
			{},
		};

		matriz2x2 = new Double[][]{
    		{0.0, 7.0},
			{7.0, 0.0},
		};
	}
	
	@Before  
    public void setUp() {   
		diklstraNentriesCero = new Dijkstra(matriz0x0,0);
		diklstraNentriesDos = new Dijkstra(matriz2x2,2);
	}
	
	/*****************************  CAMINOS MÍNIMOS **********************************/
	@Test
	public void testCase1InitializeDataStructures(){
		diklstraNentriesCero.initializeDataStructures();

		assertTrue(diklstraNentriesCero.getVisited().length == 0 );
		assertTrue(diklstraNentriesCero.getDistances().length  == 0);
		assertTrue(diklstraNentriesCero.getPrev().length  == 0);
	}
	
	@Test
	public void testCase2InitializeDataStructures(){
		diklstraNentriesDos.initializeDataStructures();
		
		boolean[] visited = diklstraNentriesDos.getVisited();
		Double[] distances = diklstraNentriesDos.getDistances();
		Integer[] prev = diklstraNentriesDos.getPrev();
		
		boolean[] visitedEsperado = new boolean[]{false, false};
		Double[] distancesEsperado = new Double[]{Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
		Integer[] prevEsperado = new Integer[]{-1, -1};

		assertTrue((Arrays.equals( visited, visitedEsperado)));
		assertTrue((Arrays.equals( distances, distancesEsperado)));
		assertTrue((Arrays.equals( prev, prevEsperado)));
	}
	/***************************** FIN CAMINOS MÍNIMOS **********************************/

	
}
