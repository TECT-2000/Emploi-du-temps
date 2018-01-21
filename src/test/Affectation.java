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
public class Affectation {
    public Variable var;
    public Valeur val;

    public Affectation(Variable var, Valeur val) {
        this.var = var;
        this.val = val;
        
        var.assigner(val);
    }

    @Override
	public String toString(){
		return "{" + var + ", " + val + "}";
	}
    
    
}
