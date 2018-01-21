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
public class ContrainteN_aire extends Contrainte{
    public ArrayList<Variable> listVariables;

    public ContrainteN_aire(ArrayList<Variable> listVariables) {
        this.listVariables = listVariables;
    }

    @Override
    public boolean satisfaite() {
        if(listVariables.size()==0)
            return true;
        else{
            //System.out.println("Call for n-ary constraint checker!!");
        ArrayList<Variable> temp = new ArrayList<Variable>(listVariables);
        while (!temp.isEmpty()) {
            Variable xi = temp.get(0);
            temp.remove(xi);
            if (xi.getValeur() == null) {
                continue;
            }
            int numbers = xi.getValeur().prof.matiereDuProf.getClasse().getNbre_eleves();

            int i = 0;
            while (i < temp.size()) {
                Variable xj = temp.get(i);
                if (xj.getValeur() == null) {
                    temp.remove(xj);
                    continue;
                }

                if (xi.getValeur().prof.equals(xj.getValeur().prof)) {
                    if (xi.getValeur().salle == xj.getValeur().salle) {
                        numbers += xj.getValeur().prof.matiereDuProf.getClasse().getNbre_eleves();
                        temp.remove(xj);
                        --i;
                    } else {
                        return false;
                    }

                } else if (xi.getValeur().salle == xj.getValeur().salle // 2 differents course in the same classroom at the same time
                        || xi.getValeur().prof == xj.getValeur().prof) { // Or directed by the same teacher at the same time
                    return false;
                }

                ++i;
            }

            if (numbers > xi.getValeur().salle.getCapacite()) {
                return false;
            }
        }
        return true;
        }
    }

    @Override
    public boolean contiens(Variable x) {
        return (listVariables.contains(x)); 
    }
    
    
}
