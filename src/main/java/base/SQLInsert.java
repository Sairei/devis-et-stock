package base;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import client.ClientDAO;
import common.Constantes;
import common.StatutDevis;
import devis.DevisDAO;

public class SQLInsert {
	public static void insertNouveauDevis(DevisDAO devis) {
		String requete = new StringBuffer().append("INSERT INTO ")
				.append(Constantes.tableDevis).append("(")
				.append(Constantes.colDevisDateCrea).append(", ").append(Constantes.colDevisTitre).append(", ")
				.append(Constantes.colDevisDescription).append(", ").append(Constantes.colDevisStatut).append(", ")
				.append(Constantes.colDevisIdClient).append(")").append("\n\t")
				.append(" VALUES (")
				.append("\'" + devis.getDateCreation() + "\'").append(", ").append("\'" + devis.getTitre() + "\'").append(", ")
				.append("\'" + devis.getDescription () + "\'").append(", ").append("\'" + StatutDevis.EN_COUR + "\'").append(", ")
				.append(devis.getClient().getId()).append(")")
				.toString();
		System.out.println(requete);
		
		execUpdate(requete);
	}
	
	public static void insertNouveauClient(ClientDAO client) {
		String requete = new StringBuffer().append("INSERT INTO ")
				.append(Constantes.tableClient).append("(")
				.append(Constantes.colClientGenre).append(", ").append(Constantes.colClientNom).append(", ")
				.append(Constantes.colClientPrenom).append(", ").append(Constantes.colClientAdresse).append(", ")
				.append(Constantes.colClientMail).append(", ").append(Constantes.colClientTelephone).append(", ")
				.append(Constantes.colClientIdMensuration).append(")").append("\n\t")
				.append(" VALUES (")
				.append("\'" + client.getCivilite() + "\'").append(", ").append("\'" + client.getNom() + "\'").append(", ")
				.append("\'" + client.getPrenom() + "\'").append(", ").append("\'" + client.getAdresse() + "\'").append(", ")
				.append("\'" + client.getMail() + "\'").append(", ").append("\'" + client.getTel() + "\'").append(", ")
				.append("\'" + client.getIdMensuration() + "\'").append(")") //TODO : Changer pour l'id du client
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
