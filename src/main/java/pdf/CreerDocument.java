package pdf;

import client.ClientDAO;
import devis.DevisDAO;
import pdf.client.PDFClient;

public class CreerDocument {
	public static void creerPdfDevis(DevisDAO devis) {
		
	}

	public static void creerPdfClient(ClientDAO client) {
		PDFClient pdfClient = new PDFClient(client);
		pdfClient.constructPdf();
	}
}
