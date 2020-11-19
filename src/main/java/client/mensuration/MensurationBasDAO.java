package client.mensuration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.Constantes;

public class MensurationBasDAO {
	private long tourHanches;
	private long tourBassin;
	private long tourCuisse;
	private long tourGenou;
	private long tourMollet;
	private long tourCheville;
	private long montantDos;
	private long longueurEnfourchure;
	private long hauteurTailleSol;
	private long hauteurTailleGenou;
	private long hauteurGenouCheville;
	private long hauteurEntrejambeCheville;	
	private long hauteurChevilleSol;
	
	public long getTourHanches() {
		return tourHanches;
	}
	public void setTourHanches(long tourHanches) {
		this.tourHanches = tourHanches;
	}
	
	public long getTourBassin() {
		return tourBassin;
	}
	public void setTourBassin(long tourBassin) {
		this.tourBassin = tourBassin;
	}
	
	public long getTourCuisse() {
		return tourCuisse;
	}
	public void setTourCuisse(long tourCuisse) {
		this.tourCuisse = tourCuisse;
	}
	
	public long getTourGenou() {
		return tourGenou;
	}
	public void setTourGenou(long tourGenou) {
		this.tourGenou = tourGenou;
	}
	
	public long getTourMollet() {
		return tourMollet;
	}
	public void setTourMollet(long tourMollet) {
		this.tourMollet = tourMollet;
	}
	
	public long getTourCheville() {
		return tourCheville;
	}
	public void setTourCheville(long tourCheville) {
		this.tourCheville = tourCheville;
	}
	
	public long getMontantDos() {
		return montantDos;
	}
	public void setMontantDos(long montantDos) {
		this.montantDos = montantDos;
	}
	
	public long getLongueurEnfourchure() {
		return longueurEnfourchure;
	}
	public void setLongueurEnfourchure(long longueurEnfourchure) {
		this.longueurEnfourchure = longueurEnfourchure;
	}
	
	public long getHauteurTailleSol() {
		return hauteurTailleSol;
	}
	public void setHauteurTailleSol(long hauteurTailleSol) {
		this.hauteurTailleSol = hauteurTailleSol;
	}
	
	public long getHauteurTailleGenou() {
		return hauteurTailleGenou;
	}
	public void setHauteurTailleGenou(long hauteurTailleGenou) {
		this.hauteurTailleGenou = hauteurTailleGenou;
	}
	
	public long getHauteurGenouCheville() {
		return hauteurGenouCheville;
	}
	public void setHauteurGenouCheville(long hauteurGenouCheville) {
		this.hauteurGenouCheville = hauteurGenouCheville;
	}
	
	public long getHauteurEntrejambeCheville() {
		return hauteurEntrejambeCheville;
	}
	public void setHauteurEntrejambeCheville(long hauteurEntrejambeCheville) {
		this.hauteurEntrejambeCheville = hauteurEntrejambeCheville;
	}
	
	public long getHauteurChevilleSol() {
		return hauteurChevilleSol;
	}
	public void setHauteurChevilleSol(long hauteurChevilleSol) {
		this.hauteurChevilleSol = hauteurChevilleSol;
	}
	
	/** Fonction permettant de transformer la mensuration en row pour la modification**/
	public ArrayList<MensurationRow> toRow() {
		ArrayList<MensurationRow> arr = new ArrayList<MensurationRow>();
		
		arr.add(new MensurationRow("Tour de hanches", String.valueOf(tourHanches)));
		arr.add(new MensurationRow("Tour de bassin", String.valueOf(tourBassin)));
		arr.add(new MensurationRow("Tour de cuisse", String.valueOf(tourCuisse)));
		arr.add(new MensurationRow("Tour de genou", String.valueOf(tourGenou)));
		arr.add(new MensurationRow("Tour de mollet", String.valueOf(tourMollet)));
		arr.add(new MensurationRow("Tour de cheville", String.valueOf(tourCheville)));
		arr.add(new MensurationRow("Montant dos", String.valueOf(montantDos)));
		arr.add(new MensurationRow("Longueur enfourchure", String.valueOf(longueurEnfourchure)));
		arr.add(new MensurationRow("Hauteur taille-sol", String.valueOf(hauteurTailleSol)));
		arr.add(new MensurationRow("Hauteur taille-genou", String.valueOf(hauteurTailleGenou)));
		arr.add(new MensurationRow("Hauteur genou-cheville", String.valueOf(hauteurGenouCheville)));
		arr.add(new MensurationRow("Hauteur entrejambe-cheville", String.valueOf(hauteurEntrejambeCheville)));
		arr.add(new MensurationRow("Hauteur cheville-sol", String.valueOf(hauteurChevilleSol)));
		
		return arr;
	}
	
	/** Initialisation de la classe via résultat d'une requete SQL **/
	public void initFromSQL(ResultSet arr) {
		try {
			setTourHanches(arr.getLong(Constantes.colTourHanches));
			setTourBassin(arr.getLong(Constantes.colTourBassin));
			setTourCuisse(arr.getLong(Constantes.colTourCuisse));
			setTourGenou(arr.getLong(Constantes.colTourGenou));
			setTourMollet(arr.getLong(Constantes.colTourMollet));
			setTourCheville(arr.getLong(Constantes.colTourCheville));
			setMontantDos(arr.getLong(Constantes.colMontantDos));
			setLongueurEnfourchure(arr.getLong(Constantes.colLongueurEnfourchure));
			setHauteurTailleSol(arr.getLong(Constantes.colHauteurTailleSol));
			setHauteurTailleGenou(arr.getLong(Constantes.colHauteurTailleGenou));
			setHauteurGenouCheville(arr.getLong(Constantes.colHauteurGenouCheville));
			setHauteurEntrejambeCheville(arr.getLong(Constantes.colHauteurEntrejambeCheville));
			setHauteurChevilleSol(arr.getLong(Constantes.colHauteurChevilleSol));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** Fonction de comparaison avec un autre objet de class MensurationDAO **/
	public boolean isEqual(MensurationBasDAO other) {
		if(this.tourHanches != other.getTourHanches()) {
			return false;
		}
		if(this.tourBassin != other.getTourBassin()) {
			return false;
		}
		if(this.tourCuisse != other.getTourCuisse()) {
			return false;
		}
		if(this.tourGenou != other.getTourGenou()) {
			return false;
		}
		if(this.tourMollet != other.getTourMollet()) {
			return false;
		}
		if(this.tourCheville != other.getTourCheville()) {
			return false;
		}
		if(this.montantDos != other.getMontantDos()) {
			return false;
		}
		if(this.longueurEnfourchure != other.getLongueurEnfourchure()) {
			return false;
		}
		if(this.hauteurTailleSol != other.getHauteurTailleSol()) {
			return false;
		}
		if(this.hauteurTailleGenou != other.getHauteurTailleGenou()) {
			return false;
		}
		if(this.hauteurGenouCheville != other.getHauteurGenouCheville()) {
			return false;
		}
		if(this.hauteurEntrejambeCheville != other.getHauteurEntrejambeCheville()) {
			return false;
		}
		if(this.hauteurChevilleSol != other.getHauteurChevilleSol()) {
			return false;
		}
		return true;
	}
}
