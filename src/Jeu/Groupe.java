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

}