package main.devis;

import java.sql.ResultSet;
import java.sql.SQLException;

import main.base.SQLSelect;
import main.client.ClientDAO;
import main.common.Constantes;

public class DevisDAO {
	private long id;
    private String dateCreation;
    private String titre;
    private String description;
    private ClientDAO clientDao;

    public DevisDAO(String date, String titre, String desc, ClientDAO client) {
    	this.dateCreation = date;
    	this.titre = titre;
    	this.description = desc;
    	this.clientDao = client;
    }
    
    public DevisDAO(String date, String titre, String desc, long idClient) {
    	this.dateCreation = date;
    	this.titre = titre;
    	this.description = desc;
    	
    	ResultSet res = SQLSelect.selectClientById(idClient);
    	try {
			if(res.next()) {
				this.clientDao = new ClientDAO(res.getLong(Constantes.colClientId), res.getString(Constantes.colClientGenre),
						res.getString(Constantes.colClientNom), res.getString(Constantes.colClientPrenom),
						res.getString(Constantes.colClientAdresse), res.getString(Constantes.colClientMail),
						res.getString(Constantes.colClientTelephone), res.getLong(Constantes.colClientIdMensuration));
			} else {
				this.clientDao = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
    
    public String getDateCreationSansHeure() {
    	return this.dateCreation.split(" à ")[0];
    }
    
    public String getTitre() {
    	return this.titre;
    }
    
    public String getDescription() {
    	return this.description;
    }
    
    public ClientDAO getClient() {
    	return this.clientDao;
    }

    
    @Override
    public String toString() {
       	String res = getDateCreationSansHeure() + " - ";
    	if (null != clientDao) {
    		res += "Devis pour " + clientDao.toString();
    	} else {
    		res += getTitre();
    	}
    	
        return res;
    }
}
