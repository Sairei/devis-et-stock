package main.devis;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DevisController {
    @FXML
    private void AddLine() {
        try {
            // Ouverture de la fenêtre d'ajout
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/devis/ligneDevis.fxml"));
            Parent newLineWin = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(newLineWin));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

            // TODO: Faire l'actualisation après l'ajout de la ligne

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
