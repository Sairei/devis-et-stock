package client.mensuration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.Constantes;

public class MensurationHautDAO {
	private long tourCou;
	private long carrure;
	private long tourPoitrine;
	private long tourBuste;
	private long tourTaille;
	private long tourBras;
	private long tourPoignet;
	private long ecartPointeSeins;
	private long longueurEncolureSein;
	private long longueurEpaule;
	private long longueurBras;
	private long hauteurPoitrine;
	private long hauteurTaille;
	private long hauteurTailleSein;
	
	public long getTourCou() {
		return tourCou;
	}
	public void setTourCou(long tourCou) {
		this.tourCou = tourCou;
	}
	
	public long getCarrure() {
		return carrure;
	}
	public void setCarrure(long carrure) {
		this.carrure = carrure;
	}
	
	public long getTourPoitrine() {
		return tourPoitrine;
	}
	public void setTourPoitrine(long tourPoitrine) {
		this.tourPoitrine = tourPoitrine;
	}
	
	public long getTourBuste() {
		return tourBuste;
	}
	public void setTourBuste(long tourBuste) {
		this.tourBuste = tourBuste;
	}
	
	public long getTourTaille() {
		return tourTaille;
	}
	public void setTourTaille(long tourTaille) {
		this.tourTaille = tourTaille;
	}
	
	public long getTourBras() {
		return tourBras;
	}
	public void setTourBras(long tourBras) {
		this.tourBras = tourBras;
	}
	
	public long getTourPoignet() {
		return tourPoignet;
	}
	public void setTourPoignet(long tourPoignet) {
		this.tourPoignet = tourPoignet;
	}
	
	public long getEcartPointeSeins() {
		return ecartPointeSeins;
	}
	public void setEcartPointeSeins(long ecartPointeSeins) {
		this.ecartPointeSeins = ecartPointeSeins;
	}
	
	public long getLongueurEncolureSein() {
		return longueurEncolureSein;
	}
	public void setLongueurEncolureSein(long longueurEncolureSein) {
		this.longueurEncolureSein = longueurEncolureSein;
	}
	
	public long getLongueurEpaule() {
		return longueurEpaule;
	}
	public void setLongueurEpaule(long longueurEpaule) {
		this.longueurEpaule = longueurEpaule;
	}
	
	public long getLongueurBras() {
		return longueurBras;
	}
	public void setLongueurBras(long longueurBras) {
		this.longueurBras = longueurBras;
	}
	
	public long getHauteurPoitrine() {
		return hauteurPoitrine;
	}
	public void setHauteurPoitrine(long hauteurPointrine) {
		this.hauteurPoitrine = hauteurPointrine;
	}
	
	public long getHauteurTaille() {
		return hauteurTaille;
	}
	public void setHauteurTaille(long hauteurTaille) {
		this.hauteurTaille = hauteurTaille;
	}
	
	public long getHauteurTailleSein() {
		return hauteurTailleSein;
	}
	public void setHauteurTailleSein(long hauteurTailleSein) {
		this.hauteurTailleSein = hauteurTailleSein;
	}
	
	/** Fonction permettant de transformer la mensuration en row pour la modification**/
	public ArrayList<MensurationRow> toRow() {
		ArrayList<MensurationRow> arr = new ArrayList<MensurationRow>();
		
		arr.add(new MensurationRow("Tour de cou", String.valueOf(tourCou)));
		arr.add(new MensurationRow("Carrure", String.valueOf(carrure)));
		arr.add(new MensurationRow("Tour de poitrine", String.valueOf(tourPoitrine)));
		arr.add(new MensurationRow("Tour de buste", String.valueOf(tourBuste)));
		arr.add(new MensurationRow("Tour de taille", String.valueOf(tourTaille)));
		arr.add(new MensurationRow("Tour de bras", String.valueOf(tourBras)));
		arr.add(new MensurationRow("Tour de poignet", String.valueOf(tourPoignet)));
		arr.add(new MensurationRow("Ecartement pointe des seins", String.valueOf(ecartPointeSeins)));
		arr.add(new MensurationRow("Longueur base d'encolure pointe des seins", String.valueOf(longueurEncolureSein)));
		arr.add(new MensurationRow("Longueur d'épaule", String.valueOf(longueurEpaule)));
		arr.add(new MensurationRow("Longueur du bras", String.valueOf(longueurBras)));
		arr.add(new MensurationRow("Hauteur de la poitrine", String.valueOf(hauteurPoitrine)));
		arr.add(new MensurationRow("Hauteur taille", String.valueOf(hauteurTaille)));
		arr.add(new MensurationRow("Hauteur taille pointe des seins", String.valueOf(hauteurTailleSein)));
		
		return arr;
	}
	
	/** Initialisation de la classe via résultat d'une requete SQL **/
	public void initFromSQL(ResultSet arr) {
		try {
			setTourCou(arr.getLong(Constantes.colTourCou));
			setCarrure(arr.getLong(Constantes.colCarrure));
			setTourPoitrine(arr.getLong(Constantes.colTourPoitrine));
			setTourBuste(arr.getLong(Constantes.colTourBuste));
			setTourTaille(arr.getLong(Constantes.colTourTaille));
			setTourBras(arr.getLong(Constantes.colTourBras));
			setTourPoignet(arr.getLong(Constantes.colTourPoignet));
			setEcartPointeSeins(arr.getLong(Constantes.colEcartPointeSeins));
			setLongueurEncolureSein(arr.getLong(Constantes.colLongueurEncolureSeins));
			setLongueurEpaule(arr.getLong(Constantes.colLongueurEpaule));
			setLongueurBras(arr.getLong(Constantes.colLongueurBras));
			setHauteurPoitrine(arr.getLong(Constantes.colHauteurPoitrine));
			setHauteurTaille(arr.getLong(Constantes.colHauteurTaille));
			setHauteurTailleSein(arr.getLong(Constantes.colHauteurTailleSein));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** Fonction de comparaison avec un autre objet de class MensurationDAO **/
	public boolean isEqual(MensurationHautDAO other) {
		if(this.tourCou != other.getTourCou()) {
			return false;
		}
		if(this.carrure != other.getCarrure()) {
			return false;
		}
		if(this.tourPoitrine != other.getTourPoitrine()) {
			return false;
		}
		if(this.tourBuste != other.getTourBuste()) {
			return false;
		}
		if(this.tourTaille != other.getTourTaille()) {
			return false;
		}
		if(this.tourBras != other.getTourBras()) {
			return false;
		}
		if(this.tourPoignet != other.getTourPoignet()) {
			return false;
		}
		if(this.ecartPointeSeins != other.getEcartPointeSeins()) {
			return false;
		}
		if(this.longueurEncolureSein != other.getLongueurEncolureSein()) {
			return false;
		}
		if(this.longueurEpaule != other.getLongueurEpaule()) {
			return false;
		}
		if(this.longueurBras != other.getLongueurBras()) {
			return false;
		}
		if(this.hauteurPoitrine != other.getHauteurPoitrine()) {
			return false;
		}
		if(this.hauteurTaille != other.getHauteurTaille()) {
			return false;
		}
		if(this.hauteurTailleSein != other.getHauteurTailleSein()) {
			return false;
		}
		
		return true;
	}
}
