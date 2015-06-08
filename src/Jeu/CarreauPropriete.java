package Jeu;

public abstract class CarreauPropriete extends Carreau {
	
	private int prixAchat;
	private Joueur proprietaire;

    public CarreauPropriete( int prixAchat, Joueur proprietaire, int numero, String nomCarreau, Monopoly monopoly) {
        super(numero, nomCarreau, monopoly);
        this.prixAchat = prixAchat;
        this.proprietaire = proprietaire;
    }

    public int getPrixAchat() {
        return prixAchat;
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    public void setPrixAchat(int prixAchat) {
        this.prixAchat = prixAchat;
    }

    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }
        
        
}