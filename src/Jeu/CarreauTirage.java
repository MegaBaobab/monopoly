package Jeu;

public class CarreauTirage extends CarreauAction {

    public CarreauTirage(int numero, String nomCarreau, Monopoly monopoly) {
        super(numero, nomCarreau, monopoly);
    }

    @Override
    public void action(Joueur j, int des) {
         if(getNumero() == 3 || getNumero() == 18 || getNumero() == 34){
             getMonopoly().tirerCarteCommunaute().action(j);
         }
         else{
             getMonopoly().tirerCarteChance().action(j);
         }
         
    }

  
    
    
}