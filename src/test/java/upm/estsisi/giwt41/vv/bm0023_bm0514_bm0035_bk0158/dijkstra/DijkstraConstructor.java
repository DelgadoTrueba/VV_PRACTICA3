package upm.estsisi.giwt41.vv.bm0023_bm0514_bm0035_bk0158.dijkstra;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import upm.estsisi.giwt41.vv.bm0023_bm0514_bm0035_bk0158.dijkstra.Dijkstra;

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
    /***************************************** VALORES LÍMITES *****************************************/
	@Test
	public void testCase1LimitValuesClassConstructor() {
		Double[][] matriz1x1;
		Dijkstra dijkstra;
		Integer nVertices;
	
		matriz1x1 = new Double[][]{
			{0.0},
		};
		nVertices = 1;		
		dijkstra = new Dijkstra(matriz1x1, nVertices);
	}
	@Test
	public void testCase2LimitValuesClassConstructor() {
		Double[][] matriz2x2;
		Dijkstra dijkstra;
		Integer nVertices;
	
		matriz2x2 = new Double[][]{
			{0.0, 7.0},
		};
		nVertices = 2;		
		dijkstra = new Dijkstra(matriz2x2, nVertices);
	}
	@Test(expected= Exception.class)
	public void testCase3LimitValuesClassConstructor() {
		Double[][] matriz2x2;
		Dijkstra dijkstra;
		Integer nVertices;
	
		matriz2x2 = new Double[][]{
			{0.0, 7.0},
		};
		nVertices = 1;		
		dijkstra = new Dijkstra(matriz2x2, nVertices);
	}
	@Test(expected= Exception.class)
	public void testCase4LimitValuesClassConstructor() {
		Double[][] matriz1x1;
		Dijkstra dijkstra;
		Integer nVertices;
	
		matriz1x1 = new Double[][]{
			{0.0},
		};
		nVertices = 2;		
		dijkstra = new Dijkstra(matriz1x1, nVertices);
	}
	@Test(expected= Exception.class)
	public void testCase5LimitValuesClassConstructor() {
		Double[][] matriz0x0;
		Dijkstra dijkstra;
		Integer nVertices;
		
		matriz0x0 = new Double[0][0];
		nVertices = 0;		
		
		dijkstra = new Dijkstra(matriz0x0, nVertices);
	}
	@Test(expected= Exception.class)
	public void testCase6LimitValuesClassConstructor() {
		Double[][] matriz1x1;
		Dijkstra dijkstra;
		Integer nVertices;
	
		matriz1x1 = new Double[][]{
			{0.0},
		};
		nVertices = 0;		
		dijkstra = new Dijkstra(matriz1x1, nVertices);
	}
	@Test(expected= Exception.class)
	public void testCase7LimitValuesClassConstructor() {
		Double[][] matriz2x2;
		Dijkstra dijkstra;
		Integer nVertices;
	
		matriz2x2 = new Double[][]{
			{0.0, 7.0},
		};
		nVertices = 0;		
		dijkstra = new Dijkstra(matriz2x2, nVertices);
	}
	@Test(expected= Exception.class)
	public void testCase8LimitValuesClassConstructor() {
		Double[][] matriz0x0;
		Dijkstra dijkstra;
		Integer nVertices;
		
		matriz0x0 = new Double[0][0];
		nVertices = 1;		
		
		dijkstra = new Dijkstra(matriz0x0, nVertices);
	}
	@Test(expected= Exception.class)
	public void testCase9LimitValuesClassConstructor() {
		Double[][] matriz0x0;
		Dijkstra dijkstra;
		Integer nVertices;
		
		matriz0x0 = new Double[0][0];
		nVertices = 2;		
		
		dijkstra = new Dijkstra(matriz0x0, nVertices);
	}
	@Test(expected= Exception.class)
	public void testCase10LimitValuesClassConstructor() {
		Double[][] matriz3x3;
		Dijkstra dijkstra;
		Integer nVertices;
	
		matriz3x3 = new Double[][]{
			{0.0, 7.0, 0.2},
		};
		nVertices = 0;		
		dijkstra = new Dijkstra(matriz3x3, nVertices);
	}
	@Test(expected= Exception.class)
	public void testCase11LimitValuesClassConstructor() {
		Double[][] matriz3x3;
		Dijkstra dijkstra;
		Integer nVertices;
	
		matriz3x3 = new Double[][]{
			{0.0, 7.0, 0.2},
		};
		nVertices = 1;		
		dijkstra = new Dijkstra(matriz3x3, nVertices);
	}
	@Test(expected= Exception.class)
	public void testCase12LimitValuesClassConstructor() {
		Double[][] matriz3x3;
		Dijkstra dijkstra;
		Integer nVertices;
	
		matriz3x3 = new Double[][]{
			{0.0, 7.0, 0.2},
		};
		nVertices = 2;		
		dijkstra = new Dijkstra(matriz3x3, nVertices);
	}
	@Test(expected= Exception.class)
	public void testCase13LimitValuesClassConstructor() {
		Double[][] matriz0x0;
		Dijkstra dijkstra;
		Integer nVertices;
		
		matriz0x0 = new Double[0][0];
		nVertices = 3;		
		
		dijkstra = new Dijkstra(matriz0x0, nVertices);
	}
	@Test(expected= Exception.class)
	public void testCase14LimitValuesClassConstructor() {
		Double[][] matriz1x1;
		Dijkstra dijkstra;
		Integer nVertices;
	
		matriz1x1 = new Double[][]{
			{0.0},
		};
		nVertices = 3;		
		dijkstra = new Dijkstra(matriz1x1, nVertices);
	}
	@Test(expected= Exception.class)
	public void testCase15LimitValuesClassConstructor() {
		Double[][] matriz2x2;
		Dijkstra dijkstra;
		Integer nVertices;
	
		matriz2x2 = new Double[][]{
			{0.0, 7.0},
		};
		nVertices = 3;		
		dijkstra = new Dijkstra(matriz2x2, nVertices);
	}
	@Test
	public void testCase16LimitValuesClassConstructor() {
		Double[][] matriz3x3;
		Dijkstra dijkstra;
		Integer nVertices;
	
		matriz3x3 = new Double[][]{
			{0.0, 7.0, 0.2},
		};
		nVertices = 3;		
		dijkstra = new Dijkstra(matriz3x3, nVertices);
	}
	/***************************************** FIN VALORES LÍMITES *****************************************/
}
