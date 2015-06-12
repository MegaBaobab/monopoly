package Jeu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;



public class Monopoly {
    
    /* Attributs */
    private ArrayList<Carreau> carreaux;
    private int nbMaisons = 32;
    private int nbHotels = 12;
    private ArrayList<Joueur> joueurs; 
    private Interface interface0;
    private HashMap<CouleurPropriete,Groupe> groupes;
    private LinkedList<Carte> cartesChances;
    private LinkedList<Carte> cartesCommunaute;

    /* Builder */
        
	public Monopoly(String dataFilename){
            setCarreaux(new ArrayList());
            setJoueurs(new ArrayList());
            setGroupes(new HashMap());
            setInterface0(new Interface(this));
            setCartesChances(new LinkedList<Carte>());
            setCartesCommunaute(new LinkedList<Carte>());
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
                                        Groupe g;
                                        
                                        if(groupes.containsKey(CouleurPropriete.valueOf(data.get(i)[3]))){
                                            g = getGroupe(CouleurPropriete.valueOf(data.get(i)[3]));
                                            
                                        }
                                        else{
                                            g = new Groupe(Integer.parseInt(data.get(i)[11]),Integer.parseInt(data.get(i)[12]),CouleurPropriete.valueOf(data.get(i)[3]));
                                            
                                            ajouterGroupe(g);
                                        }
                                        
                                        ProprieteAConstruire p = new ProprieteAConstruire(a,
                                                    g,
                                                    Integer.parseInt(data.get(i)[4]),
                                                    null, Integer.parseInt(data.get(i)[1]),
                                                    data.get(i)[2] ,this);
                                            carreaux.add(p);
                                            getGroupe(CouleurPropriete.valueOf(data.get(i)[3])).ajouterPropriete(p);
                                        
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
				}else if(caseType.compareTo("CH") == 0){ //carte chance
                                    
                                        if(data.get(i)[1].compareTo("SP") == 0){
                                            cartesChances.add(new CarteSortirPrison(data.get(i)[2], this));
                                        }
                                        else if(data.get(i)[1].compareTo("MR") == 0){
                                            cartesChances.add(new CarteMouvementRelatif(data.get(i)[2], Integer.parseInt(data.get(i)[3]), this));
                                        }
                                        else if(data.get(i)[1].compareTo("MA") == 0){
                                            cartesChances.add(new CarteMouvementAbsolu(data.get(i)[2], getCarreau(Integer.parseInt(data.get(i)[3])), this));
                                        }
                                        else if(data.get(i)[1].compareTo("A") == 0){
                                            cartesChances.add(new CarteArgent(data.get(i)[2], Integer.parseInt(data.get(i)[3]), this));
                                        }
                                        else if(data.get(i)[1].compareTo("R") == 0){
                                            cartesChances.add(new CarteReparation(data.get(i)[2], Integer.parseInt(data.get(i)[4]), Integer.parseInt(data.get(i)[3]), this));
                                        }
                                    
                                }
                                else if(caseType.compareTo("CO") == 0){ //carte Communauté
                                    
                                        if(data.get(i)[1].compareTo("SP") == 0){
                                            cartesCommunaute.add(new CarteSortirPrison(data.get(i)[2], this));
                                        }
                                        else if(data.get(i)[1].compareTo("A") == 0){
                                            cartesCommunaute.add(new CarteArgent(data.get(i)[2], i, this));
                                        }
                                        else if(data.get(i)[1].compareTo("AN") == 0){
                                            cartesCommunaute.add(new CarteAnniversaire(data.get(i)[2], this));
                                        }
                                        else if(data.get(i)[1].compareTo("MA") == 0){
                                            cartesCommunaute.add(new CarteMouvementAbsolu(data.get(i)[2], getCarreau(Integer.parseInt(data.get(i)[3])), this));
                                        }
                                    
                                    
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
            
            while (i>6 || i<1) {
            i = interface0.nbJoueur();
            }
            
            for (int y=1; y<=i; y++){
                String nom = interface0.saisieJoueur(y);
                joueurs.add(new Joueur(nom, this));
            }
            melangerCartes();
            
            
        }

    public ArrayList<Carreau> getCarreaux() {
        return carreaux;
    }

    public int getNbMaisons() {
        return nbMaisons;
    }

    public int getNbHotels() {
        return nbHotels;
    }

    public LinkedList<Carte> getCartesChances() {
        return cartesChances;
    }

    public void setCartesChances(LinkedList cartesChances) {
        this.cartesChances = cartesChances;
    }

    public LinkedList<Carte> getCartesCommunaute() {
        return cartesCommunaute;
    }

    public void setCartesCommunaute(LinkedList cartesCommunaute) {
        this.cartesCommunaute = cartesCommunaute;
    }

    public void setCarreaux(ArrayList<Carreau> carreaux) {
        this.carreaux = carreaux;
    }

    public void setNbMaisons(int nbMaisons) {
        this.nbMaisons = nbMaisons;
    }

    public void setNbHotels(int nbHotels) {
        this.nbHotels = nbHotels;
    }

    public void setJoueurs(ArrayList<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public void setInterface0(Interface interface0) {
        this.interface0 = interface0;
    }

    public void setGroupes(HashMap<CouleurPropriete, Groupe> groupes) {
        this.groupes = groupes;
    }

    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }

    public Interface getInterface0() {
        return interface0;
    }

    public HashMap<CouleurPropriete, Groupe> getGroupes() {
        return groupes;
    }
        
    public void ajouterGroupe(Groupe g){
        groupes.put(g.getCouleur(),g);
    }    
        
        public int des6(){
            Random r = new Random();
            return r.nextInt(6)+1;
            //return 2;
        }
        
        public Groupe getGroupe(CouleurPropriete c){
            return groupes.get(c);
        }
        
        public Carreau getCarreau(int i){
            return carreaux.get(i -1);
        }
        
        
        public void jouerUnCoup(Joueur j){
            int d1 = 0;
            int d2 = 0;
            int i = 0;
            int x  = 0;
            
            while (d1==d2 && i<3){
            d1 = des6();
            d2 = des6();
            i=i+1;
                
                
                
                if(i==3 && d1==d2){
                    allerEnPrison(j);
                    getInterface0().doublesPrison(d1, d2);
                }else{
                    x = (j.getPositionCourante().getNumero()+ d1 + d2);
                    if(x > 40){
                        x = x - 40;
                        j.setCash(j.getCash() + 200);
                    }
                    
                    if(j.getTourPrison()== 3 || j.getTourPrison() == 2){
                        if(j.getNbCartessortiePrison() > 0 && getInterface0().carteSortiePrison()){
                            sortirPrison(j);
                            j.setNbCartessortiePrison(j.getNbCartessortiePrison() - 1);
                        }
                        else{
                            if(d1 == d2){
                                sortirPrison(j);
                            }
                            else{
                                j.setTourPrison(j.getTourPrison()-1);
                                if(j.getTourPrison() == 2){
                                    getInterface0().resterPrison(d1, d2);
                                }
                                
                            }
                        }
                        
                    }
                    else if(j.getTourPrison() == 1){
                        if(d1 == d2){
                            sortirPrison(j);
                        }
                        else{
                            sortirPrison(j);
                            j.setCash(j.getCash()-50);
                        }
                    }
                
                    if(j.getTourPrison() == 0){
                    j.setPositionCourante(getCarreau(x));
                    interface0.afficheDes(j,d1,d2);
                    j.getPositionCourante().action(j, d1+d2);
                    interface0.afficheJoueur(j);
                    }
                } 
            }
            
                    
            for (Joueur jo : joueurs){
            interface0.afficheJoueur(jo);
            }
            Scanner entree = new Scanner(System.in);
            entree.nextLine();
        }
        
        public void allerEnPrison(Joueur j){
            j.setPositionCourante(getCarreau(11));
            j.setTourPrison(3);
        }
        
        public void sortirPrison(Joueur j){
            j.setTourPrison(0);
        }
        
        public void melangerCartes(){
            Collections.shuffle(cartesChances);
            Collections.shuffle(cartesCommunaute);
        }
        
        public Carte tirerCarteChance(){
            Carte c = cartesChances.pollFirst();
            cartesChances.addLast(c);
            return  c;
        }
        
        public Carte tirerCarteCommunaute(){
            Carte c = cartesCommunaute.pollFirst();
            cartesCommunaute.addLast(c);
            return c;
        }
        
        public void afficheCarte(){
            System.out.println("Cartes chances : ");
            for(Carte c : this.getCartesChances()){
                System.out.println(c.getNomCarte());
            }
            System.out.println("Cartes communauté : ");
            for(Carte c : this.getCartesCommunaute()){
                System.out.println(c.getNomCarte());
            }
        }
        
        
        public void testAchatConstruction(Joueur j){
            if(j.getPositionCourante() == getCarreau(1)){
                    j.setPositionCourante(getCarreau(2));
                    j.getPositionCourante().action(j, 0);
                }
                else{
                    j.setPositionCourante(getCarreau(4));
                    j.getPositionCourante().action(j, 0);
                    j.setPositionCourante(getCarreau(1));
                }
        }
}

