package Jeu;

import java.util.ArrayList;

public class Joueur {
	private String nomJoueur;
	private int cash = 1500;
	private Monopoly monopoly;
	private ArrayList<Compagnie> compagnies;
	private ArrayList<Gare> gares ;
	private Carreau positionCourante;
	private ArrayList<ProprieteAConstruire> proprietesAConstruire ;

	public Carreau getPosition() {
		throw new UnsupportedOperationException();
	}

	public String getNom() {
		throw new UnsupportedOperationException();
	}

    public Joueur(String nomJoueur, Monopoly monopoly) {
        this.nomJoueur = nomJoueur;
        this.monopoly = monopoly;
        compagnies = new ArrayList<Compagnie>();
        gares = new ArrayList<Gare>();
        proprietesAConstruire = new ArrayList<ProprieteAConstruire>();
        positionCourante = null;
    }
        
        
}