package upm.estsisi.giwt41.vv.bm0023_bm0514.agenda;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AgendaRemoveEntryTestCase {

	private static Entry eJoseDelgado;
	private static Entry eAsierBalda;
	private static Entry eIsabelGarcia;

	private Agenda agendaVacia;
	private Agenda agendaContieneIsabelJose;
	private Agenda agendaContieneJose;
	 
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
		
    }
	
	@Before  
    public void setUp() {   
		//Inicialización de las agendas antes de cada Test
		agendaVacia = new Agenda();
		
		agendaContieneJose = new Agenda();
		agendaContieneJose.addEntry(eJoseDelgado);
		
		agendaContieneIsabelJose = new Agenda();
		agendaContieneIsabelJose.addEntry(eJoseDelgado);
		agendaContieneIsabelJose.addEntry(eIsabelGarcia);
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
	
}
