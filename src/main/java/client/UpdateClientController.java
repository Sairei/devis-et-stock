package client;

import java.util.HashMap;

import base.SQLUpdate;
import client.mensuration.MensurationDAO;
import client.mensuration.MensurationRow;
import common.ApplicationNotification;
import common.ChangeListenerPerso;
import common.Constantes;
import common.MethodesCommunes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

public class UpdateClientController {
	private ClientDAO client;
	private MensurationDAO mensuration;
	
	@FXML
	private Label titre;
	@FXML
	private ToggleGroup civilite;
	@FXML
	private RadioButton homme;
	@FXML
	private RadioButton femme;
	@FXML
	private TextField nom; 
	@FXML
	private TextField prenom;
	@FXML
	private TextField adresse;
	@FXML
	private TextField code_postal;
	@FXML
	private TextField ville;
	@FXML
	private TextField mail;
	@FXML
	private TextField telephone;
	@FXML
	private TableView<MensurationRow> tableMensuration;
	@FXML
	private TableColumn<MensurationRow, String> typeMensuration;
	@FXML
	private TableColumn<MensurationRow, String> valeurMensuration;
	
	public UpdateClientController(ClientDAO client) {
		this.client = client;
	}
	
	@FXML
	public void initialize() {		
		this.titre.setText(client.toString());
		if(femme.getText().equals(this.client.getCivilite())){
			this.civilite.selectToggle(femme);
		} else {
			this.civilite.selectToggle(homme);			
		}
		this.nom.setText(client.getNom());
		this.prenom.setText(client.getPrenom());
		this.adresse.setText(client.getAdresseDecomposee()[0]);
		this.code_postal.setText(client.getAdresseDecomposee()[1]);
		this.ville.setText(client.getAdresseDecomposee()[2]);
		this.mail.setText(client.getMail());
		this.telephone.setText(client.getTel());
		
		mensuration = new MensurationDAO(client.getId(), "GET");
				
		typeMensuration.setCellValueFactory(
			    new PropertyValueFactory<MensurationRow,String>("nom")
			);
		typeMensuration.setStyle("-fx-font-weight: bold;");
		
		valeurMensuration.setCellValueFactory(
			    new PropertyValueFactory<MensurationRow,String>("valeur")
			);
		valeurMensuration.setCellFactory(TextFieldTableCell.forTableColumn());
		valeurMensuration.setOnEditCommit(
		    new EventHandler<CellEditEvent<MensurationRow, String>>() {
		        @Override
		        public void handle(CellEditEvent<MensurationRow, String> t) {
		            ((MensurationRow) t.getTableView().getItems().get(
		                t.getTablePosition().getRow())
		                ).setValeur(t.getNewValue());
		        }
		    }
		);
		valeurMensuration.setSortable(false);
		
		ObservableList<MensurationRow> data = FXCollections.observableArrayList(
				mensuration.toRow()
				);
		tableMensuration.setItems(data);
		tableMensuration.setEditable(true);
	}
	
	@FXML
	public void saveClient() {		
		boolean controleDesValeurs = controleValeurs();
		
		if (controleDesValeurs) {
			// Update le client
			String genre = femme.isSelected() ? femme.getText() : homme.getText();
			String strAdresse = adresse.getText().replaceAll(", ", ",xx ") 
					+ ", " + code_postal.getText() 
					+ " " + ville.getText(); 
			ClientDAO nouveauClient = new ClientDAO(client.getId(), genre, nom.getText(), prenom.getText(), strAdresse.toString(), mail.getText(), telephone.getText(), client.getId());
						
			SQLUpdate.updateClient(nouveauClient);

			// Update les mensurations
			HashMap<String, HashMap<String, String>> mapper = MethodesCommunes.convertListRowForMensuration(tableMensuration.getItems());
			MensurationDAO nouvelleMensu = new MensurationDAO(client.getId());
			nouvelleMensu.setGenerale(mapper.get("generale"));
			nouvelleMensu.setHaut(mapper.get("haut"));
			nouvelleMensu.setBas(mapper.get("bas"));
			nouvelleMensu.setMain(mapper.get("main"));
			
			if(!nouvelleMensu.getGenerale().isEqual(mensuration.getGenerale())) {
				SQLUpdate.updateMensurationGenerale(nouvelleMensu.getGenerale(), client.getId());
			}
			if(!nouvelleMensu.getHaut().isEqual(mensuration.getHaut())) {
				SQLUpdate.updateMensurationHaut(nouvelleMensu.getHaut(), client.getId());
			}
			if(!nouvelleMensu.getBas().isEqual(mensuration.getBas())) {
				SQLUpdate.updateMensurationBas(nouvelleMensu.getBas(), client.getId());
			}
			if(!nouvelleMensu.getMain().isEqual(mensuration.getMain())) {
				SQLUpdate.updateMensurationMain(nouvelleMensu.getMain(), client.getId());
			}
			
			// Ouverture de la popup
			new ApplicationNotification(nom.getScene(), String.format("Modification des informations de %s effectué avec succès", client.toString()));
			
			// Fermeture de la fenetre
			Stage stage = (Stage) nom.getScene().getWindow();
			stage.close();
		}
	}
	
	@FXML
	public void cancel() {
		Stage stage = (Stage) nom.getScene().getWindow();
		stage.close();
	}
	
	
	public void setupCleanBorderOnFocus() {
		this.nom.focusedProperty().addListener(new ChangeListenerPerso.ResetBorder(this.nom));
		this.prenom.focusedProperty().addListener(new ChangeListenerPerso.ResetBorder(this.prenom));
		this.adresse.focusedProperty().addListener(new ChangeListenerPerso.ResetBorder(this.adresse));
		this.code_postal.focusedProperty().addListener(new ChangeListenerPerso.ResetBorder(this.code_postal));
		this.ville.focusedProperty().addListener(new ChangeListenerPerso.ResetBorder(this.ville));
		this.mail.focusedProperty().addListener(new ChangeListenerPerso.ResetBorder(this.mail));
		this.telephone.focusedProperty().addListener(new ChangeListenerPerso.ResetBorder(this.telephone));
	}
	
	
	private boolean controleValeurs() {
		boolean value = true;
		
		if(this.nom.getText().isEmpty()) {
			this.nom.setStyle(Constantes.err_border);
			value = false;
		}
		if(this.prenom.getText().isEmpty()) {
			this.prenom.setStyle(Constantes.err_border);
			value = false;
		}
		if(this.adresse.getText().isEmpty()) {
			this.adresse.setStyle(Constantes.err_border);
			value = false;
		}
		if(this.code_postal.getText().isEmpty() ||
				!this.code_postal.getText().matches(Constantes.regex_code_postal)) {
			this.code_postal.setStyle(Constantes.err_border);
			value = false;
		}
		if(this.ville.getText().isEmpty()) {
			this.ville.setStyle(Constantes.err_border);
			value = false;
		}
		if(this.mail.getText().isEmpty() ||
				!this.mail.getText().matches(Constantes.regex_mail)) {
			this.mail.setStyle(Constantes.err_border);
			value = false;
		}
		if(this.telephone.getText().isEmpty() ||
				!this.telephone.getText().matches(Constantes.regex_telephone)) {
			this.telephone.setStyle(Constantes.err_border);
			value = false;
		}
		
		return value;
	}
}
