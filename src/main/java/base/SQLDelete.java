package base;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import common.Constantes;

public class SQLDelete {
	/** DELETE pour la table DEVIS **/
	
	
	/** DELETE pour la table CLIENT **/
	public static void deleteClientById(long id) {
		String requete = new StringBuilder().append("DELETE FROM ")
				.append(Constantes.tableClient).append("\n\t")
				.append("WHERE ").append(Constantes.colClientId).append(" = ").append(id).toString();
		
		execUpdate(requete);
	}
	
	private static void execUpdate(String requete) {
		try {
			Connection conn = SQLConnexion.connexion();
			Statement st = conn.createStatement();
			
			st.executeUpdate(requete);
			
			st.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
