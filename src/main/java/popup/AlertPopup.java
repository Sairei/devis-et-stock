package popup;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class AlertPopup {
	public static ButtonType buttonTypeConfirmer = new ButtonType("Confirmer");
	public static ButtonType buttonTypeAnnuler = new ButtonType("Annuler");
	
	public static Optional<ButtonType> openConfirmation(String header, String body) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Fenêtre de confirmation");
		alert.setHeaderText(header);
		alert.setContentText(body);
		
		ButtonType buttonTypeConfirmer = new ButtonType("Confirmer");
		ButtonType buttonTypeAnnuler = new ButtonType("Annuler");

		alert.getButtonTypes().setAll(buttonTypeConfirmer, buttonTypeAnnuler);

		return alert.showAndWait();
	}
}
