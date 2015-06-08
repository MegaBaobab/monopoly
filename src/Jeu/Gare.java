package Jeu;

public class Gare extends CarreauPropriete {
    private int loyerBase;

    public Gare(int loyerBase, int prixAchat, Joueur proprietaire, int numero, String nomCarreau, Monopoly monopoly) {
        super(prixAchat, proprietaire, numero, nomCarreau, monopoly);
        this.loyerBase = loyerBase;
    }

    @Override
    public void action(Joueur j, int des) {
        if(getProprietaire() == null){
            if(j.getCash() >= getPrixAchat()){
                if(getMonopoly().getInterface0().vente(j, getPrixAchat())){
                    j.setCash(j.getCash() - getPrixAchat());
                    setProprietaire(j);
                    j.getGares().add(this);
                }
                
            }else getMonopoly().getInterface0().pauvre();
        }else {
            j.setCash(j.getCash() - 25*getProprietaire().getGares().size());
            getProprietaire().setCash(getProprietaire().getCash() + 25*getProprietaire().getGares().size());
        }
    }

    
    
}