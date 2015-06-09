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
public class CarteReparation extends Carte{

    private int montantHotel;
    private int montantMaison;
    
    //builder
    
    public CarteReparation(String carte,int mH, int mM, Monopoly monopoly) {
        super(carte, monopoly);
        setMontantHotel(mH);
        setMontantMaison(mM);
        
    }
    
    //getters et setters

    public int getMontantHotel() {
        return montantHotel;
    }

    public int getMontantMaison() {
        return montantMaison;
    }

    public void setMontantHotel(int montantHotel) {
        this.montantHotel = montantHotel;
    }

    public void setMontantMaison(int montantMaison) {
        this.montantMaison = montantMaison;
    }

    @Override
    public void action(Joueur j) {
        j.setCash(j.getCash()-j.nbMaisons() * getMontantMaison() - j.nbHotels() * getMontantHotel());
    }
    
}
