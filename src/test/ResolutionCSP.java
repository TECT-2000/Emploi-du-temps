/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mike Tsebo
 */
public class ResolutionCSP {

    public static int nbreVar = 18;
    public static ArrayList<Classe> classes;
    public static Jour[] semaine = {Jour.Lundi, Jour.Mardi, Jour.Mercredi, Jour.Jeudi, Jour.Vendredi};
    public static ArrayList<Salle> salles;
    public static ArrayList<UE> cours;
    public static ArrayList<Professeur> professeurs = new ArrayList<>();
    ArrayList<Domaine> domainesFiltres = new ArrayList<>();

    public void main() {
        CSP csp = creerCSP();
        ArrayList<Affectation> A = new ArrayList<Affectation>(0);
        boolean resultat = testerPuisEnumerer(A, csp);
        if (!resultat) {
            System.out.println(" ");
            System.out.println("// ECHEC //");
            System.out.println(" ");
        }
    }

    public CSP creerCSP() {
        classes = new ArrayList<Classe>(0);
        salles = new ArrayList<Salle>(0);
        cours = new ArrayList<UE>(0);

        /*
          Debut Donnees de Test 
         */
        UE ihm = new UE("IHM");
        UE grammaires = new UE("Grammaires");
        UE anglais = new UE("Anglais");
        UE IA = new UE("IA");
        UE progWeb = new UE("Programmation Web");
        UE analyse = new UE("Analyse des données");
        UE reseau = new UE("Réseaux");
        UE electronique = new UE("Electronique");
        UE management = new UE("Management");

        Salle s0 = new Salle("S0", 45);
        Salle s1 = new Salle("S1", 60);

        Professeur batch = new Professeur("Batchakui", ihm);
        Professeur fouda = new Professeur("Fouda", management);
        Professeur kouamou = new Professeur("Kouamou", grammaires);
        Professeur mbouh = new Professeur("Mbouh", IA);
        Professeur chana = new Professeur("Chana", electronique);
        Professeur nashipu = new Professeur("Nashipu", anglais);
        Professeur toussile = new Professeur("Toussile", analyse);
        Professeur djotio = new Professeur("Djotio", reseau);
        Professeur kenfack = new Professeur("Kenfack", progWeb);

        professeurs.add(batch);
        professeurs.add(fouda);
        professeurs.add(mbouh);
        professeurs.add(kouamou);
        professeurs.add(kenfack);
        professeurs.add(chana);
        professeurs.add(djotio);
        professeurs.add(nashipu);
        professeurs.add(toussile);

        mbouh.preferences.add(new Preferences(s0.getNom(), "Lundi", 1));
        mbouh.preferences.add(new Preferences(s0.getNom(), "Vendredi", 1));
        mbouh.preferences.add(new Preferences(s0.getNom(), "Mardi", 3));

        batch.preferences.add(new Preferences(s1.getNom(), "Lundi", 0));
        batch.preferences.add(new Preferences(s1.getNom(), "Lundi", 1));
        batch.preferences.add(new Preferences(s1.getNom(), "Lundi", 2));
        batch.preferences.add(new Preferences(s1.getNom(), "Lundi", 3));

        batch.preferences.add(new Preferences(s1.getNom(), "Jeudi", 0));
        batch.preferences.add(new Preferences(s0.getNom(), "Jeudi", 1));
        batch.preferences.add(new Preferences(s1.getNom(), "Jeudi", 2));
        batch.preferences.add(new Preferences(s0.getNom(), "Jeudi", 3));

        Classe _4gi = new Classe(34, "4GI");
        ihm.setClasse(_4gi);
        analyse.setClasse(_4gi);
        anglais.setClasse(_4gi);
        grammaires.setClasse(_4gi);
        IA.setClasse(_4gi);
        progWeb.setClasse(_4gi);
        electronique.setClasse(_4gi);
        management.setClasse(_4gi);
        reseau.setClasse(_4gi);

        classes.add(_4gi);
        salles.add(s0);
        salles.add(s1);

        cours.add(grammaires);
        cours.add(grammaires);
        cours.add(electronique);
        cours.add(electronique);
        cours.add(analyse);
        cours.add(analyse);
        cours.add(IA);
        cours.add(IA);
        cours.add(management);
        cours.add(management);
        cours.add(ihm);
        cours.add(ihm);
        cours.add(reseau);
        cours.add(reseau);
        cours.add(progWeb);
        cours.add(progWeb);
        cours.add(anglais);
        cours.add(anglais);

        /*
         Fin Donnees de Test 
         */
        
        ArrayList<Variable> X = new ArrayList<Variable>(0);
        ArrayList<Domaine> domaines = new ArrayList<Domaine>(0);
        ArrayList<Contrainte> C = new ArrayList<Contrainte>(0);

        for (Classe c : classes) {
            for (Jour d : semaine) {
                for (int h = 0; h < 4; ++h) {

                    
                    Variable var = new Variable(d, h);
                    var.index = X.size();
                    X.add(var);

                    
                    ArrayList<Valeur> valeurs = new ArrayList<Valeur>(0);
                    for (Professeur tu : professeurs) {
                        for (Salle cr : salles) {
                            if (tu.matiereDuProf.classe == c) {
                                valeurs.add(new Valeur(tu, cr));

                            }
                        }
                    }
                    Domaine domaine = new Domaine(valeurs);
                    domaines.add(domaine);

                    C.add(new ContrainteUnaire(var));

                    if (d == Jour.Mercredi && h == 1) {
                        break;
                    }
                }
            }
        }
        //ajout des containtes N_aires
        ArrayList<Variable> temp = new ArrayList<Variable>(X);
        while (!temp.isEmpty()) {
            Variable xi = temp.get(0);
            int i = 0;
            ArrayList<Variable> listXi = new ArrayList<Variable>(classes.size());
            listXi.add(xi);
            temp.remove(xi);
            while (i < temp.size()) {
                Variable xj = temp.get(i);
                if (xi.jour == xj.jour && xi.heure == xj.heure) {
                    listXi.add(xj);
                    temp.remove(xj);
                    --i;
                }
                ++i;
            }
            C.add(new ContrainteN_aire(listXi));
        }

        return new CSP(X, domaines, C);
    }

    /// TesterPuisEnumerer ///
    public boolean testerPuisEnumerer(ArrayList<Affectation> Aff, CSP csp) {
        if (Aff.size() == csp.ensX.size()) { // csp résolu
            System.out.println(" ");
            System.out.println("// SUCCES //");
            System.out.println(" ");
            EcrireDansLeFichier(csp.ensX); // mettre le résultat dans le fichier
            return true;
        } else {
            Variable xi = prendreProchaineVariable(csp);

            for (Valeur vi : csp.D(xi)) {
                xi.assigner(vi);
                System.out.println(xi + " <- " + vi);
                domainesFiltres = copieDuDomaine(csp.domaines);
                for (Variable xj : csp.ensX) {
                    if (xj.getValeur() != null) {
                        continue;
                    }
                    ArrayList<Valeur> valAenlever = new ArrayList<>();
                    for (Valeur vj : csp.D(xj)) {
                        xj.assigner(vj);
                        if (!consistance(Aff, csp.ensC) || (vi.prof == vj.prof && vi.salle == vj.salle)) {
                            System.out.println("Enlever " + vj + " de D(" + xj + ")");
                            valAenlever.add(vj);
                        }

                    }
                    domainesFiltres.get(xj.index).valeurs.removeAll(valAenlever);
                    xj.nePasAssigner();
                    System.out.println(domainesFiltres.get(xj.index).valeurs);

                    if (domainesFiltres.get(xj.index).valeurs.isEmpty()) {
                        break;
                    }
                }
                ArrayList<Affectation> nouveauA = (new ArrayList<Affectation>(Aff));
                nouveauA.add(new Affectation(xi, vi));

                if (testerPuisEnumerer(nouveauA, new CSP(csp.ensX, domainesFiltres, csp.ensC)) == true) {
                    return true;
                }
            }
            xi.nePasAssigner();
            System.out.println("Faux!!!");
            return false;
        }
    }

    ///Fin de TestPuisEnumerer ///
    //sélectionne la prochaine variable Xj
    public Variable prendreProchaineVariable(CSP csp) {
        int i = 0;
        while (i < nbreVar) {
            for (int j = 0; j < classes.size(); ++j) {
                Variable xj = csp.ensX.get(i + j * nbreVar);
                if (xj.getValeur() == null) {
                    return xj;
                }
            }
            ++i;
        }
        return null;
    }

    //vérifie la consistance
    public boolean consistance(ArrayList<Affectation> A, ArrayList<Contrainte> C) {
        for (Contrainte c : C) {
            if (!c.satisfaite()) {
                return false;
            }
        }
        return true;
    }

    //permet de copier le domaine afin de modifier la copie
    public ArrayList<Domaine> copieDuDomaine(ArrayList<Domaine> domains) {
        ArrayList<Domaine> copie = new ArrayList<Domaine>(domains.size());
        for (Domaine d : domains) {
            copie.add(new Domaine(d.valeurs));
        }
        return copie;
    }

    //écris le résultat dans un fichier
    public void EcrireDansLeFichier(ArrayList<Variable> var) {

        try {
            int i = 0;
            for (Classe c : classes) {
                PrintWriter writer = new PrintWriter(new FileWriter("emploi.csv"));
                writer.println(" ; 8h00-10h00; 10h00-12h00; 14h00-16h00; 16h00-18h00");
                for (Jour d : semaine) {
                    writer.print(d);
                    for (int h = 0; h < 4; ++h) {
                        Variable x = var.get(i++);
                        writer.print(";" + x.getValeur().prof.matiereDuProf.getNom() + " : " + x.getValeur().prof.getNom() + "(" + x.getValeur().salle.getNom() + ")");
                        // If it's Wednesday then there is only two hours
                        if (d == Jour.Mercredi && h == 1) {
                            break;
                        }
                    }
                    writer.println();
                }
                writer.close();
                System.out.println("Le fichier emploi.csv a été généré avec succès et se trouve à la racine du projet");
                System.out.println(" ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
