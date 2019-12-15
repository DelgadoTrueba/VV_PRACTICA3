package upm.estsisi.giwt41.vv.bm0023_bm0514_bm0035_bk0158.dijkstra;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import upm.estsisi.giwt41.vv.bm0023_bm0514_bm0035_bk0158.dijkstra.Dijkstra;

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
			{0.0, 7.0, 5.0, 2.0, 0.0},
			{7.0, 0.0, 0.0, 3.0, 0.0},
			{5.0, 0.0, 0.0, 4.0, 6.0},
			{2.0, 3.0, 4.0, 0.0, 0.0},
			{0.0, 0.0, 6.0, 0.0, 0.0},
		};
	}
	
	@Before  
    public void setUp() {   
		diklstraNentriesCero = new Dijkstra(matriz0x0,0);
		diklstraNentriesTres = new Dijkstra(matriz3x3,3);
		diklstraNentriesCinco = new Dijkstra(matriz5x5,5);
	}
	
	/*****************************  CAMINOS MÍNIMOS **********************************/
	

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testCase1ComputeShortestPath(){
		Double resul = diklstraNentriesCero.computeShortestPath(0, 0);
	}
	
	
	@Test
	public void testCase2ComputeShortestPath(){
		Double resul = diklstraNentriesTres.computeShortestPath(0, 2);

		assertTrue(Double.isInfinite(resul));
	}
	
	@Test
	public void testCase3ComputeShortestPath(){
		Double[][] matriz = new Double[][] {
			{0.0, 7.0, 1.0},
			{7.0, 0.0, 7.0},
			{1.0, 7.0, 0.0}
		};
		Integer nVertices = 3;
		
		Dijkstra dijkstra = new Dijkstra(matriz, nVertices);
		Double resul = dijkstra.computeShortestPath(0, 1);

		assertTrue(resul==7);
	}
	
	@Test
	public void testCase4ComputeShortestPath(){
		Double[][] matriz = new Double[][] {
			{0.0, 7.0},
			{7.0, 0.0},
		};
		Integer nVertices = 2;
		
		Dijkstra dijkstra = new Dijkstra(matriz, nVertices);
		Double resul = dijkstra.computeShortestPath(0, 1);

		assertTrue(resul==7);
	}
	
	
	/*****************************  FIN CAMINOS MÍNIMOS **********************************/

	/***************************** CONDICIONES MULTICLAUSULA **********************************/
	//if
	@Test
	public void testCondicionMultiple1ComputeShortestPath(){
		Double[][] matriz = new Double[][] {
			{0.0, 7.0, 0.0},
			{7.0, 0.0, 0.0},
			{0.0, 0.0, 0.0},
		};
		Integer nVertices = 3;
		
		Dijkstra dijkstra = new Dijkstra(matriz, nVertices);
		Double resul = dijkstra.computeShortestPath(0, 1);

		assertTrue(resul==7);
	}
	
	@Test
	public void testCondicionMultiple2ComputeShortestPath(){
		Double[][] matriz = new Double[][] {
			{0.0, 7.0, 2.0},
			{7.0, 0.0, 0.0},
			{2.0, 0.0, 0.0},
		};
		Integer nVertices = 3;
		
		Dijkstra dijkstra = new Dijkstra(matriz, nVertices);
		Double resul = dijkstra.computeShortestPath(0, 2);

		assertTrue(resul==2);
	}
	
	@Test
	public void testCondicionMultiple3ComputeShortestPath(){
		Double[][] matriz = new Double[][] {
			{0.0, 7.0, 0.0},
			{0.0, 0.0, 0.0},
			{0.0, 0.0, 0.0},
		};
		Integer nVertices = 3;
		
		Dijkstra dijkstra = new Dijkstra(matriz, nVertices);
		Double resul = dijkstra.computeShortestPath(0, 2);

		assertTrue(Double.POSITIVE_INFINITY == resul);
	}
	//while
	@Test
	public void testCondicionMultiple1WHILEComputeShortestPath(){
		Double[][] matriz = new Double[][] {
			{0.0, 2.0, 7.0},
			{2.0, 0.0, 0.0},
			{7.0, 0.0, 0.0},
		};
		Integer nVertices = 3;
		
		Dijkstra dijkstra = new Dijkstra(matriz, nVertices);
		Double resul = dijkstra.computeShortestPath(0, 2);

		assertTrue(resul == 7);
	}
	
	@Test
	public void testCondicionMultiple2WHILEComputeShortestPath(){
		Double[][] matriz = new Double[][] {
			{0.0, 0.0, 0.0},
			{0.0, 0.0, 0.0},
			{0.0, 0.0, 0.0},
		};
		Integer nVertices = 3;
		
		Dijkstra dijkstra = new Dijkstra(matriz, nVertices);
		Double resul = dijkstra.computeShortestPath(0, 2);

		assertTrue(Double.POSITIVE_INFINITY == resul);
	}
	
	@Test
	public void testCondicionMultiple3WHILEComputeShortestPath(){
		Double[][] matriz = new Double[][] {
			{0.0, 2.0, 7.0},
			{2.0, 0.0, 0.0},
			{7.0, 0.0, 0.0},
		};
		Integer nVertices = 3;
		
		Dijkstra dijkstra = new Dijkstra(matriz, nVertices);
		Double resul = dijkstra.computeShortestPath(0, 0);

		assertTrue(resul == 0);
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
	  /***************************************** VALORES LÍMITES *****************************************/
	@Test(expected = Exception.class)
	public void testCase1LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(-1, -1);
	}
	
	@Test(expected = Exception.class)
	public void testCase2LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(-1, -0);
	}
	
	@Test(expected = Exception.class)
	public void testCase3LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(-1, 1);
	}
	
	@Test(expected = Exception.class)
	public void testCase4LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(-1, 2);
	}
	
	@Test(expected = Exception.class)
	public void testCase5LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(-1, 3);
	}
	
	@Test(expected = Exception.class)
	public void testCase6LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(-1, -4);
	}
	
	@Test(expected = Exception.class)
	public void testCase7LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(-1, -5);
	}
	
	@Test(expected = Exception.class)
	public void testCase8LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(0, -1);
	}
	
	@Test
	public void testCase9LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(0, 0);
		assert(resul == 0);
	}
	
	@Test
	public void testCase10LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(0, 1);
		assert(resul == 5);
	}
	
	@Test
	public void testCase11LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(0, 2);
		assert(resul == 5);
	}
	
	@Test
	public void testCase12LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(0, 3);
		assert(resul == 2);
	}
	
	@Test
	public void testCase13LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(0,4);
		assert(resul == 11);
	}
	
	@Test(expected = Exception.class)
	public void testCase14LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(0, 5);
	}
	
	@Test(expected = Exception.class)
	public void testCase15LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(1, -1);
	}
	
	@Test
	public void testCase16LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(1, 0);
		assert(resul == 5);
	}
	
	@Test
	public void testCase17LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(1, 1);
		assert(resul == 0);
	}
	
	@Test
	public void testCase18LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(1, 2);
		assert(resul == 7);
	}
	
	@Test
	public void testCase19LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(1, 3);
		assert(resul == 3.0);
	}
	
	@Test
	public void testCase20LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(1, 4);
		assert(resul == 13);
	}
	
	@Test(expected = Exception.class)
	public void testCase21LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(1, 5);
	}
	
	@Test(expected = Exception.class)
	public void testCase22LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(2, -1);
	}
	
	@Test
	public void testCase23LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(2, 0);
		assert(resul == 5);
	}
	
	@Test
	public void testCase24LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(2, 1);
		assert(resul == 7);
	}
	
	@Test
	public void testCase25LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(2, 2);
		assert(resul == 0);
	}
	
	@Test
	public void testCase26LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(2, 3);
		assert(resul == 4);
	}
	
	@Test
	public void testCase27LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(2, 4);
		assert(resul == 6);
	}
	
	@Test(expected = Exception.class)
	public void testCase28LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(2, 5);
	}
	
	@Test(expected = Exception.class)
	public void testCase29LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(3, -1);
	}
	
	@Test
	public void testCase30LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(3, 0);
		assert(resul == 2);
	}
	
	@Test
	public void testCase31LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(3, 1);
		assert(resul == 3);
	}
	
	@Test
	public void testCase32LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(3, 2);
		assert(resul == 4);
	}
	
	@Test
	public void testCase33LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(3, 3);
		assert(resul == 0);
	}
	
	@Test
	public void testCase34LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(3, 4);
		assert(resul == 10);
	}
	
	@Test(expected = Exception.class)
	public void testCase35LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(3, 5);
	}
	
	@Test(expected = Exception.class)
	public void testCase36LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(4, -1);
	}
	
	@Test
	public void testCase37LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(4, 0);
		assert(resul == 11);
	}
	
	@Test
	public void testCase38LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(4, 1);
		assert(resul == 13);
	}
	
	@Test
	public void testCase39LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(4, 2);
		assert(resul == 6);
	}
	
	@Test
	public void testCase40LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(4, 3);
		assert(resul == 10);
	}
	
	@Test
	public void testCase41LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(4, 4);
		assert(resul == 0);
	}
	
	@Test(expected = Exception.class)
	public void testCase42LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(4, 5);
	}
	
	@Test(expected = Exception.class)
	public void testCase43LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(5, -1);
	}
	
	@Test(expected = Exception.class)
	public void testCase44LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(5, 0);
	}
	
	@Test(expected = Exception.class)
	public void testCase45LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(5, 1);
	}
	
	@Test(expected = Exception.class)
	public void testCase46LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(5, 2);
	}
	
	@Test(expected = Exception.class)
	public void testCase47LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(5, 3);
	}
	
	@Test(expected = Exception.class)
	public void testCase48LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(5, 4);
	}
	
	@Test(expected = Exception.class)
	public void testCase49LimitValuesShortestPath() {
		Double resul = diklstraNentriesCinco.computeShortestPath(5, 5);
	}

	
	
		/***************************************** FIN VALORES LÍMITES *****************************************/

}
