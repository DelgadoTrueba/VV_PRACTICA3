package upm.estsisi.giwt41.vv.bm0023_bm0514.agenda;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AgendaSaveAgendaTestCase {
	private static Entry eJoseDelgado;
	private static Entry eIsabelGarcia;

	private Agenda agendaVacia;
	private Agenda agendaContieneIsabelJose;
	 
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
    } 
	
	
	/*****************************  CAMINOS MÍNIMOS 
	 * @throws IOException **********************************/
	@Test
	public void testCase1SaveAgenda() throws IOException {
		
		boolean resul = agendaVacia.saveAgenda();
		
		assertTrue(resul == false);
	}
	@Test
	public void testCase2SaveAgenda() throws IOException{
		
		boolean resul = agendaContieneIsabelJose.saveAgenda();
 
		assertTrue(resul == true);
		//assertTrue(agendaContieneIsabelJose.getFirst().info == eJoseDelgado);
	}
	///***************************** FIN CAMINOS MÍNIMOS **********************************
}
