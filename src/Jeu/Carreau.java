package Jeu;

public abstract class Carreau {
	private int numero;
	private String nomCarreau;
	private Monopoly monopoly;

	public int getNum() {
		throw new UnsupportedOperationException();
	}

	public void operation() {
		throw new UnsupportedOperationException();
	}

	public int getnb() {
		throw new UnsupportedOperationException();
	}

    public Carreau(int numero, String nomCarreau, Monopoly monopoly) {
        this.numero = numero;
        this.nomCarreau = nomCarreau;
        this.monopoly = monopoly;
    }
        
}