/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Jeu;

/**
 *
 * @author douillva
 */
public abstract class Carte {
    private String nomCarte;
    private Monopoly monopoly;

    //builder
    
     public Carte( String nomCarte, Monopoly monopoly) {
         setNomCarte(nomCarte);
         setMonopoly(monopoly);
         
    }
    
    
    //getters et setters
     
    public String getNomCarte() {
        return nomCarte;
    }

    public void setNomCarte(String NomCarte) {
        this.nomCarte = NomCarte;
    }

    public Monopoly getMonopoly() {
        return monopoly;
    }

    public void setMonopoly(Monopoly monopoly) {
        this.monopoly = monopoly;
    }
    
    public abstract void action(Joueur j);
    
   
    
    
    
    
    
    
}
