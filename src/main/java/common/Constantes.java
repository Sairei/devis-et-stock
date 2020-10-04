package common;

public interface Constantes {

    /** Chemin vers la java.base de données **/
    public final static String baseDirPath = "./donnees";

    /** Chemin vers le dossier contenant les java.devis **/
    public final static String devisDirPath = baseDirPath + "/devis";

    /** Chemin vers le dossier contenant les java.devis **/
    public final static String sqliteFilePath = baseDirPath + "/couture.sqlite";

    /** String dans l'application **/
    public final static String aucun_devis = "Aucun devis n'est présent dans l'application";    
    public final static String aucun_client = "Aucun client n'a été enregistré";    
    
    /** Table en base DEVIS **/
    public final static String tableDevis = "DEVIS";
    public final static String colDevisId = "id_client";
    public final static String colDevisDateCrea = "date_creation_devis";
    public final static String colDevisTitre = "titre";
    public final static String colDevisDescription = "description";
    public final static String colDevisStatut = "statut";
    public final static String colDevisIdClient = "ref_id_client";
    
    /** Table en base CLIENT **/
    public final static String tableClient = "CLIENT";
    public final static String colClientId = "id_client";
    public final static String colClientGenre = "genre_client";
    public final static String colClientNom = "nom_client";
    public final static String colClientPrenom = "prenom_client";    
    public final static String colClientAdresse = "adresse_client";    
    public final static String colClientMail = "mail_client";    
    public final static String colClientTelephone = "telephone_client";    
    public final static String colClientIdMensuration = "ref_id_mensuration";    
    
    /** Table en base MENSURATION **/
    public final static String tableMensuration = "Mensuration";
    public final static String colMensurationId = "id_mensuration";
}
