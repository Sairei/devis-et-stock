package main.accueil;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class AccueilController {
    @FXML
    private ListView<String> listeDevis;
    @FXML
    private ListView<String> listeStock;

    @FXML
    private void initialize() {
        

//        // Initialisation de la liste des devis
//        final ArrayList<DevisDAO> arrayDevis = baseRepoController.parseDevis();
//        if (arrayDevis.isEmpty()) {
//            listeDevis.setPlaceholder(new Label("Aucun devis n'est présent..."));
//        } else {
//            for(DevisDAO d : arrayDevis) {
//                listeDevis.getItems().add(d.toItemList());
//            }
//        }
//
//        // Initialisation de la liste du stock
//        final ArrayList<StockDAO> arrayStock = baseRepoController.parseStock();
//        if (arrayStock.isEmpty()) {
//            listeStock.setPlaceholder(new Label("Aucun objet n'est présent dans le stock..."));
//        } else {
//            for(StockDAO s : arrayStock) {
//                listeStock.getItems().add(s.toItemList());
//            }
//        }
    }

    @FXML
    public void AddDevis() {
    }

    @FXML
    public void AddStock() {
    }
}
