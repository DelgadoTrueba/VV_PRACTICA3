package upm.estsisi.giwt41.vv.bm0023_bm0514_bm0035_bk0158.agenda;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import upm.estsisi.giwt41.vv.bm0023_bm0514_bm0035_bk0158.agenda.Agenda;
import upm.estsisi.giwt41.vv.bm0023_bm0514_bm0035_bk0158.agenda.Entry;
import upm.estsisi.giwt41.vv.bm0023_bm0514_bm0035_bk0158.agenda.Parser;

public class AgendaSaveAgendaTestCase {
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
		
		agendaSoloJose = new Agenda();
		agendaSoloJose.addEntry(eJoseDelgado);
		
		File archivo = new File("agendafile.txt");
		if(archivo.exists()){
			archivo.delete();
		}
    } 
	
	
	/*****************************  CAMINOS MÍNIMOS **********************************/
	
	@Test
	public void testCase1SaveAgenda() throws IOException {
		
		boolean resul = agendaVacia.saveAgenda();
		File archivo = new File("agendafile.txt");
		
		assertTrue(resul == false);		
		assertTrue(archivo.exists() == false);
	}
	
	@Test
	public void testCase2SaveAgenda() throws IOException{
		
		boolean resul = agendaContieneIsabelJose.saveAgenda();
		
		assertTrue(resul == true);
		
		File archivo = new File("agendafile.txt");
		
		assertTrue(archivo.exists() == true);
		
		FileReader filein = new FileReader(archivo);
		BufferedReader bufferin = new BufferedReader(filein);
		Parser p = new Parser();
		
		Entry entrada1, entrada2;
		String linea;
		
		linea = bufferin.readLine();
		p.insertLine(linea);
		entrada1 = p.getEntry();
		
		linea = bufferin.readLine();
		p.insertLine(linea);
		entrada2 = p.getEntry();
		bufferin.close();
		
		assertTrue(entrada1.equals(eIsabelGarcia));
		assertTrue(entrada2.equals(eJoseDelgado));
	}
	/***************************** FIN CAMINOS MÍNIMOS **********************************/
	
	/*****************************  CLASES DE EQUIVALENCIA **********************************/
	@Test
	public void testCase1EquivalenceClassSaveAgenda() {
		try {
			boolean resul = agendaContieneIsabelJose.saveAgenda();
			assertTrue(resul == true);
		} catch (IOException e) {
			assertTrue(false);
		}
	}
	
	@Test
	public void testCase2EquivalenceClassSaveAgenda() {
		try {
			boolean resul = agendaVacia.saveAgenda();
			assertTrue(resul == false);
		} catch (IOException e) {
			assertTrue(false);
		}
	}
	
	@Test
	public void testCase3EquivalenceClassSaveAgenda() {
		try {
			boolean resul = agendaSoloJose.saveAgenda();
			assertTrue(resul == true);
		} catch (IOException e) {
			assertTrue(false);
		}
	}

	/*****************************  FIN CLASES DE EQUIVALENCIA **********************************/

}
