package menu.aide;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class InfoMensurationController {
	private Scene parent;
	@FXML
	private ScrollPane scroll;
	@FXML
	private Text textPres;
	@FXML
	private AnchorPane mesureGenerale;
	@FXML
	private AnchorPane mesureHaut;
	@FXML
	private AnchorPane mesureBas;
	@FXML
	private AnchorPane mesureMain;
	
	
	public void initTab(Scene scene) {
		this.parent = scene;
		
		textPres.wrappingWidthProperty().bind(this.parent.widthProperty().subtract(30));
		scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		
		initMesureGenerale();
		initMesureHaut();
		initMesureBas();
		initMesureMain();
	}
	
	private void initMesureGenerale() {
		VBox box = parseJsonFor("generale");
		box.setMaxHeight(5000);
		
		// Ajout du VBox dans l'AnchorPane
		mesureGenerale.getChildren().add(box);
		AnchorPane.setTopAnchor(mesureGenerale.getChildren().get(0), 5.0);
		AnchorPane.setLeftAnchor(mesureGenerale.getChildren().get(0), 5.0);
		AnchorPane.setRightAnchor(mesureGenerale.getChildren().get(0), 5.0);
		AnchorPane.setBottomAnchor(mesureGenerale.getChildren().get(0), 5.0);
	}
	
	private void initMesureHaut() {
		VBox box = parseJsonFor("haut");
		box.setMaxHeight(5000);
		
		// Ajout du VBox dans l'AnchorPane
		mesureHaut.getChildren().add(box);
		AnchorPane.setTopAnchor(mesureHaut.getChildren().get(0), 5.0);
		AnchorPane.setLeftAnchor(mesureHaut.getChildren().get(0), 5.0);
		AnchorPane.setRightAnchor(mesureHaut.getChildren().get(0), 5.0);
		AnchorPane.setBottomAnchor(mesureHaut.getChildren().get(0), 5.0);
	}
	
	private void initMesureBas() {
		VBox box = parseJsonFor("bas");
		box.setMaxHeight(5000);
		
		// Ajout du VBox dans l'AnchorPane
		mesureBas.getChildren().add(box);
		AnchorPane.setTopAnchor(mesureBas.getChildren().get(0), 5.0);
		AnchorPane.setLeftAnchor(mesureBas.getChildren().get(0), 5.0);
		AnchorPane.setRightAnchor(mesureBas.getChildren().get(0), 5.0);
		AnchorPane.setBottomAnchor(mesureBas.getChildren().get(0), 5.0);		
	}
	
	private void initMesureMain() {
		VBox box = parseJsonFor("main");
		box.setMaxHeight(5000);
		
		// Ajout du VBox dans l'AnchorPane
		mesureMain.getChildren().add(box);
		AnchorPane.setTopAnchor(mesureMain.getChildren().get(0), 5.0);
		AnchorPane.setLeftAnchor(mesureMain.getChildren().get(0), 5.0);
		AnchorPane.setRightAnchor(mesureMain.getChildren().get(0), 5.0);
		AnchorPane.setBottomAnchor(mesureMain.getChildren().get(0), 5.0);		
	}
	
	private VBox parseJsonFor(String type) {
		VBox box = new VBox();
		
		JSONParser jsonParser = new JSONParser();
		try (FileReader reader = new FileReader("src/main/resources/_fichier/mensuration.json"))
        {
            JSONObject obj = (JSONObject) jsonParser.parse(reader);
            JSONArray arr = (JSONArray) obj.get(type);
            for(int i=0; i<arr.size(); i++) {
            	JSONObject mensuration = (JSONObject) arr.get(i);
            	
        		Label titre = new Label(mensuration.get("titre").toString());
        		Text desc = new Text(mensuration.get("description").toString());
        		desc.wrappingWidthProperty().bind(this.parent.widthProperty().subtract(75));

        		box.getChildren().add(titre);
        		box.getChildren().add(desc);
        		
        		if(i < arr.size()-1) {
        			VBox.setMargin(desc, new Insets(0, 0, 15, 0));
        		}
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return box;
	}
}
