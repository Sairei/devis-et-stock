package base;

import common.Constantes;
import common.MethodesCommunes;

public class GeneralBaseController {
    public void start() {
        System.out.println("=== Start " + GeneralBaseController.class + " ===");

        initDirectories();
        
        SQLInitialisation b = new SQLInitialisation();
        b.initialisation();
    }

    /** Créé l'architecture des dossier pour la base de données **/
    public void initDirectories() {
        MethodesCommunes.testFileExistAndCreate(Constantes.baseDirPath, true);
        MethodesCommunes.testFileExistAndCreate(Constantes.devisDirPath, true);
    }
}
