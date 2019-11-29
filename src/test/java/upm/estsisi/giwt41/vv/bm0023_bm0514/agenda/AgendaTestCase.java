package upm.estsisi.giwt41.vv.bm0023_bm0514.agenda;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AgendaTestCase {

	private static Entry eJoseDelgado;
	private static Entry eJoseBalda;
	private static Entry eAsierBalda;
	private static Entry eAsierDelgado;
	private static Entry eLuisGarcia;
	private static Entry eIsabelDelgado;
	private static Entry eIsabelBalda;

	private Agenda agendaVacia;
	private Agenda agendaPrimeraEntradaJoseDelgado;
	private Agenda agendaContieneEntradaJoseDelgado;
	private Agenda agendaPrimeraEntradaAsierBalda;
	private Agenda agendaPrimeraEntradaAsierDelgado;
	private Agenda agendaPrimeraEntradaJoseBalda;
	 
	@BeforeClass
	public static void inicializarVariables() {
		//Este método se invoca el primero antes de nada
		eJoseDelgado = new Entry();
		eJoseDelgado.setName("jose");
		eJoseDelgado.setName("delgado");
		
		eJoseBalda = new Entry();
		eJoseBalda.setName("jose");
		eJoseBalda.setName("balda");
		
		eAsierBalda = new Entry();
		eAsierBalda.setName("asier");
		eAsierBalda.setName("balda");
		
		eAsierDelgado = new Entry();
		eAsierDelgado.setName("asier");
		eAsierDelgado.setName("delgado");
		
		eLuisGarcia = new Entry();
		eLuisGarcia.setName("luis");
		eLuisGarcia.setName("garcia");
		
		eIsabelDelgado = new Entry();
		eIsabelDelgado.setName("isabel");
		eIsabelDelgado.setName("delgado");
		
		eIsabelBalda = new Entry();
		eIsabelBalda.setName("isabel");
		eIsabelBalda.setName("balda");
		
    }
	
	@Before  
    public void setUp() {   
		//Inicialización de las agendas antes de cada Test
		agendaVacia = new Agenda();
		
		agendaContieneEntradaJoseDelgado = new Agenda();
		agendaContieneEntradaJoseDelgado.addEntry(eJoseDelgado);
		
		agendaPrimeraEntradaJoseDelgado = new Agenda();
		agendaPrimeraEntradaJoseDelgado.addEntry(eJoseDelgado);
		
		agendaPrimeraEntradaAsierBalda = new Agenda();
		agendaPrimeraEntradaAsierBalda.addEntry(eAsierBalda);
		
		agendaPrimeraEntradaAsierDelgado = new Agenda();
		agendaPrimeraEntradaAsierDelgado.addEntry(eAsierDelgado);
		
		agendaPrimeraEntradaJoseBalda = new Agenda();
		agendaPrimeraEntradaJoseBalda.addEntry(eJoseBalda);
    }  
	
	/*****************************  CAMINOS MÍNIMOS **********************************/
	@Test
	public void testCase1AddEntry(){
		 		 
		boolean resul = agendaVacia.addEntry(eJoseDelgado);
 
		assertTrue(resul == true);
		assertTrue(agendaVacia.nEntries() == 1);
		assertTrue(agendaVacia.getFirst().info == eJoseDelgado);
		assertTrue(agendaVacia.getFirst().sig == null);
	}
	
	@Test
	public void testCase2AddEntry() {
		
		int numEntradasAnterior = agendaContieneEntradaJoseDelgado.nEntries();
		boolean resul = agendaContieneEntradaJoseDelgado.addEntry(eJoseDelgado);
 
		assertTrue(resul == false);
		assertTrue(agendaContieneEntradaJoseDelgado.nEntries() == numEntradasAnterior);
	}
	
	@Test
	public void testCase3AddEntry() {
		
		int numEntradasAnterior = agendaPrimeraEntradaJoseDelgado.nEntries();
		boolean resul = agendaPrimeraEntradaJoseDelgado.addEntry(eAsierBalda);
 
		assertTrue(resul == true);
		assertTrue(agendaPrimeraEntradaJoseDelgado.nEntries() == numEntradasAnterior+1);
		assertTrue(agendaPrimeraEntradaJoseDelgado.getFirst().info == eAsierBalda);
		assertTrue(agendaPrimeraEntradaJoseDelgado.getFirst().sig.info == eJoseDelgado);
	}
	
	@Test
	public void testCase4AddEntry() {
		
		int numEntradasAnterior = agendaPrimeraEntradaJoseDelgado.nEntries();
		boolean resul = agendaPrimeraEntradaJoseDelgado.addEntry(eLuisGarcia);
 
		assertTrue(resul == true);
		assertTrue(agendaPrimeraEntradaJoseDelgado.nEntries() == numEntradasAnterior+1);
		assertTrue(agendaPrimeraEntradaJoseDelgado.getFirst().info == eJoseDelgado);
		assertTrue(agendaPrimeraEntradaJoseDelgado.getFirst().sig.info == eLuisGarcia);
	}
	
	/***************************** FIN CAMINOS MÍNIMOS **********************************/

	/*****************************  CONDICIONES MULTICLAUSULA **********************************/
	@Test
	public void testCase1MultCondicionAddEntry() {
		
		boolean resul = agendaPrimeraEntradaAsierBalda.addEntry(eJoseDelgado);
 
		assertTrue(resul == true);
		assertTrue(agendaPrimeraEntradaAsierBalda.getFirst().info == eAsierBalda);
		assertTrue(agendaPrimeraEntradaAsierBalda.getFirst().sig.info == eJoseDelgado);

	}
	
	@Test
	public void testCase2MultCondicionAddEntry() {
		
		boolean resul = agendaPrimeraEntradaAsierB.addEntry(eJoseDelgado);
 
		assertTrue(resul == true);
		assertTrue(agendaPrimeraEntradaAsierBalda.getFirst().info == eAsierBalda);
		assertTrue(agendaPrimeraEntradaAsierBalda.getFirst().sig.info == eJoseDelgado);

	}
	/*****************************  FIN CONDICIONES MULTICLAUSULA **********************************/

}
