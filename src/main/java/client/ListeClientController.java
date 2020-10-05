package client;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import base.SQLDelete;
import base.SQLSelect;
import common.Constantes;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import popup.AllertPopup;

public class ListeClientController {
	@FXML
	private ListView<ClientDAO> listeClient;
	@FXML
	private Label nbClientTotal;
	@FXML
	private Button supprimerClient;
	@FXML
	private Button modifierClient;
	
	@FXML
	public void initialize() {		
		supprimerClient.disableProperty().bind(Bindings.isEmpty(listeClient.getSelectionModel().getSelectedItems()));
		modifierClient.disableProperty().bind(Bindings.isEmpty(listeClient.getSelectionModel().getSelectedItems()));
		
		updateListe();
	}
	
	@FXML
	public void addClient() {
		try {
			Stage stage = new Stage();
		    Parent root = FXMLLoader.load(getClass().getResource("/client/nouveauClient.fxml"));
		    stage.setScene(new Scene(root));
		    stage.setTitle("Enregistrement d'un nouveau client");
		    stage.initModality(Modality.APPLICATION_MODAL);
		    stage.showAndWait();
		    
		    updateListe();
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	public void delClient() {
		String header = "Suppression d'un client";
		String body = "Etes vous sûr de vouloir supprimer le client suivant : " + listeClient.getSelectionModel().getSelectedItem().toString();
		Optional<ButtonType> result = AllertPopup.openConfirmation(header, body);
		
		if (result.get().getText() == AllertPopup.buttonTypeConfirmer.getText()){
			ClientDAO client = listeClient.getSelectionModel().getSelectedItem();
			
			SQLDelete.deleteClientById(client.getId());
			
			updateListe();
		}
	}
	
	private void updateListe() {
		listeClient.getItems().removeAll(listeClient.getItems());
		
		ResultSet allClient = SQLSelect.selectAllClient();
		try {
			if(null == allClient || !allClient.next()) {
				listeClient.setPlaceholder(new Label(Constantes.aucun_client));
			} else {
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
