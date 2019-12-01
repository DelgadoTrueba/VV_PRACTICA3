package upm.estsisi.giwt41.vv.bm0023_bm0514.agenda;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AgendaLoadAgendaTestCase {
	
	private static Entry eJoseDelgado;
	private static Entry eIsabelGarcia;
	private static Entry eAsierBalda;
	private static Entry eLuisGarcia;


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
		
		eAsierBalda = new Entry();
		eAsierBalda.setName("asier");
		eAsierBalda.setSurname("balda");
		
		eLuisGarcia = new Entry();
		eLuisGarcia.setName("luis");
		eLuisGarcia.setSurname("garcia");
    }
	
	@Before  
    public void setUp() {   
		//Inicialización de las agendas antes de cada Test
		
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
	public void testCase1LoadAgenda() throws IOException{
		
		File archivo = new File("agendafile.txt");
		assertTrue(archivo.exists() == false);
		
		boolean resul = agendaContieneIsabelJose.loadAgenda();
		
		assertTrue(resul == false);
	}
	
	@Test
	public void testCase2LoadAgenda() throws IOException{
		
		File archivoVacio = new File("agendafile.txt");
		
		FileWriter fichero = new FileWriter(archivoVacio);
		BufferedWriter bufferescritura = new BufferedWriter(fichero);
		PrintWriter output = new PrintWriter(bufferescritura);
		
		bufferescritura.close();
		
		assertTrue(archivoVacio.exists() == true);

		boolean resul = agendaContieneIsabelJose.loadAgenda();
		
		assertTrue(resul == true);
		assertTrue(agendaContieneIsabelJose.getFirst().info.equals(eIsabelGarcia));
		assertTrue(agendaContieneIsabelJose.getFirst().sig.info.equals(eJoseDelgado));
	}
	
	@Test
	public void testCase3LoadAgenda() throws IOException{
		
		File archivo = new File("agendafile.txt");
		
		FileWriter fichero = new FileWriter(archivo);
		BufferedWriter bufferescritura = new BufferedWriter(fichero);
		PrintWriter output = new PrintWriter(bufferescritura);
		
		Entry entrada;
		String linea = "ESTA LINEA NO ES UNA ENTRADA VALIDA";		
		output.println(linea);
		
		bufferescritura.close();
		
		boolean resul = agendaContieneIsabelJose.loadAgenda();
		
		assertTrue(resul == true);
		/*Existe una entrada en el fichero pero es invalida*/
		assertTrue(agendaContieneIsabelJose.getFirst() == null );
	}
	
	@Test
	public void testCase4LoadAgenda() throws IOException{
		
		File archivo = new File("agendafile.txt");
		
		FileWriter fichero = new FileWriter(archivo);
		BufferedWriter bufferescritura = new BufferedWriter(fichero);
		PrintWriter output = new PrintWriter(bufferescritura);
		Parser p = new Parser();
		
		Entry entrada;
		String linea;
		
		p.insertEntry(eAsierBalda);
		linea = p.getLine();
		output.println(linea);
		
		bufferescritura.close();
		
		boolean resul = agendaContieneIsabelJose.loadAgenda();
		
		assertTrue(resul == true);
		assertTrue(agendaContieneIsabelJose.getFirst().info.equals(eAsierBalda) );
	}
	
	@Test
	public void testCase5LoadAgenda() throws IOException{
		
		File archivo = new File("agendafile.txt");
		
		FileWriter fichero = new FileWriter(archivo);
		BufferedWriter bufferescritura = new BufferedWriter(fichero);
		PrintWriter output = new PrintWriter(bufferescritura);
		Parser p = new Parser();
		
		Entry entrada;
		String linea;
		
		p.insertEntry(eAsierBalda);
		linea = p.getLine();
		output.println(linea);
		
		p.insertEntry(eLuisGarcia);
		linea = p.getLine();
		output.println(linea);
		
		bufferescritura.close();
		
		boolean resul = agendaContieneIsabelJose.loadAgenda();
		
		assertTrue(resul == true);
		assertTrue(agendaContieneIsabelJose.getFirst().info.equals(eAsierBalda));
		assertTrue(agendaContieneIsabelJose.getFirst().sig.info.equals(eLuisGarcia));
	}
	
	/***************************** FIN CAMINOS MÍNIMOS **********************************/

}
