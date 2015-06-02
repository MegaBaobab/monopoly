package Jeu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;



public class Monopoly {
    
    /* Attributs */
    private ArrayList<Carreau> carreaux;
    private int nbMaisons = 32;
    private int nbHotels = 12;
	private ArrayList<Joueur> joueurs; 
	public Interface interface0;
    private HashMap<CouleurPropriete,Groupe> groupes;

    /* Builder */
        
	public Monopoly(String dataFilename){
            carreaux = new ArrayList();
            joueurs = new ArrayList<Joueur>();
            groupes = new HashMap();
            interface0 = new Interface();
		buildGamePlateau(dataFilename);
	}

        
    /* Méthodes */
	private void buildGamePlateau(String dataFilename)
	{
		try{
			ArrayList<String[]> data = readDataFile(dataFilename, ",");
			
			
                        
                        
                        
                        
			for(int i=0; i<data.size(); ++i){
				String caseType = data.get(i)[0];
				if(caseType.compareTo("P") == 0){
					System.out.println("Propriété :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        ArrayList a = new ArrayList();
                                        for(int y=5; y<11; y++){
                                          a.add(Integer.parseInt(data.get(i)[y]));  
                                        }
                                        
                                        
                                        if(groupes.containsKey(CouleurPropriete.valueOf(data.get(i)[3]))){
                                            carreaux.add(new ProprieteAConstruire(a, getGroupe(CouleurPropriete.valueOf(data.get(i)[3])),
                                                    Integer.parseInt(data.get(i)[5]),
                                                    null, Integer.parseInt(data.get(i)[1]),
                                                    data.get(i)[2] , this));
                                        }
                                        else{
                                            carreaux.add(new ProprieteAConstruire(a,
                                                    new Groupe(Integer.parseInt(data.get(i)[11]),Integer.parseInt(data.get(i)[12]),CouleurPropriete.valueOf(data.get(i)[3])),
                                                    Integer.parseInt(data.get(i)[5]),
                                                    null, Integer.parseInt(data.get(i)[1]),
                                                    data.get(i)[2] ,this));
                                        }
                                        
				}
				else if(caseType.compareTo("G") == 0){
					System.out.println("Gare :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        carreaux.add(new Gare(25, Integer.parseInt(data.get(i)[3]), null, Integer.parseInt(data.get(i)[1]), data.get(i)[2], this));
				}
				else if(caseType.compareTo("C") == 0){
					System.out.println("Compagnie :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        carreaux.add(new Compagnie(Integer.parseInt(data.get(i)[3]), null, Integer.parseInt(data.get(i)[1]), data.get(i)[2], this));
				}
				else if(caseType.compareTo("CT") == 0){
					System.out.println("Case Tirage :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        carreaux.add(new CarreauTirage(Integer.parseInt(data.get(i)[1]), data.get(i)[2], this));
				}
				else if(caseType.compareTo("CA") == 0){
					System.out.println("Case Argent :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        carreaux.add(new CarreauArgent(Integer.parseInt(data.get(i)[3]), Integer.parseInt(data.get(i)[1]), data.get(i)[2], this));
				}
				else if(caseType.compareTo("CM") == 0){
					System.out.println("Case Mouvement :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        carreaux.add(new CarreauMouvement(Integer.parseInt(data.get(i)[1]), data.get(i)[2], this));
				}
				else
					System.err.println("[buildGamePleateau()] : Invalid Data type");
			}
			
		} 
		catch(FileNotFoundException e){
			System.err.println("[buildGamePlateau()] : File is not found!");
		}
		catch(IOException e){
			System.err.println("[buildGamePlateau()] : Error while reading file!");
		}
	}
	
	private ArrayList<String[]> readDataFile(String filename, String token) throws FileNotFoundException, IOException
	{
		ArrayList<String[]> data = new ArrayList<String[]>();
		
		BufferedReader reader  = new BufferedReader(new FileReader(filename));
		String line = null;
		while((line = reader.readLine()) != null){
			data.add(line.split(token));
		}
		reader.close();
		
		return data;
	}
        
        
        public void initialiserPartie(){
            int i = 0;
            
            while (i>6 || i<2) {
            i = interface0.nbJoueur();
            }
            
            for (int y=1; y<=i; y++){
                String nom = interface0.saisieJoueur(y);
                joueurs.add(new Joueur(nom, this));
            }
            
            
        }
        
        
        
        public int des6(){
            Random r = new Random();
            return r.nextInt(6)+1;
        }
        
        public Groupe getGroupe(CouleurPropriete c){
            return groupes.get(c);
        }
        
        public Carreau getCarreau(int i){
            return carreaux.get(i -1);
        }
        
        
        public void jouerUnCoup(Joueur j){
            int d1 = des6();
            int d2 = des6();
            
            j.setPositionCourante(getCarreau(j.getPosition().getNum() + d1 + d2));
            interface0.afficheDes(j,d1,d2);
            interface0.afficheJoueur(j);
            
        }
        
}

