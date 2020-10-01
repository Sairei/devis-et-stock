package main.menu;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToolBar;

public class MenuController {
	@FXML
	private ToolBar menuItems;
	
	@FXML
	public void initialize() {
		
	}
	
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
	
	public void isAccueil() {
		menuItems.getItems().remove(0);
	}
}
