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
public class CarteAnniversaire extends Carte {

    //builder
    
    public CarteAnniversaire(String carte, Monopoly monopoly) {
        super(carte, monopoly);
    }

    @Override
    public void action(Joueur j) {
        getMonopoly().getInterface0().afficheTirage(this);
        for(Joueur jo : getMonopoly().getJoueurs()){
            if( j != jo){
                j.setCash(j.getCash() + 10);
                jo.setCash(jo.getCash() - 10);
            }
        }
    }
    
    
}

