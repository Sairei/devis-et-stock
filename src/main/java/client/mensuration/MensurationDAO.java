package client.mensuration;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import base.SQLSelect;

public class MensurationDAO {
	private long id;
	private MensurationGeneraleDAO mensuGenerale;
	private MensurationHautDAO mensuHaut;
	private MensurationBasDAO mensuBas;
	private MensurationMainDAO mensuMain;
	
	public MensurationDAO (long id) {
		this.id = id;
		
		this.mensuGenerale = new MensurationGeneraleDAO();
		this.mensuHaut = new MensurationHautDAO();
		this.mensuBas = new MensurationBasDAO();
		this.mensuMain = new MensurationMainDAO();
	}
	
	public MensurationDAO (long id, String type) {
		this(id);

		if(type.equals("GET")) {
			ArrayList<ResultSet> mensurations = SQLSelect.selectAllMensurationById(id);
			mensuGenerale.initFromSQL(mensurations.get(0));
			mensuHaut.initFromSQL(mensurations.get(1));
			mensuBas.initFromSQL(mensurations.get(2));
			mensuMain.initFromSQL(mensurations.get(3));
		}
	}
	
	public long getId() {
		return this.id;
	}
	
	public void setGenerale(HashMap<String, String> hashMap) {
		mensuGenerale.setStature(Long.valueOf(hashMap.get("Stature")));
		mensuGenerale.setHauteurCorps(Long.valueOf(hashMap.get("Hauteur du corps")));
	}
	public MensurationGeneraleDAO getGenerale() {
		return this.mensuGenerale;
	}

	public void setHaut(HashMap<String, String> hashMap) {
		mensuHaut.setTourCou(Long.valueOf(hashMap.get("Tour de cou")));
		mensuHaut.setCarrure(Long.valueOf(hashMap.get("Carrure")));
		mensuHaut.setTourPoitrine(Long.valueOf(hashMap.get("Tour de poitrine")));
		mensuHaut.setTourBuste(Long.valueOf(hashMap.get("Tour de buste")));
		mensuHaut.setTourTaille(Long.valueOf(hashMap.get("Tour de taille")));
		mensuHaut.setTourBras(Long.valueOf(hashMap.get("Tour de bras")));
		mensuHaut.setTourPoignet(Long.valueOf(hashMap.get("Tour de poignet")));
		mensuHaut.setEcartPointeSeins(Long.valueOf(hashMap.get("Ecartement pointe des seins")));
		mensuHaut.setLongueurEncolureSein(Long.valueOf(hashMap.get("Longueur base d'encolure pointe des seins")));
		mensuHaut.setLongueurEpaule(Long.valueOf(hashMap.get("Longueur d'épaule")));
		mensuHaut.setLongueurBras(Long.valueOf(hashMap.get("Longueur du bras")));
		mensuHaut.setHauteurPoitrine(Long.valueOf(hashMap.get("Hauteur de la poitrine")));
		mensuHaut.setHauteurTaille(Long.valueOf(hashMap.get("Hauteur taille")));
	}
	public MensurationHautDAO getHaut() {
		return this.mensuHaut;
	}
	
	public void setBas(HashMap<String, String> hashMap) {
		mensuBas.setTourHanches(Long.valueOf(hashMap.get("Tour de hanches"))); 
		mensuBas.setTourBassin(Long.valueOf(hashMap.get("Tour de bassin"))); 
		mensuBas.setTourCuisse(Long.valueOf(hashMap.get("Tour de cuisse")));
		mensuBas.setTourGenou(Long.valueOf(hashMap.get("Tour de genou")));
		mensuBas.setTourMollet(Long.valueOf(hashMap.get("Tour de mollet")));
		mensuBas.setTourCheville(Long.valueOf(hashMap.get("Tour de cheville")));
		mensuBas.setMontantDos(Long.valueOf(hashMap.get("Montant dos")));
		mensuBas.setLongueurEnfourchure(Long.valueOf(hashMap.get("Longueur enfourchure")));
		mensuBas.setHauteurTailleSol(Long.valueOf(hashMap.get("Hauteur taille-sol")));
		mensuBas.setHauteurTailleGenou(Long.valueOf(hashMap.get("Hauteur taille-genou")));
		mensuBas.setHauteurGenouCheville(Long.valueOf(hashMap.get("Hauteur genou-cheville"))); 
		mensuBas.setHauteurEntrejambeCheville(Long.valueOf(hashMap.get("Hauteur entrejambe-cheville")));
		mensuBas.setHauteurChevilleSol(Long.valueOf(hashMap.get("Hauteur cheville-sol")));
	}
	public MensurationBasDAO getBas() {
		return this.mensuBas;
	}
	
	public void setMain(HashMap<String, String> hashMap) {
		mensuMain.setTourPaumeOuvert(Long.valueOf(hashMap.get("Tour de paume (doigts ouverts)")));
		mensuMain.setTourPaumeFerme(Long.valueOf(hashMap.get("Tour de paume (doigts fermés)"))); 
		mensuMain.setLongueurPaume(Long.valueOf(hashMap.get("Longueur de la paume")));
		mensuMain.setLongueurMajeur(Long.valueOf(hashMap.get("Longueur du majeur")));
	}
	public MensurationMainDAO getMain() {
		return this.mensuMain;
	}
	
	
	/** Fonction permettant de concatener tout les tableaux de ROW en un seul **/
	public ArrayList<MensurationRow> toRow() {
		ArrayList<MensurationRow> arr = new ArrayList<MensurationRow>();
		
		arr.addAll(getGenerale().toRow());
		arr.addAll(getHaut().toRow());
		arr.addAll(getBas().toRow());
		arr.addAll(getMain().toRow());
		
		return arr;
	}
}