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
public class ContrainteUnaire extends Contrainte {
    public Variable var;

    public ContrainteUnaire(Variable var) {
        this.var = var;
    }

    @Override
    public boolean satisfaite() {
        return (var.getValeur()==null || var.getValeur().prof.prefer(var));
    }

    @Override
    public boolean contiens(Variable x) {
        return (var==x);
    }
    
}
