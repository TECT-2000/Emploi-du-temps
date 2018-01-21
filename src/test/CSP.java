/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;

/**
 *
 * @author Mike Tsebo
 */
public class CSP {

    public ArrayList<Variable> ensX=new ArrayList<>();
    public ArrayList<Domaine> domaines = new ArrayList<>();
    public ArrayList<Contrainte> ensC=new ArrayList<>();

    public CSP(ArrayList<Variable> X, ArrayList<Domaine> domains, ArrayList<Contrainte> C) {
        this.ensX = X;
        this.domaines = domains;
        this.ensC = C;
    }

    public ArrayList<Valeur> D(Variable var) {
        return domaines.get(var.index).valeurs;
    }
}
