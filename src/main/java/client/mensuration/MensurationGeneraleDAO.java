package client.mensuration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.Constantes;

public class MensurationGeneraleDAO {
	private long stature;
	private long hauteurCorps;
	
	public long getStature() {
		return stature;
	}
	public void setStature(long stature) {
		this.stature = stature;
	}

	public long getHauteurCorps() {
		return hauteurCorps;
	}
	public void setHauteurCorps(long hauteur_corps) {
		this.hauteurCorps = hauteur_corps;
	}
	
	/** Fonction permettant de transformer la mensuration en row pour la modification**/
	public ArrayList<MensurationRow> toRow() {
		ArrayList<MensurationRow> arr = new ArrayList<MensurationRow>();
		
		arr.add(new MensurationRow("Stature", String.valueOf(stature)));
		arr.add(new MensurationRow("Hauteur du corps", String.valueOf(hauteurCorps)));
		
		return arr;
	}
	
	/** Initialisation de la classe via résultat d'une requete SQL **/
	public void initFromSQL(ResultSet arr) {
		try {
			setStature(arr.getLong(Constantes.colStature));
			setHauteurCorps(arr.getLong(Constantes.colHauteurCorps));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** Fonction de comparaison avec un autre objet de class MensurationDAO **/
	public boolean isEqual(MensurationGeneraleDAO other) {
		if(this.stature != other.getStature()) {
			return false;
		}
		if(this.hauteurCorps != other.getHauteurCorps()) {
			return false;
		}
		
		return true;
	}
}
