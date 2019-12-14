package upm.estsisi.giwt41.vv.bm0023_bm0514.dijkstra;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DijkstraConstructor {
	
	
	/*****************************  CLASES DE EQUIVALENCIA **********************************/
	@Test
	public void testCase1EquivalenceClassConstructor() {
		Double[][] matriz2x2;
		Dijkstra dijkstra;
		int nVertices;
	
		matriz2x2 = new Double[][]{
			{0.0, 7.0},
			{7.0, 0.0},
		};
		
		nVertices = 2;
		
		dijkstra = new Dijkstra(matriz2x2, nVertices);
	}


	@Test(expected= Exception.class)
	public void testCase2EquivalenceClassConstructor() {
		Double[][] matriz2x2;
		Dijkstra dijkstra;
		int nVertices;
	
		matriz2x2 = new Double[][]{
			{0.0, 7.0},
			{7.0, 0.0},
		};
		
		nVertices = 3;
		
		dijkstra = new Dijkstra(matriz2x2, nVertices);
	}
	
	@Test(expected= Exception.class)
	public void testCase3EquivalenceClassConstructor() {
		Double[][] matriz2x2;
		Dijkstra dijkstra;
		int nVertices;
	
		matriz2x2 = new Double[2][2];
		
		nVertices = 2;
		
		dijkstra = new Dijkstra(matriz2x2, nVertices);
	}
	
	@Test(expected= Exception.class)
	public void testCase4EquivalenceClassConstructor() {
		Double[][] matriz2x2;
		Dijkstra dijkstra;
		Integer nVertices;
	
		matriz2x2 = new Double[][]{
			{0.0, 7.0},
		};
		
		nVertices = -1;
		
		dijkstra = new Dijkstra(matriz2x2, nVertices);
	}

	/***************************** FIN CLASES DE EQUIVALENCIA **********************************/

}
