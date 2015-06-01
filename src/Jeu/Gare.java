package Jeu;

public class Gare extends CarreauPropriete {
    private int loyerBase;

    public Gare(int loyerBase, int prixAchat, Joueur proprietaire, int numero, String nomCarreau, Monopoly monopoly) {
        super(prixAchat, proprietaire, numero, nomCarreau, monopoly);
        this.loyerBase = loyerBase;
    }
    
    
}