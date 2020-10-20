package menu;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MenuController {
	@FXML
	private ToolBar menuItems;
	
	public void isAccueil() {
		menuItems.getItems().remove(0);
	}
	
	@FXML
	public void initialize() {
		
	}
	
	
	// Bouton de retour à l'accueil
	@FXML
	public void retourAccueil() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/accueil/accueil.fxml"));
			Scene scene = menuItems.getScene();
			scene.getWindow().setHeight(600);
			scene.getWindow().setWidth(500);
			scene.setRoot(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	// Bouton du menu "fichier"
	@FXML
    public void openListeDevis() {
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("/devis/listeDevis.fxml"));
			Scene scene = menuItems.getScene();
			scene.getWindow().setHeight(400);
			scene.getWindow().setWidth(650);
			scene.setRoot(root);
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@FXML
    public void openListeClient() {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/client/listeClient.fxml"));
			Scene scene = menuItems.getScene();
			scene.getWindow().setHeight(400);
			scene.getWindow().setWidth(650);
			scene.setRoot(root);
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	
	// Bouton du menu "Aide"
	@FXML
	public void openInformation() {
		try {			
			Stage stage = new Stage();
			Scene root = FXMLLoader.load(getClass().getResource("/menu/aide/informations.fxml"));
			
			stage.setHeight(400);
			stage.setWidth(650);
			
			stage.setScene(root);
		    stage.setTitle("Modifier un client");
		    stage.initModality(Modality.APPLICATION_MODAL);
		    stage.showAndWait();
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
