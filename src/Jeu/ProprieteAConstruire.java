package Jeu;



import java.util.ArrayList;




public class ProprieteAConstruire extends CarreauPropriete {
    
	private int nbMaisons = 0;
	private int nbHotels = 0;
	private ArrayList<Integer> loyerMaison;
	private Groupe groupePropriete;

    public ProprieteAConstruire(ArrayList<Integer> loyerMaison, Groupe groupePropriete, int prixAchat, Joueur proprietaire, int numero, String nomCarreau, Monopoly monopoly) {
        super(prixAchat, proprietaire, numero, nomCarreau, monopoly);
        this.loyerMaison = loyerMaison;
        this.groupePropriete = groupePropriete;
    }
        
        
        
}