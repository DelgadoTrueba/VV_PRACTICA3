package upm.estsisi.giwt41.vv.bm0023_bm0514.dijkstra;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DijkstraNextCurTestCase {
	private static Double[][] matriz0x0;
	private static Double[][] matriz3x3;
	private static Double[][] matriz5x5;

	private Dijkstra diklstraNentriesCero;
	private Dijkstra diklstraNentriesCinco;
	private Dijkstra diklstraNentriesTres;


	@BeforeClass
	public static void inicializarVariables() {
		matriz0x0 = new Double[][]{
    		{},
			{},
		};
		
		matriz3x3 = new Double[][]{
			{0.0, 7.0, 5.0},
			{7.0, 0.0, 0.0},
			{5.0, 0.0, 0.0},
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
	
	@Test
	public void testCase1NextCur(){
		Integer resul = diklstraNentriesCero.nextCur();

		assertTrue(resul == -1 );
	}
	
	@Test
	public void testCase2NextCur(){
		
		boolean[] visited = new boolean[] {true, true, false, true, false, false};
		Double[] distances = new Double[] {0.0, 5.0, 5.0, 2.0, Double.POSITIVE_INFINITY, 10.0};
		
		diklstraNentriesCinco.setVisited(visited);
		diklstraNentriesCinco.setDistances(distances);

		Integer resul = diklstraNentriesCinco.nextCur();
		assertTrue(resul == 2);
	}
	
	@Test
	public void testCase3NextCur(){
		
		boolean[] visited = new boolean[] {true, false, false, false, false, false};
		Double[] distances = new Double[] {0.0, 7.0, 5.0, 2.0, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
		
		diklstraNentriesCinco.setVisited(visited);
		diklstraNentriesCinco.setDistances(distances);

		Integer resul = diklstraNentriesCinco.nextCur();
		assertTrue(resul == 3);
	}
	
	/*****************************  FIN CAMINOS MÍNIMOS **********************************/

	/***************************** CONDICIONES MULTICLAUSULA **********************************/
	@Test
	public void testMultiCondicion1NextCur(){
		
		boolean[] visited = new boolean[] {true, false, false, false, false, false};
		Double[] distances = new Double[] {0.0, 7.0, 5.0, 2.0, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
		
		diklstraNentriesCinco.setVisited(visited);
		diklstraNentriesCinco.setDistances(distances);

		Integer resul = diklstraNentriesCinco.nextCur();
		assertTrue(resul == 3);
	}
	
	@Test
	public void testMultiCondicion2NextCur(){
		
		boolean[] visited = new boolean[] {true, false, false, false, false, false};
		Double[] distances = new Double[] {0.0, 5.0, 7.0, 2.0, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
		
		diklstraNentriesCinco.setVisited(visited);
		diklstraNentriesCinco.setDistances(distances);

		Integer resul = diklstraNentriesCinco.nextCur();
		assertTrue(resul == 3);
	}
	
	@Test
	public void testMultiCondicion3NextCur(){
		
		boolean[] visited = new boolean[] {true, true, false, true, false, false};
		Double[] distances = new Double[] {0.0, 5.0, 5.0, 2.0, Double.POSITIVE_INFINITY, 10.0};
		
		diklstraNentriesCinco.setVisited(visited);
		diklstraNentriesCinco.setDistances(distances);

		Integer resul = diklstraNentriesCinco.nextCur();
		assertTrue(resul == 2);
	}
	
	@Test
	public void testMultiCondicion4NextCur(){
		
		boolean[] visited = new boolean[] {true, true, false, true, false, false};
		Double[] distances = new Double[] {0.0, 5.0, 5.0, 7.0, Double.POSITIVE_INFINITY, 10.0};
		
		diklstraNentriesCinco.setVisited(visited);
		diklstraNentriesCinco.setDistances(distances);

		Integer resul = diklstraNentriesCinco.nextCur();
		assertTrue(resul == 2);
	}
	
	/*****************************  FIN CONDICIONES MULTICLAUSULA **********************************/

	/***************************** CLASES DE EQUIVALENCIA **********************************/
	@Test()
	public void testCase1EquivalenceClassNextCur() {
		boolean[] visited = new boolean[] {true, true, true};
		Double[] distances = new Double[] {0.0, 3.0, 4.0};
		
		diklstraNentriesTres.setVisited(visited);
		diklstraNentriesTres.setDistances(distances);

		Integer resul = diklstraNentriesTres.nextCur();
		assertTrue(resul == -1);
	}
	
	@Test()
	public void testCase2EquivalenceClassNextCur() {
		boolean[] visited = new boolean[] {true, true, false};
		Double[] distances = new Double[] {0.0, 3.0, 4.0};
		
		diklstraNentriesTres.setVisited(visited);
		diklstraNentriesTres.setDistances(distances);

		Integer resul = diklstraNentriesTres.nextCur();
		assertTrue(resul == 2);
	}
	
	@Test()
	public void testCase3EquivalenceClassNextCur() {
		boolean[] visited = new boolean[] {true, true, true, false, false};
		Double[] distances = new Double[] {0.0, 3.0, 4.0, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
		
		diklstraNentriesTres.setVisited(visited);
		diklstraNentriesTres.setDistances(distances);

		Integer resul = diklstraNentriesTres.nextCur();
		assertTrue(resul == -1);
	}

	/***************************** FIN CLASES DE EQUIVALENCIA **********************************/

}
