package upm.estsisi.giwt41.vv.bm0023_bm0514_bm0035_bk0158.agenda;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import upm.estsisi.giwt41.vv.bm0023_bm0514_bm0035_bk0158.agenda.Agenda;
import upm.estsisi.giwt41.vv.bm0023_bm0514_bm0035_bk0158.agenda.Entry;

public class AgendaRemoveFirstTestCase {

	private static Entry eJoseDelgado;
	private static Entry eIsabelGarcia;

	private Agenda agendaVacia;
	private Agenda agendaContieneIsabelJose;
	private Agenda agendaSoloJose;
	 
	@BeforeClass
	public static void inicializarVariables() {
		//Este método se invoca el primero antes de nada
		eJoseDelgado = new Entry();
		eJoseDelgado.setName("jose");
		eJoseDelgado.setSurname("delgado");
		
		eIsabelGarcia = new Entry();
		eIsabelGarcia.setName("isabel");
		eIsabelGarcia.setSurname("garcia");
		
    }
	
	@Before  
    public void setUp() {   
		//Inicialización de las agendas antes de cada Test
		agendaVacia = new Agenda();
		
		agendaContieneIsabelJose = new Agenda();
		agendaContieneIsabelJose.addEntry(eJoseDelgado);
		agendaContieneIsabelJose.addEntry(eIsabelGarcia);
		
		agendaSoloJose  = new Agenda();
		agendaSoloJose.addEntry(eJoseDelgado);
    } 
	
	
	/*****************************  CAMINOS MÍNIMOS **********************************/
	@Test
	public void testCase1RemoveFirst() {
		
		Entry resul = agendaVacia.removeFirst();
 
		assertTrue(resul == null);
	}
	@Test
	public void testCase2RemoveFirst() {
		
		Entry resul = agendaContieneIsabelJose.removeFirst();
 
		assertTrue(resul == eIsabelGarcia);
		assertTrue(agendaContieneIsabelJose.getFirst().info == eJoseDelgado);
	}
	/***************************** FIN CAMINOS MÍNIMOS **********************************/

	/*****************************  CLASES DE EQUIVALENCIA **********************************/
	@Test
	public void testCase1EquivalenceClassRemoveFirst() {
		Entry resul = agendaContieneIsabelJose.removeFirst();
		assertTrue(resul == eIsabelGarcia);
	}
	
	@Test
	public void testCase2EquivalenceClassRemoveFirst() {
		Entry resul = agendaVacia.removeFirst();
		assertTrue(resul == null);
	}
	
	@Test
	public void testCase3EquivalenceClassRemoveFirst() {
		Entry resul = agendaSoloJose.removeFirst();
		assertTrue(resul == eJoseDelgado);
	}

	/*****************************  FIN CLASES DE EQUIVALENCIA **********************************/

}
