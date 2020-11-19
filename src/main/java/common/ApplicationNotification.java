package common;

import org.controlsfx.control.Notifications;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.util.Duration;

public class ApplicationNotification {
	public ApplicationNotification(Scene scene, String texte) {
		Notifications notif = Notifications.create()
				.hideAfter(Duration.seconds(5))
				.hideCloseButton()
				.position(Pos.TOP_RIGHT)
				.text(texte)
				.owner(scene.getFocusOwner());
		
		notif.showConfirm();
	}
}
