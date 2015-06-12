package Jeu;

public class CarreauArgent extends CarreauAction {
	private int montant;

    public CarreauArgent(int montant, int numero, String nomCarreau, Monopoly monopoly) {
        super(numero, nomCarreau, monopoly);
        this.montant = montant;
    }

    @Override
    public void action(Joueur j, int des) {
        j.setCash(j.getCash() + montant);
        if(getNumero()!=11){
            getMonopoly().getInterface0().argent(montant);
        }
        
    }
        
        
}