/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase24nov;

/**
 *
 * @author albertorodriguez
 */
 public class Profesor extends Persona{
    String asignatura;
    int experiencia;
    public Profesor (String d, String nom, String asig,int exp){
        super(d,nom); 
        this.asignatura=asig; 
        this.experiencia=exp;
    } 
}