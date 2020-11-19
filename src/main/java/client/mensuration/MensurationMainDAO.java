package client.mensuration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.Constantes;

public class MensurationMainDAO {
	private long tourPaumeOuvert;
	private long tourPaumeFerme;
	private long longueurPaume;
	private long longueurMajeur;
	
	public long getTourPaumeOuvert() {
		return tourPaumeOuvert;
	}
	public void setTourPaumeOuvert(long tourPaumeOuvert) {
		this.tourPaumeOuvert = tourPaumeOuvert;
	}
	
	public long getTourPaumeFerme() {
		return tourPaumeFerme;
	}
	public void setTourPaumeFerme(long tourPaumeFerme) {
		this.tourPaumeFerme = tourPaumeFerme;
	}
	
	public long getLongueurPaume() {
		return longueurPaume;
	}
	public void setLongueurPaume(long longueurPaume) {
		this.longueurPaume = longueurPaume;
	}
	
	public long getLongueurMajeur() {
		return longueurMajeur;
	}
	public void setLongueurMajeur(long longueurMajeur) {
		this.longueurMajeur = longueurMajeur;
	}
	
	/** Fonction permettant de transformer la mensuration en row pour la modification**/
	public ArrayList<MensurationRow> toRow() {
		ArrayList<MensurationRow> arr = new ArrayList<MensurationRow>();
		
		arr.add(new MensurationRow("Tour de paume (doigts ouverts)", String.valueOf(tourPaumeOuvert)));
		arr.add(new MensurationRow("Tour de paume (doigts fermés)", String.valueOf(tourPaumeFerme)));
		arr.add(new MensurationRow("Longueur de la paume", String.valueOf(longueurPaume)));
		arr.add(new MensurationRow("Longueur du majeur", String.valueOf(longueurMajeur)));
		
		return arr;
	}
	
	/** Initialisation de la classe via résultat d'une requete SQL **/
	public void initFromSQL(ResultSet arr) {
		try {
			setTourPaumeOuvert(arr.getLong(Constantes.colTourPaumeOuvert));
			setTourPaumeFerme(arr.getLong(Constantes.colTourPaumeFerme));
			setLongueurPaume(arr.getLong(Constantes.colLongueurPaume));
			setLongueurMajeur(arr.getLong(Constantes.colLongueurMajeur));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** Fonction de comparaison avec un autre objet de class MensurationDAO **/
	public boolean isEqual(MensurationMainDAO other) {
		if(this.tourPaumeOuvert != other.getTourPaumeOuvert()) {
			return false;
		}
		if(this.tourPaumeFerme != other.getTourPaumeFerme()) {
			return false;
		}
		if(this.longueurPaume != other.getLongueurPaume()) {
			return false;
		}
		if(this.longueurMajeur != other.getLongueurMajeur()) {
			return false;
		}
		
		return true;
	}
}
