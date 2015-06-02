package Jeu;

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
            System.out.println(j.getNom() + " lance les dés : " +d1 + "+" + d2 + " (" +d + ") et arrive sur la case " + j.getPositionCourante().getNomCarreau());
        }
        
        public void afficheJoueur(Joueur j){
            System.out.println("-------------------------------------------------------------");
            System.out.println("Joueur : " + j.getNom());
            System.out.println("Cash : " + j.getCash() +"€");
            System.out.println("Position : " + j.getPositionCourante().getNomCarreau());
            System.out.println("Propriété(s) : " + j.getProprietesAConstruire().size());
            System.out.println("Compagnie(s) : " + j.getCompagnies().size());
            System.out.println("Gare(s) : " + j.getGares().size());
            System.out.println("-------------------------------------------------------------");
        }
        
        
        
        
        
        
        
}