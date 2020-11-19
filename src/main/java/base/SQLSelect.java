package base;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.Constantes;

public class SQLSelect {
	/** SELECT pour la table DEVIS **/
	public static ResultSet selectAllDevis() {
		String requete = new StringBuilder().append("SELECT * FROM ")
				.append(Constantes.tableDevis).toString();
		
		return execSelect(requete);
	}
	
	
	/** SELECT pour la table CLIENT **/
	public static ResultSet selectAllClient() {
		String requete = new StringBuilder().append("SELECT * FROM ")
				.append(Constantes.tableClient).toString();
		
		return execSelect(requete);
	}

	public static ResultSet selectClientById(long id) {
		String requete = new StringBuilder().append("SELECT * FROM ")
				.append(Constantes.tableClient).append("\n\t")
				.append("WHERE ").append(Constantes.colClientId).append(" = ").append(id).toString();
		
		return execSelect(requete);
	}
	
	
	/** SELECT pour toutes les tables de mensuration **/
	public static ArrayList<ResultSet> selectAllMensurationById(long id) {
		ArrayList<ResultSet> resultat = new ArrayList<ResultSet>();
		resultat.add(selectMensurationGeneraleById(id));
		resultat.add(selectMensurationHautById(id));
		resultat.add(selectMensurationBasById(id));
		resultat.add(selectMensurationMainById(id));
		return resultat;
	}
	
	public static ResultSet selectMensurationGeneraleById(long id) {
		String requeteGenerale = new StringBuilder().append("SELECT * FROM ")
				.append(Constantes.tableMensurationGenerale).append("\n\t")
				.append("WHERE ").append(Constantes.colMensurationId).append(" = ").append(id).toString();
		
		return execSelect(requeteGenerale);
	}
	
	public static ResultSet selectMensurationHautById(long id) {		
		String requeteHaut = new StringBuilder().append("SELECT * FROM ")
				.append(Constantes.tableMensurationHaut).append("\n\t")
				.append("WHERE ").append(Constantes.colMensurationId).append(" = ").append(id).toString();
		
		return execSelect(requeteHaut);
	}
	
	public static ResultSet selectMensurationBasById(long id) {		
		String requeteBas = new StringBuilder().append("SELECT * FROM ")
				.append(Constantes.tableMensurationBas).append("\n\t")
				.append("WHERE ").append(Constantes.colMensurationId).append(" = ").append(id).toString();
		
		return execSelect(requeteBas);
	}

	public static ResultSet selectMensurationMainById(long id) {		
		String requeteMain = new StringBuilder().append("SELECT * FROM ")
				.append(Constantes.tableMensurationMain).append("\n\t")
				.append("WHERE ").append(Constantes.colMensurationId).append(" = ").append(id).toString();
		
		return execSelect(requeteMain);
	}
	
	
	/** Fonction pemettant d'executer une requetes **/
	public static ResultSet execSelect(String requete) {
		ResultSet res = null;
		try {
			Connection conn = SQLConnexion.getConnect();
			Statement st = conn.createStatement();
			
			res = st.executeQuery(requete);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
}