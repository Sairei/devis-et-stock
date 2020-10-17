package base;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import client.ClientDAO;
import common.Constantes;

public class SQLUpdate {
	public static void updateClient(ClientDAO client) {
		String requete = new StringBuffer().append("UPDATE ")
				.append(Constantes.tableClient).append("\nSET\n\t")
				.append(Constantes.colClientGenre).append(" = ").append("\'" + client.getCivilite() + "\'").append(",\n\t")
				.append(Constantes.colClientNom).append(" = ").append("\'" + client.getNom() + "\'").append(",\n\t")
				.append(Constantes.colClientPrenom).append(" = ").append("\'" + client.getPrenom() + "\'").append(",\n\t")
				.append(Constantes.colClientAdresse).append(" = ").append("\'" + client.getAdresse() + "\'").append(",\n\t")
				.append(Constantes.colClientMail).append(" = ").append("\'" + client.getMail() + "\'").append(",\n\t")
				.append(Constantes.colClientTelephone).append(" = ").append("\'" + client.getTel() + "\'").append(",\n\t")
				.append(Constantes.colClientIdMensuration).append(" = ").append("\'" + client.getIdMensuration() + "\'").append("\n")
				.append("WHERE\n\t")
				.append(Constantes.colClientId).append(" = ").append(client.getId())
				.toString();
		System.out.println(requete);
		
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
