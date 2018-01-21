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
public class Variable {

    public Jour jour;
    public int heure;
    public int index; //position dans la liste des variables
    private Valeur valeur;

    public Variable(Jour j, int h) {
        this.jour = j;
        this.heure = h;

    }

    public void assigner(Valeur v) {
        valeur = v;
    }

    public void setValeur(Valeur valeur) {
        this.valeur = valeur;
    }

    public void nePasAssigner() {
        valeur = null;
    }

    public Valeur getValeur() {
        return valeur;
    }

    @Override
    public String toString() {
        return "X" + index;
    }

}
