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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pdf.CreerDocument;
import popup.AlertPopup;

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
	private Button exportPdf;
	
	@FXML
	public void initialize() {		
		supprimerClient.disableProperty().bind(Bindings.isEmpty(listeClient.getSelectionModel().getSelectedItems()));
		modifierClient.disableProperty().bind(Bindings.isEmpty(listeClient.getSelectionModel().getSelectedItems()));
		exportPdf.disableProperty().bind(Bindings.isEmpty(listeClient.getSelectionModel().getSelectedItems()));
		
		updateListeClient();
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
		    
		    updateListeClient();
    	} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void upClient() {
		try {
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/client/updateClient.fxml"));
			
			UpdateClientController updateController = new UpdateClientController(listeClient.getSelectionModel().getSelectedItem());
			loader.setController(updateController);
			
			Parent root = loader.load();
			stage.setScene(new Scene(root));
		    stage.setTitle("Modifier un client");
		    stage.initModality(Modality.APPLICATION_MODAL);
		    stage.showAndWait();
		    
		    updateListeClient();
    	} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void delClient() {
		String header = "Suppression d'un client";
		String body = "Etes vous sûr de vouloir supprimer le client suivant : " + listeClient.getSelectionModel().getSelectedItem().toString();
		Optional<ButtonType> result = AlertPopup.openConfirmation(header, body);
		
		if (result.get().getText() == AlertPopup.buttonTypeConfirmer.getText()){
			ClientDAO client = listeClient.getSelectionModel().getSelectedItem();
			
			SQLDelete.deleteClientById(client.getId());
			
			updateListeClient();
		}
	}
	
	@FXML
	public void export() {
		ClientDAO client = listeClient.getSelectionModel().getSelectedItem();
		CreerDocument.creerPdfClient(client);
	}
	
	
	/**
	 * Fonction de mise à jour de l'écran de liste des clients
	 *   -> Appel à la fonction de mise à jour de la liste
	 *   -> Appel à la fonction de mise à jour des informations liées aux clients
	 */
	private void updateListeClient() {
		updateListe();
		updateInfo();
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
			e.printStackTrace();
		}
	}
	
	private void updateInfo() {
		// Nombre de client enregistré
		nbClientTotal.setText(String.valueOf(listeClient.getItems().size()));
	}
}
