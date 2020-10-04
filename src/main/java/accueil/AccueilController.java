package accueil;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import menu.MenuController;

public class AccueilController {
	@FXML
	private MenuController menuController;
	@FXML
	private Label labelAccueil;
	
    @FXML
    private void initialize() {
    	menuController.isAccueil();
    }
    
    @FXML
    public void openListeDevis() {
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("/devis/listeDevis.fxml"));
			Scene scene = labelAccueil.getScene();
			scene.getWindow().setHeight(400);
			scene.getWindow().setWidth(650);
			scene.setRoot(root);
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
	public void addDevis() {
		try {
			Stage stage = new Stage();
		    Parent root = FXMLLoader.load(getClass().getResource("/devis/nouveauDevis.fxml"));
		    stage.setScene(new Scene(root));
		    stage.setTitle("Création d'un nouveau devis");
		    stage.initModality(Modality.APPLICATION_MODAL);
		    stage.show();
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    
    
    @FXML
    public void openListeClient() {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/client/listeClient.fxml"));
			Scene scene = labelAccueil.getScene();
			scene.getWindow().setHeight(400);
			scene.getWindow().setWidth(650);
			scene.setRoot(root);
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
	public void addClient() {
		try {
			Stage stage = new Stage();
		    Parent root = FXMLLoader.load(getClass().getResource("/client/nouveauClient.fxml"));
		    stage.setScene(new Scene(root));
		    stage.setTitle("Création d'un nouveau devis");
		    stage.initModality(Modality.APPLICATION_MODAL);
		    stage.show();
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
