package base;

import java.sql.*;

import common.Constantes;
import common.MethodesCommunes;

public class SQLInitialisation {
	public void initialisation() {
		MethodesCommunes.testFileExistAndCreate(Constantes.sqliteFilePath, false);
		
		Connection conn = SQLConnexion.connexion();
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
		System.out.println(reqCreateDevis + "\n");
		
		final String reqCreateClient = createTableClient();
		System.out.println(reqCreateClient + "\n");
		
		final String reqCreateMensuration = createTableMensuration();
		System.out.println(reqCreateMensuration + "\n");
		
		try {
			state.execute(reqCreateDevis);
			state.execute(reqCreateClient);
			state.execute(reqCreateMensuration);
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
	private String createTableMensuration() {
		return new StringBuilder()
				.append("CREATE TABLE IF NOT EXISTS ")
				.append(Constantes.tableMensuration).append("(").append("\n\t")
				.append(Constantes.colMensurationId).append(" INTEGER PRIMARY KEY")
				.append(")").toString();
	}
}
