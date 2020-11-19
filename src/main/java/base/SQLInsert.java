package base;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import client.ClientDAO;
import common.Constantes;
import common.StatutDevis;
import devis.DevisDAO;

public class SQLInsert {
	/* Insertion d'un nouveau devis */
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
		
		execInsert(requete);
	}
	
	/* Insertion d'un nouveau client */
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
				.append("\'" + client.getIdMensuration() + "\'").append(")")
				.toString();
		System.out.println(requete);
		
		execInsert(requete);
		
		insertNouvelleMensuration();
	}
	
	/* Insertion de nouvelles mensurations (s'effectue en même temps que l'insertion d'un client) */
	public static void insertNouvelleMensuration() {
		String requeteMGeneral = new StringBuffer().append("INSERT INTO ")
				.append(Constantes.tableMensurationGenerale).append("(")
				.append(Constantes.colStature).append(", ").append(Constantes.colHauteurCorps).append(")").append("\n\t")
				.append(" VALUES (").append("0, 0").append(")")
				.toString();
		System.out.println(requeteMGeneral);
		String requeteMHaut = new StringBuffer().append("INSERT INTO ")
				.append(Constantes.tableMensurationHaut).append("(")
				.append(Constantes.colTourCou).append(", ").append(Constantes.colCarrure).append(", ")
				.append(Constantes.colTourPoitrine).append(", ").append(Constantes.colTourBuste).append(", ")
				.append(Constantes.colTourTaille).append(", ").append(Constantes.colTourBras).append(", ")
				.append(Constantes.colTourPoignet).append(", ").append(Constantes.colEcartPointeSeins).append(", ")
				.append(Constantes.colLongueurEncolureSeins).append(", ").append(Constantes.colLongueurEpaule).append(", ")
				.append(Constantes.colLongueurBras).append(", ").append(Constantes.colHauteurPoitrine).append(", ")
				.append(Constantes.colHauteurTaille).append(", ").append(Constantes.colHauteurTailleSein).append(")").append("\n\t")
				.append(" VALUES (").append("0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0").append(")")
				.toString();
		System.out.println(requeteMHaut);
		String requeteMBas = new StringBuffer().append("INSERT INTO ")
				.append(Constantes.tableMensurationBas).append("(")
				.append(Constantes.colTourHanches).append(", ").append(Constantes.colTourBassin).append(", ")
				.append(Constantes.colTourCuisse).append(", ").append(Constantes.colTourGenou).append(", ")
				.append(Constantes.colTourMollet).append(", ").append(Constantes.colTourCheville).append(", ")
				.append(Constantes.colMontantDos).append(", ").append(Constantes.colLongueurEnfourchure).append(", ")
				.append(Constantes.colHauteurTailleSol).append(", ").append(Constantes.colHauteurTailleGenou).append(", ")
				.append(Constantes.colHauteurGenouCheville).append(", ").append(Constantes.colHauteurEntrejambeCheville).append(", ")
				.append(Constantes.colHauteurChevilleSol).append(")").append("\n\t")
				.append(" VALUES (").append("0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0").append(")")
				.toString();
		System.out.println(requeteMBas);
		String requeteMMain = new StringBuffer().append("INSERT INTO ")
				.append(Constantes.tableMensurationMain).append("(")
				.append(Constantes.colTourPaumeOuvert).append(", ").append(Constantes.colTourPaumeFerme).append(", ")
				.append(Constantes.colLongueurPaume).append(", ").append(Constantes.colLongueurMajeur).append(")").append("\n\t")
				.append(" VALUES (").append("0, 0, 0, 0").append(")")
				.toString();
		System.out.println(requeteMMain);
		
		execInsert(requeteMGeneral);
		execInsert(requeteMHaut);
		execInsert(requeteMBas);
		execInsert(requeteMMain);
	}
	
	
	/** Fonction pemettant d'executer une requetes **/
	private static void execInsert(String requete) {
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
