package Jeu;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Scanner;

public class Interface {
	public Monopoly monopoly;

	public void affiche() {
	}

	public void affiche(String aNom, Object aDe, String aNomc) {
	}
        
        public String saisieJoueur(int i){
            String n = null;
            Scanner entree = new Scanner(System.in);
            System.out.println("Nom du joueur " + i +": ");
            n=entree.nextLine();
            
            return n;
        }
        
        public int nbJoueur(){
            int i;
            Scanner entree = new Scanner(System.in);
            System.out.println("Veuillez entrer le nombre de joueurs participants");
            i=entree.nextInt();
            
            return i;
        }

    public Interface(Monopoly monopoly) {
        this.monopoly = monopoly;
    }
        
        public void afficheDes(Joueur j, int d1, int d2){
            int d = d1+d2;
            System.out.println(j.getNomJoueur()+ " lance les dés : " +d1 + "+" + d2 + " (" +d + ") et arrive sur la case " + j.getPositionCourante().getNomCarreau());
        }
        
        public void afficheJoueur(Joueur j){
            System.out.println("-------------------------------------------------------------");
            System.out.println("Joueur : " + j.getNomJoueur());
            System.out.println("Cash : " + j.getCash() +"€");
            if(j.getPositionCourante().getNumero() != 11){
            System.out.println("Position : " + j.getPositionCourante().getNomCarreau());
            }else if(j.getTourPrison()==0){
                System.out.println("Position : \033[32mSimple Visite\033[0m / En Prison");
            }else{
                System.out.println("Position : Simple Visite / \033[31mEn Prison\033[0m");
            }
            System.out.println("Propriété(s) : ");
            for(ProprieteAConstruire p : j.getProprietesAConstruire()){
                System.out.println(p.getNomCarreau() +"("+ p.getGroupePropriete().getCouleur() +")" + " : " + p.getNbMaisons() + " maisons et " + p.getNbHotels() + " hotels");
            }
            System.out.println("Compagnie(s) : ");
            for(Compagnie c : j.getCompagnies()){
                System.out.println(c.getNomCarreau());
            }
            System.out.println("Gare(s) : ");
            for(Gare g : j.getGares()){
                System.out.println(g.getNomCarreau());
            }
            System.out.println("Nombre de carte sortie de prison : " + j.getNbCartessortiePrison());
            System.out.println("-------------------------------------------------------------");
        }
        
        public boolean vente(Joueur j, int prix){
            System.out.println("Voulez vous acheter " + j.getPositionCourante().getNomCarreau() + " au prix de " + prix +"€");
            System.out.println("1-OUI  2-NON");
            Scanner entree = new Scanner(System.in);
            int i=entree.nextInt();
            if(i==1){
                return true;
            }else {
                return false;
            }
        }
        
        public void pauvre(){
            System.out.println("Désolé mais tu n'es pas assez riche pour acheter cette case.");
        }
        
        
        
        public void allerDepart(){
            System.out.println("Vous vous rendez sur la case départ");
        }
        
        public void allerPrison(){
            System.out.println("Vous vous rendez en prison");
        }
        
        public void allerCarreau(Carreau c){
            System.out.println("Vous vous rendez sur la case : " + c.getNomCarreau());
        }
        
        public boolean carteSortiePrison(){
            System.out.println("Voulez vous utiliser une carte sortie de prison ?");
            System.out.println("1-OUI  2-NON");
            Scanner entree = new Scanner(System.in);
            int i=entree.nextInt();
            if(i==1){
                return true;
            }else {
                return false;
            }
        }
        
        public void argent(int m){
            if(m<0){
                System.out.println("Vous payer " + abs(m) + "€");
            }else{
                System.out.println("Vous recevez " + m + "€");
            }
        }
        
        public void payer(Carreau c, Joueur j, int des){
            if(c instanceof ProprieteAConstruire){
                ProprieteAConstruire p = (ProprieteAConstruire) c;
                System.out.println("Cette propriété appartient à " + p.getProprietaire().getNomJoueur() + ", vous lui reversez " + p.loyerProprieteAConstruire(j) +"€");
            }
            else if(c instanceof Gare){
                Gare g = (Gare) c;
                System.out.println("Cette gare appartient à " + g.getProprietaire().getNomJoueur() + ", vous lui reversez " + g.loyerGare(j) +"€");
            }
            else if(c instanceof Compagnie){
                Compagnie co = (Compagnie) c;
                System.out.println("Cette compagnie appartient à " + co.getProprietaire().getNomJoueur() + ", vous lui reversez " + co.loyerCompagnie(j,des) +"€");
            }
            
        }
        
        public void resterPrison(int d1, int d2){
            int d = d1+d2;
            System.out.println(d1 + "+" + d2 + "(" + d + ") dommage pas de double, vous restez en prison !");
        }
        
        public void afficheTirage(Carte c){
            System.out.println(c.getNomCarte());
        }
        
        public void doublesPrison(int d1, int d2){
            int d = d1+d2;
            System.out.println(d1 + "+" + d2 + "(" + d + ") Vous avez fait 3 doubles d'affilés, vous allez en prison");
        }
        
        public boolean construire(ProprieteAConstruire p, boolean b){
            if(!b){
                System.out.println("Construire une maison au prix de " + p.getGroupePropriete().getPrixAchatMaison());
                System.out.println("1-OUI  2-NON");
                Scanner entree = new Scanner(System.in);
                int i=entree.nextInt();
                if(i==1){
                    return true;
                }else {
                    return false;
                }
            }
            else{
                System.out.println("Construire un hotel au prix de " + p.getGroupePropriete().getPrixAchatHotel());
                System.out.println("1-OUI  2-NON");
                Scanner entree = new Scanner(System.in);
                int i=entree.nextInt();
                if(i==1){
                    return true;
                }else {
                    return false;
                }
            }
        }
        
        public ProprieteAConstruire choixConstruction(ArrayList<ProprieteAConstruire> c){
            int i = 1;
            System.out.println("Sur quel carreau désirez vous construire : ");
            for(ProprieteAConstruire choix : c){
                System.out.println(i + "-" + choix.getNomCarreau());
                i++;
            }
            System.out.println("Choix : ");
            Scanner entree = new Scanner(System.in);
            int ch=entree.nextInt();
            return c.get(ch - 1);
            
        }
        
        public void groupePlein(Groupe g){
            System.out.println("Le groupe " + g.getCouleur() + " est plein, vous ne pouvez plus construire dessus.");
        }    
        

        
        
} 