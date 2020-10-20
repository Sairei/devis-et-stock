package common;

import org.controlsfx.control.Notifications;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.util.Duration;

public class Notification {
	public Notification(Node scene) {
		Notifications notif = Notifications.create()
				.hideAfter(Duration.INDEFINITE)
				.position(Pos.TOP_RIGHT)
				.owner(scene);
		notif.showInformation();
	}
}
