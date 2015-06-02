package Jeu;


public class Main {

	public static void main(String[] args) {
		Monopoly m = new Monopoly("src/Data/data.txt");
                m.initialiserPartie();
                for(Joueur j : m.getJoueurs()){
                    m.jouerUnCoup(j);
                }
	}

}
