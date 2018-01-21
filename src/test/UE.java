/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Mike Tsebo
 */
public class UE {
    
    public SimpleIntegerProperty id = new SimpleIntegerProperty(this, "id");//pour l'affichage
    public SimpleStringProperty nom = new SimpleStringProperty(this, "nom");
    public Classe classe=new Classe(44,"4GI"); 

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public UE(Integer id,String nom){
        setId(id);
        setNom(nom);
    }
    public UE(String nom){
        setNom(nom);
    }   
    public Integer getId() {
        return id.get();
    }

    public void setId(int id) {
            this.id.set(id);
        }

    public String getNom() {
            return nom.get();
        }

    public void setNom(String name) {
            this.nom.set(name);
        }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

}




















