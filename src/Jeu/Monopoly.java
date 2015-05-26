package Jeu;

import Data.*;
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

    /* Builder */
        
	public Monopoly(String dataFilename){
		buildGamePlateau(dataFilename);
	}

        
    /* Méthodes */
	private void buildGamePlateau(String dataFilename)
	{
		try{
			ArrayList<String[]> data = readDataFile(dataFilename, ",");
			
			//TODO: create cases instead of displaying
                        
                        Groupe gbf= new Groupe(200,200,CouleurPropriete.bleuFonce);
                        Groupe go= new Groupe(100,100,CouleurPropriete.orange);
                        Groupe gm= new Groupe(50,50,CouleurPropriete.mauve);
                        Groupe gvi= new Groupe(100,100,CouleurPropriete.violet);
                        Groupe gbc= new Groupe(50,50,CouleurPropriete.bleuCiel);
                        Groupe gj= new Groupe(150,150,CouleurPropriete.jaune);
                        Groupe gve= new Groupe(200,200,CouleurPropriete.vert);
                        Groupe gr= new Groupe(150,150,CouleurPropriete.rouge);
                        
                        
			for(int i=0; i<data.size(); ++i){
				String caseType = data.get(i)[0];
				if(caseType.compareTo("P") == 0){
					System.out.println("Propriété :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        carreaux.add(new ProprieteAConstruire(null, null, i, i, null, i, caseType, null));
				}
				else if(caseType.compareTo("G") == 0){
					System.out.println("Gare :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
				}
				else if(caseType.compareTo("C") == 0){
					System.out.println("Compagnie :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
				}
				else if(caseType.compareTo("CT") == 0){
					System.out.println("Case Tirage :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
				}
				else if(caseType.compareTo("CA") == 0){
					System.out.println("Case Argent :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
				}
				else if(caseType.compareTo("CM") == 0){
					System.out.println("Case Mouvement :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
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
        
        
        public void inscriptionJoueurs(){
            
        }
        
        
        
        public int des6(){
            Random r = new Random();
            return (r.nextInt(6)+1) + (r.nextInt(6)+1);
        }
        
        
        
}

