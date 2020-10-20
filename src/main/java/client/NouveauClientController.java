package client;

import base.SQLInsert;
import common.ChangeListenerPerso;
import common.Constantes;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

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
		setupCleanBorderOnFocus();
	}
	
	@FXML
	public void saveClient() {		
		boolean controleDesValeurs = controleValeurs();
		
		if (controleDesValeurs) {
			String genre = femme.isSelected() ? femme.getText() : homme.getText();
			String strAdresse = adresse.getText().replaceAll(", ", ",xx ") 
					+ ", " + code_postal.getText() 
					+ " " + ville.getText(); 
			ClientDAO nouveauClient = new ClientDAO(genre, nom.getText(), prenom.getText(), strAdresse, mail.getText(), telephone.getText(), -1);
			
			SQLInsert.insertNouveauClient(nouveauClient);
			
			Stage stage = (Stage) nom.getScene().getWindow();
			stage.close();
		}
	}
	
	@FXML
	public void cancel() {
		Stage stage = (Stage) nom.getScene().getWindow();
		stage.close();
	}
	
	
	public void setupCleanBorderOnFocus() {
		this.nom.focusedProperty().addListener(new ChangeListenerPerso.ResetBorder(this.nom));
		this.prenom.focusedProperty().addListener(new ChangeListenerPerso.ResetBorder(this.prenom));
		this.adresse.focusedProperty().addListener(new ChangeListenerPerso.ResetBorder(this.adresse));
		this.code_postal.focusedProperty().addListener(new ChangeListenerPerso.ResetBorder(this.code_postal));
		this.ville.focusedProperty().addListener(new ChangeListenerPerso.ResetBorder(this.ville));
		this.mail.focusedProperty().addListener(new ChangeListenerPerso.ResetBorder(this.mail));
		this.telephone.focusedProperty().addListener(new ChangeListenerPerso.ResetBorder(this.telephone));
	}
	
	
	private boolean controleValeurs() {
		boolean value = true;
		
		if(this.nom.getText().isEmpty()) {
			this.nom.setStyle(Constantes.err_border);
			value = false;
		}
		if(this.prenom.getText().isEmpty()) {
			this.prenom.setStyle(Constantes.err_border);
			value = false;
		}
		if(this.adresse.getText().isEmpty()) {
			this.adresse.setStyle(Constantes.err_border);
			value = false;
		}
		if(this.code_postal.getText().isEmpty() ||
				!this.code_postal.getText().matches(Constantes.regex_code_postal)) {
			this.code_postal.setStyle(Constantes.err_border);
			value = false;
		}
		if(this.ville.getText().isEmpty()) {
			this.ville.setStyle(Constantes.err_border);
			value = false;
		}
		if(this.mail.getText().isEmpty() ||
				!this.mail.getText().matches(Constantes.regex_mail)) {
			this.mail.setStyle(Constantes.err_border);
			value = false;
		}
		if(this.telephone.getText().isEmpty() ||
				!this.telephone.getText().matches(Constantes.regex_telephone)) {
			this.telephone.setStyle(Constantes.err_border);
			value = false;
		}
		
		return value;
	}
}
