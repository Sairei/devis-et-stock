package main.client;

public class ClientDAO {
    private long id;
    private String civilite;
    private String prenom;
    private String nom;
    private String adresse;
    private String tel;
    private String mail;

    public long getId() {
        return id;
    }

    public String getCivilite() {
        return civilite;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTel() {
        return tel;
    }

    public String getMail() {
        return mail;
    }
}
