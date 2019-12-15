package upm.estsisi.giwt41.vv.bm0023_bm0514.agenda;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AgendaAddEntryTestCase {

	private static Entry eJoseDelgado;
	private static Entry eJoseBalda;
	private static Entry eAsierBalda;
	private static Entry eAsierDelgado;
	private static Entry eLuisGarcia;
	private static Entry eIsabelDelgado;
	private static Entry eIsabelBalda;
	private static Entry eJuanMartinez;
	
	

	private Agenda agendaVacia;
	private Agenda agendaPrimeraEntradaJoseDelgado;
	private Agenda agendaContieneEntradaJoseDelgado;
	private Agenda agendaPrimeraEntradaAsierBalda;
	private Agenda agendaPrimeraEntradaAsierDelgado;
	private Agenda agendaPrimeraEntradaJoseBalda;
	private Agenda agendaUnicaEntradaJoseDelgado;
	private Agenda agendaVariasEntradas;

	@BeforeClass
	public static void inicializarVariables() {
		//Este método se invoca el primero antes de nada
		eJoseDelgado = new Entry();
		eJoseDelgado.setName("jose");
		eJoseDelgado.setSurname("delgado");
		
		eJoseBalda = new Entry();
		eJoseBalda.setName("jose");
		eJoseBalda.setSurname("balda");
		
		eAsierBalda = new Entry();
		eAsierBalda.setName("asier");
		eAsierBalda.setSurname("balda");
		
		eAsierDelgado = new Entry();
		eAsierDelgado.setName("asier");
		eAsierDelgado.setSurname("delgado");
		
		eLuisGarcia = new Entry();
		eLuisGarcia.setName("luis");
		eLuisGarcia.setSurname("garcia");
		
		eIsabelDelgado = new Entry();
		eIsabelDelgado.setName("isabel");
		eIsabelDelgado.setSurname("delgado");
		
		eIsabelBalda = new Entry();
		eIsabelBalda.setName("isabel");
		eIsabelBalda.setSurname("balda");
		
		eJuanMartinez = new Entry();
		
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
		
		agendaUnicaEntradaJoseDelgado = new Agenda();
		agendaUnicaEntradaJoseDelgado.addEntry(eJoseDelgado);
		
		agendaVariasEntradas = new Agenda();
		agendaVariasEntradas.addEntry(eJoseDelgado);
		agendaVariasEntradas.addEntry(eAsierBalda);

    }  
	
	/*****************************  CAMINOS MÍNIMOS **********************************/
/*
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
*/	
	/***************************** FIN CAMINOS MÍNIMOS **********************************/

	/*****************************  CONDICIONES MULTICLAUSULA **********************************/
/*	
	@Test
	public void testCase1MultCondicionAddEntry() {
		
		boolean resul = agendaPrimeraEntradaAsierBalda.addEntry(eJoseDelgado);
 
		assertTrue(resul == true);
		assertTrue(agendaPrimeraEntradaAsierBalda.getFirst().info == eAsierBalda);
		assertTrue(agendaPrimeraEntradaAsierBalda.getFirst().sig.info == eJoseDelgado);

	}
	
	@Test
	public void testCase2MultCondicionAddEntry() {
		
		boolean resul = agendaPrimeraEntradaAsierDelgado.addEntry(eJoseBalda);
 
		assertTrue(resul == true);
		assertTrue(agendaPrimeraEntradaAsierDelgado.getFirst().info == eAsierDelgado);
		assertTrue(agendaPrimeraEntradaAsierDelgado.getFirst().sig.info == eJoseBalda);

	}
	
	@Test
	public void testCase3MultCondicionAddEntry() {
		
		boolean resul = agendaPrimeraEntradaJoseBalda.addEntry(eJoseDelgado);
 
		assertTrue(resul == true);
		assertTrue(agendaPrimeraEntradaJoseBalda.getFirst().info == eJoseBalda);
		assertTrue(agendaPrimeraEntradaJoseBalda.getFirst().sig.info == eJoseDelgado);

	}
	
	@Test
	public void testCase4MultCondicionAddEntry() {
		
		boolean resul = agendaPrimeraEntradaJoseDelgado.addEntry(eJoseBalda);
 
		assertTrue(resul == true);
		assertTrue(agendaPrimeraEntradaJoseDelgado.getFirst().info == eJoseBalda);
		assertTrue(agendaPrimeraEntradaJoseDelgado.getFirst().sig.info == eJoseDelgado);

	}
	
	@Test
	public void testCase5MultCondicionAddEntry() {
		
		boolean resul = agendaPrimeraEntradaJoseBalda.addEntry(eIsabelDelgado);
 
		assertTrue(resul == true);
		assertTrue(agendaPrimeraEntradaJoseBalda.getFirst().info == eIsabelDelgado);
		assertTrue(agendaPrimeraEntradaJoseBalda.getFirst().sig.info == eJoseBalda);

	}
	@Test
	public void testCase6MultCondicionAddEntry() {
		
		boolean resul = agendaPrimeraEntradaJoseDelgado.addEntry(eIsabelBalda);
 
		assertTrue(resul == true);
		assertTrue(agendaPrimeraEntradaJoseDelgado.getFirst().info == eIsabelBalda);
		assertTrue(agendaPrimeraEntradaJoseDelgado.getFirst().sig.info == eJoseDelgado);

	}
	@Test
	public void testCase7MultCondicionAddEntry() {
		
		boolean resul = agendaVacia.addEntry(eJoseDelgado);
 
		assertTrue(resul == true);
		assertTrue(agendaVacia.getFirst().info == eJoseDelgado);

	}
	*/
	/*****************************  FIN CONDICIONES MULTICLAUSULA **********************************/
	

	/*****************************  CLASES DE EQUIVALENCIA **********************************/
	/*
	@Test
	public void testCase1EquivalenceClassAddEntry() {
		
		boolean resul = agendaVariasEntradas.addEntry(eAsierBalda);
 
		assertTrue(resul == false);
	}
	
	@Test
	public void testCase2EquivalenceClassAddEntry() {
		
		boolean resul = agendaVacia.addEntry(eAsierBalda);
 
		assertTrue(resul == true);
	}
	
	@Test
	public void testCase3EquivalenceClassAddEntry() {
		
		boolean resul = agendaPrimeraEntradaAsierBalda.addEntry(eJoseDelgado);
 
		assertTrue(resul == true);
	}
	
	@Test(expected= NullPointerException.class)
	public void testCase4EquivalenceClassAddEntry() {
		
		boolean resul = agendaVariasEntradas.addEntry(null);
	}
	*/
	/*****************************  FIN CLASES DE EQUIVALENCIA **********************************/
    /***************************** VALORES LÍMITES *****************************/
	@Test
	public void testCase1LimitEvaluesAddEntry() {
		
		eJuanMartinez.setName("juan");
		eJuanMartinez.setSurname("martinez");
		eJuanMartinez.setAddress("");
		eJuanMartinez.setCity("madrid");
		eJuanMartinez.setCounty("españa");
		eJuanMartinez.setZip("28008");
		eJuanMartinez.setTelephone("611499449");
		eJuanMartinez.setBirthYear(1997);
		
		boolean resul = agendaVacia.addEntry(eJuanMartinez);
		assert(resul == true);
	}
	@Test
	public void testCase2LimitEvaluesAddEntry() {
		
		eJuanMartinez.setName("juan");
		eJuanMartinez.setSurname("martinez");
		eJuanMartinez.setAddress("moncloa");
		eJuanMartinez.setCity("madrid");
		eJuanMartinez.setCounty("españa");
		eJuanMartinez.setZip("28008");
		eJuanMartinez.setTelephone("611499449");
		eJuanMartinez.setBirthYear(1997);
		
		boolean resul = agendaVacia.addEntry(eJuanMartinez);
		assert(resul == true);
	}
	@Test
	public void testCase3LimitEvaluesAddEntry() {
		
		eJuanMartinez.setName("juan");
		eJuanMartinez.setSurname("martinez");
		eJuanMartinez.setAddress("moncloa");
		eJuanMartinez.setCity("");
		eJuanMartinez.setCounty("españa");
		eJuanMartinez.setZip("28008");
		eJuanMartinez.setTelephone("611499449");
		eJuanMartinez.setBirthYear(1997);
		
		boolean resul = agendaVacia.addEntry(eJuanMartinez);
		assert(resul == true);
	}
	@Test
	public void testCase4LimitEvaluesAddEntry() {
		
		eJuanMartinez.setName("juan");
		eJuanMartinez.setSurname("martinez");
		eJuanMartinez.setAddress("moncloa");
		eJuanMartinez.setCity("madrid");
		eJuanMartinez.setCounty("");
		eJuanMartinez.setZip("28008");
		eJuanMartinez.setTelephone("611499449");
		eJuanMartinez.setBirthYear(1997);
		
		boolean resul = agendaVacia.addEntry(eJuanMartinez);
		assert(resul == true);
	}
	@Test
	public void testCase5LimitEvaluesAddEntry() {
		
		eJuanMartinez.setName("juan");
		eJuanMartinez.setSurname("martinez");
		eJuanMartinez.setAddress("moncloa");
		eJuanMartinez.setCity("madrid");
		eJuanMartinez.setCounty("españa");
		eJuanMartinez.setZip("");
		eJuanMartinez.setTelephone("611499449");
		eJuanMartinez.setBirthYear(1997);
		
		boolean resul = agendaVacia.addEntry(eJuanMartinez);
		assert(resul == true);
	}
	@Test
	public void testCase6LimitEvaluesAddEntry() {
		
		eJuanMartinez.setName("juan");
		eJuanMartinez.setSurname("martinez");
		eJuanMartinez.setAddress("moncloa");
		eJuanMartinez.setCity("madrid");
		eJuanMartinez.setCounty("españa");
		eJuanMartinez.setZip("28008");
		eJuanMartinez.setTelephone("");
		eJuanMartinez.setBirthYear(1997);
		
		boolean resul = agendaVacia.addEntry(eJuanMartinez);
		assert(resul == true);
	}
	@Test
	public void testCase7LimitEvaluesAddEntry() {
		
		eJuanMartinez.setName("juan");
		eJuanMartinez.setSurname("martinez");
		eJuanMartinez.setAddress("moncloa");
		eJuanMartinez.setCity("madrid");
		eJuanMartinez.setCounty("españa");
		eJuanMartinez.setZip("28008");
		eJuanMartinez.setTelephone("611499449");
		eJuanMartinez.setBirthYear(0);
		
		boolean resul = agendaVacia.addEntry(eJuanMartinez);
		assert(resul == true);
	}
	@Test
	public void testCase8LimitEvaluesAddEntry() {
		
		eJuanMartinez.setName("juan");
		eJuanMartinez.setSurname("martinez");
		eJuanMartinez.setAddress("moncloa");
		eJuanMartinez.setCity("madrid");
		eJuanMartinez.setCounty("españa");
		eJuanMartinez.setZip("28008");
		eJuanMartinez.setTelephone("611499449");
		eJuanMartinez.setBirthYear(2019);
		
		boolean resul = agendaVacia.addEntry(eJuanMartinez);
		assert(resul == true);
	}
	 /***************************** FIN VALORES LÍMITES *****************************/
	
}
