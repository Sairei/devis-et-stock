package base;

import java.sql.*;
import java.util.ArrayList;

import common.Constantes;
import common.MethodesCommunes;

public class SQLInitialisation {
	public void initialisation() {
		MethodesCommunes.testFileExistAndCreate(Constantes.sqliteFilePath, false);
		
		Connection conn = SQLConnexion.getConnect();
		Statement state = null;
		try {
			state = conn.createStatement();
			
			createAllTable(state);
			
			if(null != state) {
				state.close();
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void createAllTable(Statement state) {
		final String reqCreateDevis = createTableDevis();
				
		final String reqCreateClient = createTableClient();
				
		final ArrayList<String> listReqCreateMensuration = createTableMensuration();
				
		try {
			state.execute(reqCreateDevis);
			state.execute(reqCreateClient);
			for(String reqCreateMensuration : listReqCreateMensuration) {
				state.execute(reqCreateMensuration);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** Fonction de contruction de la requete de create de la table devis **/
	private String createTableDevis() {
		return new StringBuilder()
				.append("CREATE TABLE IF NOT EXISTS ")
				.append(Constantes.tableDevis).append("(").append("\n\t")
				.append(Constantes.colDevisId).append(" INTEGER PRIMARY KEY, ").append("\n\t")
				.append(Constantes.colDevisDateCrea).append(" TEXT NOT NULL, ").append("\n\t")
			    .append(Constantes.colDevisTitre).append(" TEXT NOT NULL, ").append("\n\t")
			    .append(Constantes.colDevisDescription).append(" TEXT, ").append("\n\t")
			    .append(Constantes.colDevisStatut).append(" TEXT, ").append("\n\t")
				.append(Constantes.colDevisIdClient).append(" INTEGER")
				.append(")").toString();
	}
	
	/** Fonction de contruction de la requete de create de la table client **/
	private String createTableClient() {
		return new StringBuilder()
				.append("CREATE TABLE IF NOT EXISTS ")
				.append(Constantes.tableClient).append("(").append("\n\t")
				.append(Constantes.colClientId).append(" INTEGER PRIMARY KEY, ").append("\n\t")
				.append(Constantes.colClientGenre).append(" TEXT, ").append("\n\t")
				.append(Constantes.colClientNom).append(" TEXT NOT NULL, ").append("\n\t")
				.append(Constantes.colClientPrenom).append(" TEXT NOT NULL, ").append("\n\t")
				.append(Constantes.colClientAdresse).append(" TEXT, ").append("\n\t")
				.append(Constantes.colClientMail).append(" TEXT, ").append("\n\t")
				.append(Constantes.colClientTelephone).append(" TEXT, ").append("\n\t")
				.append(Constantes.colClientIdMensuration).append(" INTEGER")
				.append(")").toString();
	}
	
	/** Fonction de contruction de la requete de create de la table mensuration **/
	private ArrayList<String> createTableMensuration() {
		String reqMensurationGenerale = new StringBuilder()
				.append("CREATE TABLE IF NOT EXISTS ")
				.append(Constantes.tableMensurationGenerale).append("(").append("\n\t")
				.append(Constantes.colMensurationId).append(" INTEGER PRIMARY KEY, ").append("\n\t")
				.append(Constantes.colStature).append(" INTEGER, ").append("\n\t")
				.append(Constantes.colHauteurCorps).append(" INTEGER")
				.append(")").toString();
		String reqMensurationHaut= new StringBuilder()
				.append("CREATE TABLE IF NOT EXISTS ")
				.append(Constantes.tableMensurationHaut).append("(").append("\n\t")
				.append(Constantes.colMensurationId).append(" INTEGER PRIMARY KEY, ").append("\n\t")
				.append(Constantes.colTourCou).append(" INTEGER, ").append("\n\t")
				.append(Constantes.colCarrure).append(" INTEGER, ").append("\n\t")
				.append(Constantes.colTourPoitrine).append(" INTEGER, ").append("\n\t")
				.append(Constantes.colTourBuste).append(" INTEGER, ").append("\n\t")
				.append(Constantes.colTourTaille).append(" INTEGER, ").append("\n\t")
				.append(Constantes.colTourBras).append(" INTEGER, ").append("\n\t")
				.append(Constantes.colTourPoignet).append(" INTEGER, ").append("\n\t")
				.append(Constantes.colEcartPointeSeins).append(" INTEGER, ").append("\n\t")
				.append(Constantes.colLongueurEncolureSeins).append(" INTEGER, ").append("\n\t")
				.append(Constantes.colLongueurEpaule).append(" INTEGER, ").append("\n\t")
				.append(Constantes.colLongueurBras).append(" INTEGER, ").append("\n\t")
				.append(Constantes.colHauteurPoitrine).append(" INTEGER, ").append("\n\t")
				.append(Constantes.colHauteurTaille).append(" INTEGER, ").append("\n\t")
				.append(Constantes.colHauteurTailleSein).append(" INTEGER")
				.append(")").toString();
		String reqMensurationBas = new StringBuilder()
				.append("CREATE TABLE IF NOT EXISTS ")
				.append(Constantes.tableMensurationBas).append("(").append("\n\t")
				.append(Constantes.colMensurationId).append(" INTEGER PRIMARY KEY, ").append("\n\t")
				.append(Constantes.colTourHanches).append(" INTEGER, ").append("\n\t")
				.append(Constantes.colTourBassin).append(" INTEGER, ").append("\n\t")
				.append(Constantes.colTourCuisse).append(" INTEGER, ").append("\n\t")
				.append(Constantes.colTourGenou).append(" INTEGER, ").append("\n\t")
				.append(Constantes.colTourMollet).append(" INTEGER, ").append("\n\t")
				.append(Constantes.colTourCheville).append(" INTEGER, ").append("\n\t")
				.append(Constantes.colMontantDos).append(" INTEGER, ").append("\n\t")
				.append(Constantes.colLongueurEnfourchure).append(" INTEGER, ").append("\n\t")
				.append(Constantes.colHauteurTailleSol).append(" INTEGER, ").append("\n\t")
				.append(Constantes.colHauteurTailleGenou).append(" INTEGER, ").append("\n\t")
				.append(Constantes.colHauteurGenouCheville).append(" INTEGER, ").append("\n\t")
				.append(Constantes.colHauteurEntrejambeCheville).append(" INTEGER, ").append("\n\t")
				.append(Constantes.colHauteurChevilleSol).append(" INTEGER")
				.append(")").toString();
		String reqMensurationMain = new StringBuilder()
				.append("CREATE TABLE IF NOT EXISTS ")
				.append(Constantes.tableMensurationMain).append("(").append("\n\t")
				.append(Constantes.colMensurationId).append(" INTEGER PRIMARY KEY, ").append("\n\t")
				.append(Constantes.colTourPaumeOuvert).append(" INTEGER, ").append("\n\t")
				.append(Constantes.colTourPaumeFerme).append(" INTEGER, ").append("\n\t")
				.append(Constantes.colLongueurPaume).append(" INTEGER, ").append("\n\t")
				.append(Constantes.colLongueurMajeur).append(" INTEGER")				
				.append(");").toString();

		
		ArrayList<String> arr = new ArrayList<String>();
		arr.add(reqMensurationGenerale);
		arr.add(reqMensurationHaut);
		arr.add(reqMensurationBas);
		arr.add(reqMensurationMain);
		
		return arr; 
	}
}
