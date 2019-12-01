package upm.estsisi.giwt41.vv.bm0023_bm0514.agenda;

/**
 * Entry of the agenda. Contains information
 * of the name, surname, address, city,
 * county, zip, telephone and year of birth
 * of the contact.
 * 
 * These fields are inicialized as empty (birthyear as 0)
 * and can be set using the corresponding set methods.
 * 
 * An Entry is considered to have data if the name
 * and surname of the contact are not empty.
 *
 */
public class Entry implements Comparable<Entry>
{
	private String name;
	private String surname;
	private String address;
	private String city;
	private String county;
	private String zip;
	private String telephone;
	private int birthYear;
	
	public Entry () 
	{
		name = "";
		surname = "";
		address = "";
		city = "";
		county = "";
		zip = "";
		telephone = "";
		birthYear = 0;
	}
	
	/**
	 * Checks if the Entry has data, that is, if
	 * the name and surname of the entry are not empty.
	 * 
	 * @return True if the Entry has data, false otherwise.
	 */
	public boolean hasData ()
	{
		if (!name.equals("") && !surname.equals(""))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/** SET METHODS **/
	
	public void setName (String newName)
	{
		name = newName;
	}
	
	public void setSurname (String newSurname)
	{
		surname = newSurname;
	}
	
	public void setAddress (String newAddress)
	{
		address = newAddress;
	}
	
	public void setCity (String newCity)
	{
		city = newCity;
	}
	
	public void setCounty (String newCounty)
	{
		county = newCounty;
	}
	
	public void setZip (String newZip)
	{
		zip = newZip;
	}
	
	public void setTelephone (String newTlph)
	{
		telephone = newTlph;
	}
	
	public void setBirthYear (int newYear)
	{
		birthYear = newYear;
	}
	

	/** GET METHODS **/
	
	public String getName ()
	{
		return name;
	}
	
	public String getSurname ()
	{
		return surname;
	}
	
	public String getFullAddress ()
	{
		String x = (address + " " + city + " " + county + " " + zip);
		return x;
	}
	
	public String getAddress ()
	{
		return address;
	}
	
	public String getCity ()
	{
		return city;
	}
	
	public String getCounty ()
	{
		return county;
	}
	
	public String getZip ()
	{
		return zip;
	}
	
	public String getTelephone ()
	{
		return telephone;
	}
	
	public int getBirthYear ()
	{
		return birthYear;
	}
	
	/*COMPARATE*/
	public int compareTo(Entry other) {
		int ANTES = -1;
		int IGUAL = 0;
		int DESPUES = 1;
		
		//IGUALES
		if(name.compareTo(other.name) == 0 && surname.compareTo(other.surname) == 0) {
			return IGUAL;
		}
		else {
			if(name.compareTo(other.name) == 0 ) {
				// MISMO NOMBRE && this.surname < other.surname;
				if(surname.compareTo(other.surname) < 0) {
					return ANTES;
				}
				// MISMO NOMBRE && this.surname > other.surname;
				else {
					return DESPUES;
				}
			}
			else {
				// this.nombre < other.nombre;
				if(name.compareTo(other.name) < 0) {
					return ANTES;
				}
				// this.nombre > other.nombre;
				else {
					return DESPUES;
				}
			}
		}
		
		/*
		//Compares two strings lexicographically.
		// < 0 si el String name precede (ANTES) lexicograficamente al String other.name
		// > 0 si el String name sigue (DESPUES ) lexicograficamente al String other.name
		// 0 si ambas cadenas son iguales
        return name.compareTo(other.name);
        */
    }

	public boolean equals(Entry other) {
		return this.name.equals(other.name) && this.surname.equals(other.surname)
				&& this.address.equals(other.address) && this.city.equals(other.city) 
				&& this.county.equals(other.county) && this.zip.equals(other.zip) 
				&& this.telephone.equals(other.telephone) && this.birthYear == (other.birthYear); 
	}
	
	
}
