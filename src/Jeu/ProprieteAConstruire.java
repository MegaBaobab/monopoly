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

    @Override
    public void action(Joueur j, int des) {
        if(getProprietaire() == null){
            if(j.getCash() >= getPrixAchat()){
                if(getMonopoly().getInterface0().vente(j, getPrixAchat())){
                    j.setCash(j.getCash() - getPrixAchat());
                    setProprietaire(j);
                    j.getProprietesAConstruire().add(this);
                }
                
            }else getMonopoly().getInterface0().pauvre();
        }
    }

    public int getNbMaisons() {
        return nbMaisons;
    }

    public void setNbMaisons(int nbMaisons) {
        this.nbMaisons = nbMaisons;
    }

    public int getNbHotels() {
        return nbHotels;
    }

    public void setNbHotels(int nbHotels) {
        this.nbHotels = nbHotels;
    }

    public ArrayList<Integer> getLoyerMaison() {
        return loyerMaison;
    }

    public void setLoyerMaison(ArrayList<Integer> loyerMaison) {
        this.loyerMaison = loyerMaison;
    }

    public Groupe getGroupePropriete() {
        return groupePropriete;
    }

    public void setGroupePropriete(Groupe groupePropriete) {
        this.groupePropriete = groupePropriete;
    }

        
        
        
}