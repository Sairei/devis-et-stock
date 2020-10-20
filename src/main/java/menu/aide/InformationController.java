package menu.aide;

import javafx.fxml.FXML;
import javafx.scene.control.TabPane;

public class InformationController {
	@FXML
	private TabPane aide;
	@FXML
	private InfoMensurationController mensurationController;
	
	@FXML
	public void initialize() {
		mensurationController.initTab(aide.getScene());
	}
}
