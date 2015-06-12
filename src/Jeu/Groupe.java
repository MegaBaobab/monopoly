package Jeu;

import java.util.ArrayList;

public class Groupe {
	private int prixAchatMaison;
	private int prixAchatHotel;
	private CouleurPropriete couleur;
	private ArrayList<ProprieteAConstruire> proprietes;
        
        
    public Groupe(int prixAchatMaison, int prixAchatHotel, CouleurPropriete couleur) {
        this.prixAchatMaison = prixAchatMaison;
        this.prixAchatHotel = prixAchatHotel;
        this.couleur = couleur;
        proprietes = new ArrayList<ProprieteAConstruire>();
    }

    public void ajouterPropriete(ProprieteAConstruire p){
        proprietes.add(p);
    }

    public CouleurPropriete getCouleur() {
        return couleur;
    }

    public int getPrixAchatMaison() {
        return prixAchatMaison;
    }

    public void setPrixAchatMaison(int prixAchatMaison) {
        this.prixAchatMaison = prixAchatMaison;
    }

    public int getPrixAchatHotel() {
        return prixAchatHotel;
    }

    public void setPrixAchatHotel(int prixAchatHotel) {
        this.prixAchatHotel = prixAchatHotel;
    }

    public ArrayList<ProprieteAConstruire> getProprietes() {
        return proprietes;
    }

    public void setProprietes(ArrayList<ProprieteAConstruire> proprietes) {
        this.proprietes = proprietes;
    }
    
    public int getNbMaisonTotal(){
        int rep = 0;
        for(ProprieteAConstruire p : getProprietes()){
            rep = rep + p.getNbMaisons();
            rep = rep + 5*p.getNbHotels();
        }
        return rep;
    }

}