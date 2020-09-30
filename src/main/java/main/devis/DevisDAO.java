package main.devis;

import main.client.ClientDAO;

public class DevisDAO {
    private String dateCreation;
    private String titre;
    private String description;
    private ClientDAO client;

    public String toItemList() {
        return titre;
    }
}
