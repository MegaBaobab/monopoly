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
public class CarteMouvementAbsolu extends Carte {
    
    private Carreau carreau;

    //builder
    
    public CarteMouvementAbsolu(String carte, Carreau c, Monopoly monopoly) {
        super(carte, monopoly);
        setCarreau(c);
    }

    //getters et setters
    
    public Carreau getCarreau() {
        return carreau;
    }

    public void setCarreau(Carreau carreau) {
        this.carreau = carreau;
    }

    @Override
    public void action(Joueur j) {
       if(getCarreau().getNumero() == 1){
            getMonopoly().getInterface0().allerDepart(j);
            j.setCash(j.getCash() + 200);
        }
        else if(getCarreau().getNumero() == 11){
            getMonopoly().getInterface0().allerPrison(j);
            getMonopoly().allerEnPrison(j);
        }
        else if(getCarreau().getNumero() == 25 && j.getPositionCourante().getNumero()>25){
            getMonopoly().getInterface0().allerCarreau(getCarreau(),j);
            j.setCash(j.getCash() + 200);
        }
        else {
            getMonopoly().getInterface0().allerCarreau(getCarreau(),j);
        }
        j.setPositionCourante(getCarreau());
    }
 
    
    
}
