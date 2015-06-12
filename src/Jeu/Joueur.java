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
        private int tourPrison;
        private int nbCartessortiePrison;
        
        
        public Joueur(String nomJoueur, Monopoly monopoly) {
        setNomJoueur(nomJoueur);
        setMonopoly(monopoly);
        setCompagnies(new ArrayList<Compagnie>());
        setGares(new ArrayList<Gare>());
        setProprietesAConstruire(new ArrayList<ProprieteAConstruire>());
        setPositionCourante(monopoly.getCarreau(1));
        setTourPrison(0);
        setNbCartessortiePrison(0);
        
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

    public int getTourPrison() {
        return tourPrison;
    }

    public void setTourPrison(int tourPrison) {
        this.tourPrison = tourPrison;
    }

    public int getNbCartessortiePrison() {
        return nbCartessortiePrison;
    }

    public void setNbCartessortiePrison(int nbCartessortiePrison) {
        this.nbCartessortiePrison = nbCartessortiePrison;
    }
        
        

    
      
    public int nbMaisons(){
        int nb = 0;
        for(ProprieteAConstruire p : getProprietesAConstruire()){
            nb = nb + p.getNbMaisons();
        }
        return nb;
    }
    
    public int nbHotels(){
        int nb = 0;
        for(ProprieteAConstruire p : getProprietesAConstruire()){
            nb = nb + p.getNbHotels();
        }
        return nb;
    
    }
}
        
