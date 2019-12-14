package upm.estsisi.giwt41.vv.bm0023_bm0514.dijkstra;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DijkstraInitializeComputeShortestPathTestCase {
	
	private static Double[][] matriz0x0;
	private static Double[][] matriz3x3;
	private static Double[][] matriz5x5;

	private Dijkstra diklstraNentriesCero;
	private Dijkstra diklstraNentriesTres;
	private Dijkstra diklstraNentriesCinco;

	@BeforeClass
	public static void inicializarVariables() {
		matriz0x0 = new Double[][]{
    		{},
			{},
		};
		
		matriz3x3 = new Double[][]{
			{0.0, 2.0, 0.0},
			{0.0, 0.0, 0.0},
			{0.0, 0.0, 0.0},
		};

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
		diklstraNentriesCero = new Dijkstra(matriz0x0,0);
		diklstraNentriesTres = new Dijkstra(matriz3x3,3);
		diklstraNentriesCinco = new Dijkstra(matriz5x5,5);
	}
	
	/*****************************  CAMINOS MÍNIMOS **********************************/
	
	//MAL
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testCase1ComputeShortestPath(){
//		Double resul = diklstraNentriesCero.computeShortestPath(0, 0);
	}
	
	//MAL
	@Test
	public void testCase2ComputeShortestPath(){
//		Double resul = diklstraNentriesTres.computeShortestPath(0, 2);
//	
//		assertTrue(resul == Double.POSITIVE_INFINITY);
	}
	
	
	/*****************************  FIN CAMINOS MÍNIMOS **********************************/

	/***************************** CONDICIONES MULTICLAUSULA **********************************/
	public void testCondicionMultiple1ComputeShortestPath(){
//		Double resul = diklstraNentriesTres.computeShortestPath(0, 2);
//	
//		assertTrue(resul == Double.POSITIVE_INFINITY);
	}
	/*****************************  FIN CONDICIONES MULTICLAUSULA **********************************/
	
	/*****************************  CLASES DE EQUIVALENCIA **********************************/
	@Test
	public void testCase1EquivalenceClassShortestPath() {
		Double resul = diklstraNentriesTres.computeShortestPath(0, 2);
		
		assertTrue(Double.isInfinite(resul));
	}
	
	@Test
	public void testCase2EquivalenceClassShortestPath() {
		Double resul = diklstraNentriesTres.computeShortestPath(0, 1);
		
		assertTrue(resul == 2);
	}
	
	@Test(expected = Exception.class)
	public void testCase3EquivalenceClassShortestPath() {
		Double resul = diklstraNentriesTres.computeShortestPath(null, -5);
	}
	
	@Test(expected = Exception.class)
	public void testCase4EquivalenceClassShortestPath() {
		Double resul = diklstraNentriesTres.computeShortestPath(-1, 10);
	}
	
	@Test(expected = Exception.class)
	public void testCase5EquivalenceClassShortestPath() {
		Double resul = diklstraNentriesTres.computeShortestPath(6, null);
	}
	/*****************************  FIN CLASES DE EQUIVALENCIA **********************************/


}
