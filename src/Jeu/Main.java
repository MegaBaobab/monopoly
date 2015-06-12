package Jeu;


public class Main {

	public static void main(String[] args) {
		Monopoly m = new Monopoly("src/Data/data.txt");
                m.initialiserPartie();
                for(int i=0;i<10;i++){
                    m.jouerUnCoup(m.getJoueurs().get(0));
                }
                
	}

}
