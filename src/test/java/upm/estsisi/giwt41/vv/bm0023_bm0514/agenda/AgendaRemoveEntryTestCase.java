package upm.estsisi.giwt41.vv.bm0023_bm0514.agenda;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AgendaRemoveEntryTestCase {

	private static Entry eJoseDelgado;
	private static Entry eAsierBalda;
	private static Entry eIsabelGarcia;
	private static Entry eJuanMartinez;

	private Agenda agendaVacia;
	private Agenda agendaContieneIsabelJose;
	private Agenda agendaContieneAsierJose;
	private Agenda agendaContieneJose;
	private Agenda agendaSoloAsier;
	private Agenda agendaIsabelJuan;
	 
	@BeforeClass
	public static void inicializarVariables() {
		//Este método se invoca el primero antes de nada
		eJoseDelgado = new Entry();
		eJoseDelgado.setName("jose");
		eJoseDelgado.setSurname("delgado");
		
		eAsierBalda = new Entry();
		eAsierBalda.setName("asier");
		eAsierBalda.setSurname("balda");
		
		eIsabelGarcia = new Entry();
		eIsabelGarcia.setName("isabel");
		eIsabelGarcia.setSurname("garcia");
		
		eJuanMartinez = new Entry();
		eJuanMartinez.setName("juan");
		eIsabelGarcia.setSurname("martinez");
		
		
		
    }
	
	@Before  
    public void setUp() {   
		//Inicialización de las agendas antes de cada Test
		agendaVacia = new Agenda();
		
		agendaContieneJose = new Agenda();
		agendaContieneJose.addEntry(eJoseDelgado);
		
		agendaSoloAsier = new Agenda();
		agendaSoloAsier.addEntry(eAsierBalda);
		
		agendaContieneIsabelJose = new Agenda();
		agendaContieneIsabelJose.addEntry(eJoseDelgado);
		agendaContieneIsabelJose.addEntry(eIsabelGarcia);
		
		agendaContieneAsierJose = new Agenda();
		agendaContieneAsierJose.addEntry(eAsierBalda);
		agendaContieneAsierJose.addEntry(eJoseDelgado);
		
		agendaIsabelJuan = new Agenda();
		agendaIsabelJuan.addEntry(eIsabelGarcia);
		agendaIsabelJuan.addEntry(eJuanMartinez);
    }
	
	
	/*****************************  CAMINOS MÍNIMOS **********************************/

	@Test
	public void testCase1RemoveEntry() {
		
		boolean resul = agendaVacia.removeEntry(eJoseDelgado.getName());
 
		assertTrue(resul == false);
	}
	@Test
	public void testCase2RemoveEntry() {
		
		boolean resul = agendaContieneIsabelJose.removeEntry(eIsabelGarcia.getName());
 
		assertTrue(resul == true);
		assertTrue(agendaContieneIsabelJose.getFirst().info == eJoseDelgado);
	}
	@Test
	public void testCase3RemoveEntry() {
		
		boolean resul = agendaContieneJose.removeEntry(eIsabelGarcia.getName());
 
		assertTrue(resul == false);
		assertTrue(agendaContieneJose.getFirst().info == eJoseDelgado);
	}
	@Test
	public void testCase4RemoveEntry() {
		
		boolean resul = agendaContieneIsabelJose.removeEntry(eJoseDelgado.getName());
 
		assertTrue(resul == true);
		assertTrue(agendaContieneIsabelJose.getFirst().info == eIsabelGarcia);
	}
	@Test
	public void testCase5RemoveEntry() {
		
		boolean resul = agendaContieneIsabelJose.removeEntry(eAsierBalda.getName());
 
		assertTrue(resul == false);
		assertTrue(agendaContieneIsabelJose.getFirst().info == eIsabelGarcia);
		assertTrue(agendaContieneIsabelJose.getFirst().sig.info == eJoseDelgado);
	}
	/***************************** FIN CAMINOS MÍNIMOS **********************************/

	/*****************************  CONDICIONES MULTICLAUSULA **********************************/
	
	/*****************************  FIN CONDICIONES MULTICLAUSULA **********************************/
	
	/*****************************  CLASES DE EQUIVALENCIA **********************************/
	@Test
	public void testCase1EquivalenceClassRemoveEntry() {
		boolean resul = agendaContieneAsierJose.removeEntry(eAsierBalda.getName());
		
		assertTrue(resul == true);
	}
	
	@Test
	public void testCase2EquivalenceClassRemoveEntry() {
		boolean resul = agendaVacia.removeEntry(eAsierBalda.getName());
		
		assertTrue(resul == false);
	}
	
	@Test
	public void testCase3EquivalenceClassRemoveEntry() {
		boolean resul = agendaSoloAsier.removeEntry(eAsierBalda.getName());
		
		assertTrue(resul == true);
	}
	
	// Debería dar un error y no lo da.
	@Test(expected= Exception.class)
	public void testCase4EquivalenceClassRemoveEntry() {
		boolean resul = agendaContieneAsierJose.removeEntry(" ");
	}
	/*****************************  FIN CLASES DE EQUIVALENCIA **********************************/
	
	/***************************** VALORES LÍMITES *****************************/
	@Test
	public void testCase1LimitValuesRemoveEntry() {
		boolean resul = agendaIsabelJuan.removeEntry("juan");
		
		assertTrue(resul == true);
		assertTrue(agendaIsabelJuan.getFirst().info == eIsabelGarcia);
	}
	 /***************************** FIN VALORES LÍMITES *****************************/
}
