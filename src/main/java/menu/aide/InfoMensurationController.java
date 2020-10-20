package menu.aide;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;

public class InfoMensurationController {
	@FXML
	private ScrollPane scroll;
	@FXML
	private Text textPres;
	
	public void initTab(Scene scene) {
		textPres.wrappingWidthProperty().bind(scene.widthProperty().subtract(30));
		scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
	}
}
