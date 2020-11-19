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
		
		execDelete(requete);
		
		deleteMensuration(id);
	}
	
	/** Delete pour les tables de mensuration **/
	public static void deleteMensuration(long id) {
		String mensurationGenerale = new StringBuilder().append("DELETE FROM ")
				.append(Constantes.tableMensurationGenerale).append("\n\t")
				.append("WHERE ").append(Constantes.colMensurationId).append(" = ").append(id).toString();
		String mensurationHaut= new StringBuilder().append("DELETE FROM ")
				.append(Constantes.tableMensurationHaut).append("\n\t")
				.append("WHERE ").append(Constantes.colMensurationId).append(" = ").append(id).toString();
		String mensurationBas = new StringBuilder().append("DELETE FROM ")
				.append(Constantes.tableMensurationBas).append("\n\t")
				.append("WHERE ").append(Constantes.colMensurationId).append(" = ").append(id).toString();
		String mensurationMain = new StringBuilder().append("DELETE FROM ")
				.append(Constantes.tableMensurationMain).append("\n\t")
				.append("WHERE ").append(Constantes.colMensurationId).append(" = ").append(id).toString();
		
		execDelete(mensurationGenerale);
		execDelete(mensurationHaut);
		execDelete(mensurationBas);
		execDelete(mensurationMain);
	}
	
	private static void execDelete(String requete) {
		try {
			Connection conn = SQLConnexion.getConnect();
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
