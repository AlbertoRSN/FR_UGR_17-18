/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase24nov;

public class Persona {
	public static int numPersonas = 0;
 	public String dni;
	public String nombre; //private
 
	public Persona(String d, String nom) { 
		this.setDni(d); 
		this.setNombre(nom); 
		numPersonas +=1;
	}

	public static int getNumPersonas() { 
		return numPersonas;
	} 

	public String getNombre() { 
		return this.nombre;
	}

	public String getDni() { 
		return this.dni; 
	}
	
	protected void setNombre(String nom) { 
		this.nombre=nom;
	} 
	void setDni(String d) { 
		this.dni=d;
	}
	
	Object hablar() { 
		return "bla bla bla";
	}

}	