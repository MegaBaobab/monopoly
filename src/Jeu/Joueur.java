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
            return positionCourante;
        }

    public void setPositionCourante(Carreau positionCourante) {
        this.positionCourante = positionCourante;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public int getCash() {
        return cash;
    }

    public Monopoly getMonopoly() {
        return monopoly;
    }

    public ArrayList<Compagnie> getCompagnies() {
        return compagnies;
    }

    public ArrayList<Gare> getGares() {
        return gares;
    }

    public Carreau getPositionCourante() {
        return positionCourante;
    }

    public ArrayList<ProprieteAConstruire> getProprietesAConstruire() {
        return proprietesAConstruire;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public void setMonopoly(Monopoly monopoly) {
        this.monopoly = monopoly;
    }

    public void setCompagnies(ArrayList<Compagnie> compagnies) {
        this.compagnies = compagnies;
    }

    public void setGares(ArrayList<Gare> gares) {
        this.gares = gares;
    }

    public void setProprietesAConstruire(ArrayList<ProprieteAConstruire> proprietesAConstruire) {
        this.proprietesAConstruire = proprietesAConstruire;
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