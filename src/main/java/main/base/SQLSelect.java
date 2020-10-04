package main.base;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import main.common.Constantes;

public class SQLSelect {
	/** SELECT pour la table DEVIS **/
	public static ResultSet selectAllDevis() {
		String requete = new StringBuilder().append("SELECT * FROM ")
				.append(Constantes.tableDevis).toString();
		
		return execSelect(requete);
	}
	
	
	/** SELECT pour la table DEVIS **/
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
	
	
	/** Fonction pemettant d'executer une requetes **/
	public static ResultSet execSelect(String requete) {
		ResultSet res = null;
		try {
			Connection conn = SQLConnexion.connexion();
			Statement st = conn.createStatement();
			
			res = st.executeQuery(requete);
			
//			st.close();
//			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
}