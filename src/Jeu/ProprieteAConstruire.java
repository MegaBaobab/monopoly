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
        else if(getProprietaire() == j){
            construire(j);
        }
        else{
            getMonopoly().getInterface0().payer(this, j, des);
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
    
    public Joueur getProprietaire(){
        return super.getProprietaire();
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
    
   
    

        
    public int loyerProprieteAConstruire(Joueur j){
               
        if(getNbHotels() == 1){
                j.setCash(j.getCash() - getLoyerMaison().get(5));
                return getLoyerMaison().get(5);
            }else {
                j.setCash(j.getCash() - getLoyerMaison().get(nbMaisons));
                return getLoyerMaison().get(nbMaisons);
            }
        
    }    
    
    public void construire(Joueur j){
        if(proprioDuGroupe(j)){ 
            boolean rep = true;
            while(rep){
            int moy = getGroupePropriete().getNbMaisonTotal()/getGroupePropriete().getProprietes().size();
            if(moy == 4){
                if(j.getCash() > getGroupePropriete().getPrixAchatHotel() && getMonopoly().getNbHotels() > 0){
                rep = getMonopoly().getInterface0().construire(this,true);
                if(rep){
                j.setCash(j.getCash() - getGroupePropriete().getPrixAchatHotel());
                    ArrayList<ProprieteAConstruire> temp = new ArrayList<>();
                    for(ProprieteAConstruire p : getGroupePropriete().getProprietes()){
                        if(p.getNbMaisons() == moy){
                            temp.add(p);
                        }
                    }
                    ProprieteAConstruire choix = getMonopoly().getInterface0().choixConstruction(temp);
                    choix.setNbMaisons(choix.getNbMaisons() + 1);
                }
                    
                }
            }
            else if(moy < 4) {
                if(j.getCash() > getGroupePropriete().getPrixAchatMaison() && getMonopoly().getNbMaisons() > 0){
                    rep = getMonopoly().getInterface0().construire(this,false);
                    if(rep){
                    j.setCash(j.getCash() - getGroupePropriete().getPrixAchatMaison());
                    ArrayList<ProprieteAConstruire> temp = new ArrayList<>();
                    for(ProprieteAConstruire p : getGroupePropriete().getProprietes()){
                        if(p.getNbMaisons() == moy){
                            temp.add(p);
                        }
                    }
                    ProprieteAConstruire choix = getMonopoly().getInterface0().choixConstruction(temp);
                    choix.setNbMaisons(choix.getNbMaisons() + 1);
                    }
                }   
            }
            else if(moy == 5){
                getMonopoly().getInterface0().groupePlein(getGroupePropriete());
            }
            }
            
        }
    }
        
    
    public boolean proprioDuGroupe(Joueur j){
        int total = 0;
        int oui = 0;
        for(ProprieteAConstruire p : getGroupePropriete().getProprietes()){
            if(p.getProprietaire() == j){
                oui++;
            }
                total++;
        }
        return (total==oui);
    }
}