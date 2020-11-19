package client.mensuration;

import javafx.beans.property.SimpleStringProperty;

public class MensurationRow {
	private SimpleStringProperty  nom;
	private SimpleStringProperty  valeur;
	
	public MensurationRow(String nom, String valeur) {
		this.nom = new SimpleStringProperty(nom);
		this.valeur = new SimpleStringProperty(valeur);
	}
	
	public void setNom(String nom) {
		this.nom.set(nom);
	}
	public String getNom() {
		return this.nom.get();
	}
	
	public void setValeur(String valeur) {
		this.valeur.set(valeur);
	}
	public String getValeur() {
		return this.valeur.get();
	}
}
