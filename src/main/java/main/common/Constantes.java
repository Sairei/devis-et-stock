package main.common;

public interface Constantes {

    /** Chemin vers la java.base de données **/
    public final static String baseDirPath = "./donnees";

    /** Chemin vers le dossier contenant les java.devis **/
    public final static String devisDirPath = baseDirPath + "/devis";

    /** Chemin vers le dossier contenant les java.devis **/
    public final static String sqliteFilePath = baseDirPath + "/couture.sqlite";

    
    /** Table en base DEVIS **/
    public final static String tableDevis = "DEVIS";
    public final static String colDevisId = "id_client";
    public final static String colDevisDateCrea = "date_creation_devis";
    public final static String colDevisTitre = "titre";
    public final static String colDevisDescription = "description";
    public final static String colDevisIdClient = "ref_id_client";
    
    /** Table en base CLIENT **/
    public final static String tableClient = "CLIENT";
    public final static String calClientId = "id_client";
}
