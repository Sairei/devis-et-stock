package main.base;

import java.sql.*;

import main.common.Constantes;
import main.common.MethodesCommunes;

public class SQLInitialisation {
	public void initialisation() {
		MethodesCommunes.testFileExistAndCreate(Constantes.sqliteFilePath, false);
		
		Connection conn = SQLConnexion.connexion();
		Statement state = null;
		try {
			state = conn.createStatement();
			
			createTable(state);
			
			if(null != state) {
				state.close();
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void createTable(Statement state) {
		final String reqCreateDevis = new StringBuilder()
				.append("CREATE TABLE IF NOT EXIST ")
				.append(Constantes.tableDevis).append("(")
				.append(Constantes.colDevisId).append(" INTEGER PRIMARY KEY, ")
				.append(Constantes.colDevisDateCrea).append(" TEXT NOT NULL, ")
			    .append(Constantes.colDevisTitre).append(" TEXT NOT NULL, ")
			    .append(Constantes.colDevisDescription).append(" TEXT, ")
				.append(Constantes.colDevisIdClient).append(" INTEGER NOT NULL")
				.append(")").toString();
		System.out.println(reqCreateDevis);
		final String reqCreateClient = "";
	}
}
