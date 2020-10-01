package main.devis;

public class DevisDAO {
	private long id;
    private String dateCreation;
    private String titre;
    private String description;
    private long id_client;

    public DevisDAO(String date, String titre, String desc, long idClient) {
    	this.dateCreation = date;
    	this.titre = titre;
    	this.description = desc;
    	this.id_client = idClient;
    }
    
    public void setId(long id) {
    	this.id = id;
    }
    public long getId() {
   		return this.id;
   	}
   	
    public String getDateCreation() {
    	return this.dateCreation;
    }
    
    public String getTitre() {
    	return this.titre;
    }
    
    public String getDescription() {
    	return this.description;
    }
    
    public long getIdClient() {
    	return this.id_client;
    }
    
    
    public String toItemList() {
        return titre;
    }
}
