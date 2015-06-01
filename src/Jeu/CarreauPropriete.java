package Jeu;

public abstract class CarreauPropriete extends Carreau {
	private int loyerBase;
	private int prixAchat;
	private Joueur proprietaire;

    public CarreauPropriete(int loyerBase, int prixAchat, Joueur proprietaire, int numero, String nomCarreau, Monopoly monopoly) {
        super(numero, nomCarreau, monopoly);
        this.loyerBase = loyerBase;
        this.prixAchat = prixAchat;
        this.proprietaire = proprietaire;
    }
        
        
}