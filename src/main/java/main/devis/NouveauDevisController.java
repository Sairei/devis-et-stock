package main.devis;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.base.SQLInsert;
import main.base.SQLSelect;
import main.client.ClientDAO;
import main.common.Constantes;

public class NouveauDevisController {
	@FXML
	private TextField textTitre; 
	@FXML
	private TextArea textDescription; 
	@FXML
	private ChoiceBox<ClientDAO> listeClient;
	
	@FXML
	public void initialize() {
		updateListeClient();
	}
	
	@FXML
	public void saveDevis() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy à HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.now();
		String dateCrea = dateTime.format(formatter);
		ClientDAO clientDao = listeClient.getSelectionModel().getSelectedItem();
		DevisDAO nouveauDevis = new DevisDAO(dateCrea, textTitre.getText(), textDescription.getText(), clientDao);
		
		SQLInsert.insertNouveauDevis(nouveauDevis);
		
		Stage stage = (Stage) textTitre.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	public void cancel() {
		Stage stage = (Stage) textTitre.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	public void addClient() {
		try {
			Stage stage = new Stage();
		    Parent root = FXMLLoader.load(getClass().getResource("/client/nouveauClient.fxml"));
		    stage.setScene(new Scene(root));
		    stage.setTitle("Création d'un nouveau devis");
		    stage.initModality(Modality.APPLICATION_MODAL);
		    stage.showAndWait();
		    
		    updateListeClient();
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void updateListeClient() {
		listeClient.getItems().removeAll(listeClient.getItems());
		
		ResultSet allClient = SQLSelect.selectAllClient();
		try {
			if(allClient.next()) {
				do {
					ClientDAO client = new ClientDAO(allClient.getLong(Constantes.colClientId), allClient.getString(Constantes.colClientGenre),
							allClient.getString(Constantes.colClientNom), allClient.getString(Constantes.colClientPrenom),
							allClient.getString(Constantes.colClientAdresse), allClient.getString(Constantes.colClientMail),
							allClient.getString(Constantes.colClientTelephone), allClient.getLong(Constantes.colClientIdMensuration));
					listeClient.getItems().add(client);
				} while(allClient.next());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
