package common;

public interface Constantes {

	public final static String err_border = "-fx-text-box-border: #FF2222;";
	
	/** REGEX utiles **/
	public final static String regex_code_postal = "[0-9]{5}";
	public final static String regex_mail = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}";
	public final static String regex_telephone = "0[0-9](\\s|\\.)?([0-9]{2}(\\s|\\.)?){3}[0-9]{2}";
	
    /** Chemin vers la java.base de données **/
    public final static String baseDirPath = "./donnees";
    /** Chemin vers le dossier contenant les devis **/
    public final static String devisDirPath = baseDirPath + "/devis";
    /** Chemin vers le fichier de données sqlite **/
    public final static String sqliteFilePath = baseDirPath + "/couture.sqlite";

    
    
    /** String dans l'application **/
    public final static String aucun_devis = "Aucun devis n'est présent dans l'application";    
    public final static String aucun_client = "Aucun client n'a été enregistré";    
    
    
    
    /** String liées à la base de données **/
    /** Table en base DEVIS **/
    public final static String tableDevis = "DEVIS";
    public final static String colDevisId = "id_devis";
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
    public final static String colMensurationId = "id_mensuration";
    public final static String tableMensurationGenerale = "MENSURATION_GENERALE";
    public final static String colStature = "stature";
    public final static String colHauteurCorps = "hauteur_corps";
    public final static String tableMensurationHaut = "MENSURATION_HAUT";
    public final static String colTourCou = "tour_cou";
    public final static String colCarrure = "carrure";    
    public final static String colTourPoitrine = "tour_poitrine";
    public final static String colTourBuste = "tour_buste";
    public final static String colTourTaille = "tour_taille";
    public final static String colTourBras = "tour_bras";
    public final static String colTourPoignet = "tour_poignet";
    public final static String colEcartPointeSeins = "ecartement_pointe_seins";
    public final static String colLongueurEncolureSeins = "longueur_base_encolure_pointe_seins";
    public final static String colLongueurEpaule = "longueur_epaule";
    public final static String colLongueurBras = "longueur_bras";
    public final static String colHauteurPoitrine = "hauteur_poitrine";
    public final static String colHauteurTaille = "hauteur_taille";
    public final static String colHauteurTailleSein = "hauteur_taille_pointe_seins";
    public final static String tableMensurationBas = "MENSURATION_BAS";
    public final static String colTourHanches = "tour_hanches";
    public final static String colTourBassin = "tour_bassin";
    public final static String colTourCuisse = "tour_cuisse";
    public final static String colTourGenou = "tour_genou";
    public final static String colTourMollet = "tour_mollet";
    public final static String colTourCheville = "tour_cheville";
    public final static String colMontantDos = "montant_dos";
    public final static String colLongueurEnfourchure= "longueur_enfourchure";
    public final static String colHauteurTailleSol = "hauteur_taille_sol";
    public final static String colHauteurTailleGenou = "hauteur_taille_genou";
    public final static String colHauteurGenouCheville = "hauteur_genou_cheville";
    public final static String colHauteurEntrejambeCheville = "hauteur_entrejambre_cheville";
    public final static String colHauteurChevilleSol = "hauteur_cheville_sol";
    public final static String tableMensurationMain = "MENSURATION_MAIN";
    public final static String colTourPaumeOuvert = "tour_paume_ouvert";
    public final static String colTourPaumeFerme = "tour_paume_ferme";
    public final static String colLongueurPaume = "longueur_paume";
    public final static String colLongueurMajeur = "longueur_majeur";
}
