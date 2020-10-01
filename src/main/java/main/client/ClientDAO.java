package main.client;

public class ClientDAO {
    private long id;
    private String civilite;
    private String prenom;
    private String nom;
    private String adresse;
    private String mail;
    private String tel;
    private long id_mesuration;
    
    public ClientDAO(String genre, String nom, String prenom, String adresse, 
    		String mail, String tel, long idMensuration) {
    	this.civilite = genre;
        this.prenom = nom;
        this.nom = prenom;
        this.adresse = adresse;
        this.mail = mail;
        this.tel = tel;
        this.id_mesuration = idMensuration;
    }

    public void setId(long id) {
    	this.id = id;
    }
    public long getId() {
        return this.id;
    }

    public String getCivilite() {
        return this.civilite;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getNom() {
        return this.nom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public String getMail() {
        return this.mail;
    }

    public String getTel() {
    	return this.tel;
    }
    
    public long getIdMensuration() {
    	return this.id_mesuration;
    }
}
