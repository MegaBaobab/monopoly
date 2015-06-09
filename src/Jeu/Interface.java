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
            if(j.getPositionCourante().getNumero() != 11){
            System.out.println("Position : " + j.getPositionCourante().getNomCarreau());
            }else if(j.getTourPrison()==0){
                System.out.println("Position : \033[32mSimple Visite\033[0m / En Prison");
            }else{
                System.out.println("Position : Simple Visite / \033[31mEn Prison");
            }
            System.out.println("Propriété(s) : " + j.getProprietesAConstruire().size());
            System.out.println("Compagnie(s) : " + j.getCompagnies().size());
            System.out.println("Gare(s) : " + j.getGares().size());
            System.out.println("-------------------------------------------------------------");
        }
        
        public boolean vente(Joueur j, int prix){
            System.out.println("Voulez vous acheter " + j.getPositionCourante().getNomCarreau() + " au prix de " + prix);
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
        
        
        
        
        
}