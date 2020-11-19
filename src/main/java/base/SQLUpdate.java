package base;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import client.ClientDAO;
import client.mensuration.MensurationBasDAO;
import client.mensuration.MensurationGeneraleDAO;
import client.mensuration.MensurationHautDAO;
import client.mensuration.MensurationMainDAO;
import common.Constantes;

public class SQLUpdate {
	/** UPDATE de la table CLIENT **/
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
	
	
	/** UPDATE des table de mensuration **/
	public static void updateMensurationGenerale(MensurationGeneraleDAO mensuration, long id) {
		String requete = new StringBuffer().append("UPDATE ")
				.append(Constantes.tableMensurationGenerale).append("\nSET\n\t")
				.append(Constantes.colStature).append(" = ").append(mensuration.getStature()).append(",\n\t")
				.append(Constantes.colHauteurCorps).append(" = ").append(mensuration.getHauteurCorps()).append("\n")
				.append("WHERE\n\t")
				.append(Constantes.colMensurationId).append(" = ").append(id)
				.toString();
		System.out.println(requete);
		
		execUpdate(requete);
	}
	
	public static void updateMensurationHaut(MensurationHautDAO mensuration, long id) {
		String requete = new StringBuffer().append("UPDATE ")
				.append(Constantes.tableMensurationHaut).append("\nSET\n\t")
				.append(Constantes.colTourCou).append(" = ").append(mensuration.getTourCou()).append(",\n\t")
				.append(Constantes.colCarrure).append(" = ").append(mensuration.getCarrure()).append(",\n\t")
				.append(Constantes.colTourPoitrine).append(" = ").append(mensuration.getTourPoitrine()).append(",\n\t")
				.append(Constantes.colTourBuste).append(" = ").append(mensuration.getTourBuste()).append(",\n\t")
				.append(Constantes.colTourTaille).append(" = ").append(mensuration.getTourTaille()).append(",\n\t")
				.append(Constantes.colTourBras).append(" = ").append(mensuration.getTourBras()).append(",\n\t")
				.append(Constantes.colTourPoignet).append(" = ").append(mensuration.getTourPoignet()).append(",\n\t")
				.append(Constantes.colEcartPointeSeins).append(" = ").append(mensuration.getEcartPointeSeins()).append(",\n\t")
				.append(Constantes.colLongueurEncolureSeins).append(" = ").append(mensuration.getLongueurEncolureSein()).append(",\n\t")
				.append(Constantes.colLongueurEpaule).append(" = ").append(mensuration.getLongueurEpaule()).append(",\n\t")
				.append(Constantes.colLongueurBras).append(" = ").append(mensuration.getLongueurBras()).append(",\n\t")
				.append(Constantes.colHauteurPoitrine).append(" = ").append(mensuration.getHauteurPoitrine()).append(",\n\t")
				.append(Constantes.colHauteurTaille).append(" = ").append(mensuration.getHauteurTaille()).append(",\n\t")
				.append(Constantes.colHauteurTailleSein).append(" = ").append(mensuration.getHauteurTailleSein()).append("\n")
				.append("WHERE\n\t")
				.append(Constantes.colMensurationId).append(" = ").append(id)
				.toString();
		System.out.println(requete);
		
		execUpdate(requete);
	}

	public static void updateMensurationBas(MensurationBasDAO mensuration, long id) {
		String requete = new StringBuffer().append("UPDATE ")
				.append(Constantes.tableMensurationBas).append("\nSET\n\t")
				.append(Constantes.colTourHanches).append(" = ").append(mensuration.getTourHanches()).append(",\n\t")
				.append(Constantes.colTourBassin).append(" = ").append(mensuration.getTourBassin()).append(",\n\t")
				.append(Constantes.colTourCuisse).append(" = ").append(mensuration.getTourCuisse()).append(",\n\t")
				.append(Constantes.colTourGenou).append(" = ").append(mensuration.getTourGenou()).append(",\n\t")
				.append(Constantes.colTourMollet).append(" = ").append(mensuration.getTourMollet()).append(",\n\t")
				.append(Constantes.colTourCheville).append(" = ").append(mensuration.getTourCheville()).append(",\n\t")
				.append(Constantes.colMontantDos).append(" = ").append(mensuration.getMontantDos()).append(",\n\t")
				.append(Constantes.colLongueurEnfourchure).append(" = ").append(mensuration.getLongueurEnfourchure()).append(",\n\t")
				.append(Constantes.colHauteurTailleSol).append(" = ").append(mensuration.getHauteurTailleSol()).append(",\n\t")
				.append(Constantes.colHauteurTailleGenou).append(" = ").append(mensuration.getHauteurTailleGenou()).append(",\n\t")
				.append(Constantes.colHauteurGenouCheville).append(" = ").append(mensuration.getHauteurGenouCheville()).append(",\n\t")
				.append(Constantes.colHauteurEntrejambeCheville).append(" = ").append(mensuration.getHauteurEntrejambeCheville()).append(",\n\t")
				.append(Constantes.colHauteurChevilleSol).append(" = ").append(mensuration.getHauteurChevilleSol()).append("\n")
				.append("WHERE\n\t")
				.append(Constantes.colMensurationId).append(" = ").append(id)
				.toString();
		System.out.println(requete);
		
		execUpdate(requete);
	}
	
	public static void updateMensurationMain(MensurationMainDAO mensuration, long id) {
		String requete = new StringBuffer().append("UPDATE ")
				.append(Constantes.tableMensurationMain).append("\nSET\n\t")
				.append(Constantes.colTourPaumeOuvert).append(" = ").append(mensuration.getTourPaumeOuvert()).append(",\n\t")
				.append(Constantes.colTourPaumeFerme).append(" = ").append(mensuration.getTourPaumeFerme()).append(",\n\t")
				.append(Constantes.colLongueurPaume).append(" = ").append(mensuration.getLongueurPaume()).append(",\n\t")
				.append(Constantes.colLongueurMajeur).append(" = ").append(mensuration.getLongueurMajeur()).append("\n")
				.append("WHERE\n\t")
				.append(Constantes.colMensurationId).append(" = ").append(id)
				.toString();
		System.out.println(requete);
		
		execUpdate(requete);
	}
	
	/** Fonction permettant d'executer les requêtes d'update **/
	private static void execUpdate(String requete) {
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
