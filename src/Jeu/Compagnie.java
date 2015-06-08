package Jeu;

public class Compagnie extends CarreauPropriete {

    public Compagnie(int prixAchat, Joueur proprietaire, int numero, String nomCarreau, Monopoly monopoly) {
        super (prixAchat, proprietaire, numero, nomCarreau, monopoly);
    }

    @Override
    public void action(Joueur j, int des) {
        if(getProprietaire() == null){
            if(j.getCash() >= getPrixAchat()){
                if(getMonopoly().getInterface0().vente(j, getPrixAchat())){
                    j.setCash(j.getCash() - getPrixAchat());
                    setProprietaire(j);
                    j.getCompagnies().add(this);
                }
                
            }else getMonopoly().getInterface0().pauvre();
        }else if(getProprietaire().getCompagnies().size() == 1){
            j.setCash(j.getCash() - 4*des);
            getProprietaire().setCash(getProprietaire().getCash() + 4*des);
        }else {
            j.setCash(j.getCash() - 10*des);
            getProprietaire().setCash(getProprietaire().getCash() + 10*des);
        }
    }

    
    
    
    
}