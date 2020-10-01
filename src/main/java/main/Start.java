package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.base.GeneralBaseController;

public class Start extends Application {
    private GeneralBaseController genBase;

    @Override
    public void init() {
        genBase = new GeneralBaseController();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        genBase.start();

        Parent root = FXMLLoader.load(getClass().getResource("/accueil/accueil.fxml"));
        primaryStage.setTitle("Couture application");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
