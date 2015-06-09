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
public class CarteMouvementRelatif extends Carte {
    
    private int nbcases;

    //builder
    
    public CarteMouvementRelatif(String carte,int nbcases, Monopoly monopoly) {
        super(carte, monopoly);
        setNbcases(nbcases);
    }

    //getters et setters
    
    public int getNbcases() {
        return nbcases;
    }

    public void setNbcases(int nbcases) {
        this.nbcases = nbcases;
    }

    @Override
    public void action(Joueur j) {
        j.setPositionCourante(getMonopoly().getCarreau(j.getPositionCourante().getNumero() + getNbcases()));
    }
    
    
}
