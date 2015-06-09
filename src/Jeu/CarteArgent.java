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
public class CarteArgent extends Carte{
    
    private int montant;
    

    //builder
    
    public CarteArgent(String carte,int montant, Monopoly monopoly) {
        super(carte, monopoly);
        setMontant(montant);
    }
    
    //getters et setters
    
    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    @Override
    public void action(Joueur j) {
        j.setCash(j.getCash()+montant);
    }
    
}
