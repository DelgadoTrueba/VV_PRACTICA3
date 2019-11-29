package upm.estsisi.giwt41.vv.bm0023_bm0514.agenda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * A node of the Agenda. Contains the
 * data of an Entry.
 */
class AgendaNode {
	Entry info;
	AgendaNode sig;

	AgendaNode(Entry p, AgendaNode siguiente) {
		info = p;
		sig = siguiente;
	}
}

public class Agenda implements AgendaInterface {
	private AgendaNode first;
	private int numEntries;

	public Agenda() {
		first = null;
		numEntries = 0;
	}
	
	public AgendaNode getFirst() {
		return first;
	}

	/** STATIC ANALYSIS
	 * The function addEntry must add a new contact to the agenda. 
	 * This function will receive the values to each field of the contact person. (--)
	 * The new person will be stored into a list sorted by name and surname. (ok) 
	 * If the agenda is empty, then the person added will be the first contact in the list. (ok)
	 *  
	 * This function must return true if the contact has been stored successfully (ok)
	 * and false in the case of duplicate values of name and surname fields.      (ok)
	 */
	
	private boolean esMenorLexicograficamente(Entry actual, Entry p) {
		System.out.println(actual.getName());
		System.out.println(p.getName());
		System.out.println( actual.getName().compareTo(p.getName()));
		return ( actual.getName().compareTo(p.getName()) < 0 || ( actual.getName().compareTo(p.getName()) == 0 && actual.getSurname().compareTo(p.getSurname()) < 0 ) ); 
	}
	
	private boolean esMayorLexicograficamente(Entry actual, Entry p) {
		return ( actual.getName().compareTo(p.getName()) > 0 || ( actual.getName().compareTo(p.getName()) == 0 && actual.getSurname().compareTo(p.getSurname()) > 0 ) ); 
	}
	
	public boolean addEntry(Entry p) {
		AgendaNode anterior = first;
		AgendaNode actual = first;
		AgendaNode nuevo;

		// CONDICION CENTINELA: MIENTRAS LA AGENDA TENGA ENTRADAS Y LA ENTRADA ACTUAL SEA LEXICOGRAFICAMENTE MENOR (nombre y apellido) A LA BUSCADA AVANZAMOS
		while (actual != null && ( esMenorLexicograficamente(actual.info, p) ) ) {
			anterior = actual;
			actual = actual.sig;		
		}
		// SE HA RECORRIDO TODA LA LISTA debido a que NO SE HA ENCONTRADA LA ENTRADA BUSCADA NI UNA ENTRADA LEXICOGRAFICAMENTE MAYOR
		if(actual == null) {
			nuevo = new AgendaNode(p, null);
			if(first == null) { // AÑADIR AL PRINCIPIO DE LA LISTA
				first = nuevo;
				numEntries++;
				return true;
			}
			else { // AÑADIR AL FINAL DE LA LISTA
				anterior.sig = nuevo;
				numEntries++;
				return true;
			}
		}
		// NO SE HA RECORRIDO TODA LA LISTA
		else {
			// NO SE HA RECORRIDO TODA LA LISTA debido a que HEMOS ENCONTRADO UNA ENTRADA LEXICOGRAFICAMENTE MAYOR A LA BUSCADA
			if (esMayorLexicograficamente(actual.info, p)){
				nuevo = new AgendaNode(p, actual);
				if(first == actual) { // AÑADIR ANTES DEL PRIMERO
					first = nuevo; 
					numEntries++;
					return true;
				}
				else { // AÑADIR EN MEDIO
					anterior.sig = nuevo; 
					numEntries++;
					return true;
				}
			}
			// NO SE HA RECORRIDO TODA LA LISTA debido a que LA ENTRADA ESTA REPETIDA
			else { //ELEMENTO REPETIDO;
				return false;
			}
		}
	}

	/** STATIC ANALYSIS
	 * The function removeEntry must remove a contact from the agenda. This function will
	 * receive the name of the contact person that must be removed. If the agenda is empty the
	 * function does not have any impact in the list. If the agenda has only one contact and this
	 * contact is the one to be removed, the resulted list must be empty. This function must return
	 * true if the contact has been removed successfully and false in the opposite.
	 */
	public boolean removeEntry(String name) {
		if (first == null) {
			return false;
		}

		AgendaNode prev = first;
		while (prev.sig != null && prev.sig.info.getName() != name) {
			prev = prev.sig;
		}

		if (prev.sig == null) {
			return false;
		} else {
			prev.sig = prev.sig.sig;
			numEntries--;
			return true;
		}
	}

	/** STATIC ANALYSIS
	 * The function removeFirst must remove the first contact of the agenda. If the agenda is
	 * empty the function does not have any impact in the list. If the agenda has only one contact,
	 * this contact must be removed and the resulted list must be empty. This function must return
	 * a Entry object if the contact has been removed successfully and null in the opposite.
	 */
	public Entry removeFirst() {
		Entry p = null;

		if (first != null) {
			p = first.info;
			first = first.sig;
			numEntries--;
		}

		return p;
	}

	public int nEntries() {
		return numEntries;
	}

	public boolean isEmpty() {
		if (first == null) {
			return true;
		} else {
			return false;
		}
	}

	/** STATIC ANALYSIS
	 * The function saveAgenda must store the agenda in a text file named agendafile.txt.
	 * If the agenda is empty, the function does not create the file. The agenda must remain
	 * unchanged after the saving. The function returns true if the agenda was successfully
	 * saved and false otherwise.
	 */
	public boolean saveAgenda() throws IOException {
		AgendaNode cur = first;
		String line;
		boolean success = false;
		Parser p = new Parser();

		FileWriter fichero = new FileWriter("agendofile.txt");
		BufferedWriter bufferescritura = new BufferedWriter(fichero);
		PrintWriter output = new PrintWriter(bufferescritura);

		while (cur != null) {
			if (!success) {
				success = true;
			}
			p.insertEntry(cur.info);
			line = p.getLine();
			output.println(line);
		}

		return success;
	}

	/** STATIC ANALYSIS
	 * The function loadAgenda must load the agenda from the file agendafile.txt,
	 * adding all the entries in that file. If the agenda is not empty, all the
	 * pre-existing contacts are removed and the final agenda only contain
	 * the entries of the file. If the file agendafile.txt is empty or
	 * does not exists, the agenda remain unchanged.
	 * The function returns true is the file exists and false otherwise.
	 */
	public boolean loadAgenda() throws IOException {
		FileReader filein = new FileReader("agendafile.txt");
		BufferedReader bufferin = new BufferedReader(filein);

		Parser p = new Parser();
		String cad;
		if ((cad = bufferin.readLine()) == null) {
			bufferin.close();
			return false;
		}
		
		do {
			System.out.println(cad);
			p.insertLine(cad);
			Entry auxEntry = p.getEntry();
			if (auxEntry.hasData()) {
				addEntry(auxEntry);
			}
		} while ((cad = bufferin.readLine()) != null);
		filein.close();

		return true;
	}
}
