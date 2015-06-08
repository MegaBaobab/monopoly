package Jeu;

public abstract class Carreau {
	private int numero;
	private String nomCarreau;
	private Monopoly monopoly;

	

    public int getNumero() {
        return numero;
    }

    public String getNomCarreau() {
        return nomCarreau;
    }

    public Monopoly getMonopoly() {
        return monopoly;
    }

        
        
    public Carreau(int numero, String nomCarreau, Monopoly monopoly) {
        this.numero = numero;
        this.nomCarreau = nomCarreau;
        this.monopoly = monopoly;
    }
    
    public abstract void action(Joueur j, int des);   
    
    
}