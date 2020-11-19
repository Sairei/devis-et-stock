package common;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import client.mensuration.MensurationRow;
import javafx.collections.ObservableList;

public class MethodesCommunes {
    /** Test l'existance d'un fichier (ou d'un dossier) et le créé s'il n'existe pas
     * @param pathFile est le fichier à tester
     * @param isDirectorie permet de savoir si le fichier est un dossier ou non
     *
     * @return isCreate, booléen pour savoir si le fichier viens d'étre créer ou non
     * **/
    public static boolean testFileExistAndCreate(String pathFile, boolean isDirectorie) {
        final File file = new File(pathFile);
        try {
            boolean isCreate = false;
            if (!file.exists()) {
                System.out.println(file.getAbsolutePath() + " non existant: création");
                isCreate = true;
                if (isDirectorie) {
                    file.mkdir();
                    return isCreate;
                }
                else {
                    file.createNewFile();
                    return isCreate;
                }
            }

            return isCreate;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
    
    
    public static HashMap<String, HashMap<String, String>> convertListRowForMensuration(ObservableList<MensurationRow> arr) {
    	final ArrayList<String> listeGenerale = new ArrayList<>(Arrays.asList(
    			"Stature", "Hauteur du corps"));
    	final ArrayList<String> listeHaut = new ArrayList<>(Arrays.asList(
    			"Tour de cou", "Carrure", "Tour de poitrine", "Tour de buste",
    			"Tour de taille", "Tour de bras", "Tour de poignet", 
    			"Ecartement pointe des seins",	"Longueur base d'encolure pointe des seins",
    			"Longueur d'épaule", "Longueur du bras", "Hauteur de la poitrine", 
    			"Hauteur taille", "Hauteur taille pointe des seins"));
    	final ArrayList<String> listeBas = new ArrayList<>(Arrays.asList(
    			"Tour de hanches", "Tour de bassin", "Tour de cuisse", "Tour de genou",
    			"Tour de mollet", "Tour de cheville", "Montant dos", "Longueur enfourchure",
    			"Hauteur taille-sol", "Hauteur taille-genou", "Hauteur genou-cheville", 
    			"Hauteur entrejambe-cheville", "Hauteur cheville-sol"));
    	final ArrayList<String> listeMain = new ArrayList<>(Arrays.asList(
    			"Tour de paume (doigts ouverts)", "Tour de paume (doigts fermés)", 
    			"Longueur de la paume", "Longueur du majeur"));
    	
    	HashMap<String, String> generale = new HashMap<String, String>();
    	HashMap<String, String> haut = new HashMap<String, String>();
    	HashMap<String, String> bas = new HashMap<String, String>();
    	HashMap<String, String> main = new HashMap<String, String>();
    	
    	for(MensurationRow row : arr) {
    		if(listeGenerale.contains(row.getNom())) {
    			generale.put(row.getNom(), row.getValeur());
    		} 
    		else if(listeHaut.contains(row.getNom())) {
    			haut.put(row.getNom(), row.getValeur());
    		} 
    		else if(listeBas.contains(row.getNom())) {
    			bas.put(row.getNom(), row.getValeur());
    		} 
    		else if(listeMain.contains(row.getNom())) {
    			main.put(row.getNom(), row.getValeur());
    		} 
    	}
    	
    	HashMap<String, HashMap<String, String>> res = new HashMap<String, HashMap<String,String>>();
    	res.put("generale", generale);
    	res.put("haut", haut);
    	res.put("bas", bas);
    	res.put("main", main);
    	return res;
    }
}
