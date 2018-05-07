/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NuevoPaquete;

import clase24nov.Persona;

/**
 *
 * @author albertorodriguez
 */
 public class Alumno extends Persona {
    String carrera;
    int curso;
    
    public Alumno(String d,String nom, String carr,int cur){
        super(d,nom); 
        this.carrera=carr; 
        this.curso=cur; 
    } 
    
    public String getNombre(){
        return("En plan, " + super.getNombre());
    }
    
    public static void main(String [] args){
        Persona p = new Persona("1111", "Ana");
		
	System.out.println(p.dni);
	System.out.println(p.nombre);
		
	Persona.numPersonas = 4;
		
	System.out.println(Persona.numPersonas);
	System.out.println(p.getNombre());
	System.out.println(p.getDni());
        
        Alumno a = new Alumno("2222", "PEPE", "Informatica", 2);
        System.out.println(a.dni);
        System.out.println(a.nombre);
        
        Alumno.numPersonas = 4;
        
        System.out.println(Alumno.numPersonas);
       // System.out.println(Persona.numPersonas);
        System.out.println(a.getNombre());
        System.out.println(a.getDni());

    }
 
}
