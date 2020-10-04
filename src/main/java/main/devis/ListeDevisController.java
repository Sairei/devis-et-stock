package main.devis;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.base.SQLSelect;
import main.common.Constantes;

public class ListeDevisController {
	@FXML
	private ListView<DevisDAO> listeDevis;
	@FXML
	private Label nbDevisTotal;
	@FXML
	private Button supprimerDevis;
	@FXML
	private Button modifierDevis;
	
	@FXML
	public void initialize() {
		supprimerDevis.disableProperty().bind(Bindings.isEmpty(listeDevis.getSelectionModel().getSelectedItems()));
		modifierDevis.disableProperty().bind(Bindings.isEmpty(listeDevis.getSelectionModel().getSelectedItems()));
		
		updateListe();
	}
	
	@FXML
	public void addDevis() {
		try {
			Stage stage = new Stage();
		    Parent root = FXMLLoader.load(getClass().getResource("/devis/nouveauDevis.fxml"));
		    stage.setScene(new Scene(root));
		    stage.setTitle("Création d'un nouveau devis");
		    stage.initModality(Modality.APPLICATION_MODAL);
		    stage.showAndWait();
		    
		    updateListe();
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void updateListe() {
		listeDevis.getItems().removeAll(listeDevis.getItems());
		
		ResultSet allDevis = SQLSelect.selectAllDevis();
		try {
			if(null == allDevis || !allDevis.next()) {
				listeDevis.setPlaceholder(new Label(Constantes.aucun_devis));
			} else {
				do {
					DevisDAO devis = new DevisDAO(allDevis.getString(Constantes.colDevisDateCrea), allDevis.getString(Constantes.colDevisTitre), 
							allDevis.getString(Constantes.colDevisDescription), allDevis.getLong(Constantes.colDevisIdClient));
				    listeDevis.getItems().add(devis);
				} while(allDevis.next());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
