/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Mike Tsebo
 */
public class Valeur {
    public Professeur prof;
    public Salle salle;

    public Valeur(Professeur matiere, Salle salle) {
        this.prof = matiere;
        this.salle = salle;
    }

    @Override
	public String toString(){
		return "(" + prof.matiereDuProf.getNom() + ", " + salle.getNom() + ")";
	}
    
    
}
