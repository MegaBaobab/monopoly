package Jeu;

public abstract class CarreauPropriete extends Carreau {
	
	private int prixAchat;
	private Joueur proprietaire;

    public CarreauPropriete( int prixAchat, Joueur proprietaire, int numero, String nomCarreau, Monopoly monopoly) {
        super(numero, nomCarreau, monopoly);
        this.prixAchat = prixAchat;
        this.proprietaire = proprietaire;
    }
        
        
}