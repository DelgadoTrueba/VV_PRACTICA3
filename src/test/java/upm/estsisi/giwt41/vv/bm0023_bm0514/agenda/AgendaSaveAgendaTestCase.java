package upm.estsisi.giwt41.vv.bm0023_bm0514.agenda;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
}
