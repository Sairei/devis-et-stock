package main.devis;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class LigneDevisController {

    @FXML
    private Button cancelBtn;

    @FXML
    private void SaveLine(ActionEvent actionEvent) {

    }

    @FXML
    private void Cancel(ActionEvent actionEvent) {
        Stage win = (Stage) cancelBtn.getScene().getWindow();
        win.close();
    }


}
