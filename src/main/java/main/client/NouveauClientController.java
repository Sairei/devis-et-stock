package main.client;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import main.base.SQLInsert;

public class NouveauClientController {
	@FXML
	private ToggleGroup civilite;
	@FXML
	private RadioButton homme;
	@FXML
	private RadioButton femme;
	@FXML
	private TextField nom; 
	@FXML
	private TextField prenom;
	@FXML
	private TextField adresse;
	@FXML
	private TextField code_postal;
	@FXML
	private TextField ville;
	@FXML
	private TextField mail;
	@FXML
	private TextField telephone;
	
	@FXML
	public void initialize() {
		femme.setSelected(true);
	}
	
	@FXML
	public void saveClient() {
		String genre = femme.isSelected() ? femme.getText() : homme.getText();
		String strAdresse = adresse.getText() + ", " + code_postal.getText() + " " + ville.getText(); 
		ClientDAO nouveauClient = new ClientDAO(genre, nom.getText(), prenom.getText(), strAdresse, mail.getText(), telephone.getText(), -1);
		
		SQLInsert.insertNouveauClient(nouveauClient);
		
		Stage stage = (Stage) nom.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	public void cancel() {
		Stage stage = (Stage) nom.getScene().getWindow();
		stage.close();
	}
}
