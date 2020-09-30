package main.common;

import java.io.File;
import java.io.IOException;

public class MethodesCommunes {
    /** Test l'existance d'un fichier (ou d'un dossier) et le créé s'il n'existe pas
     * @param pathFile est le fichier à tester
     * @param isDirectorie permet de savoir si le fichier est un dossier ou non
     *
     * @return isCreate, booléen pour savoir si le fichier viens d'étre créer ou non
     * **/
    public static boolean testFileExistAndCreate(String pathFile, boolean isDirectorie) {
        final File file = new File(pathFile);
        try {
            boolean isCreate = false;
            if (!file.exists()) {
                System.out.println(file.getAbsolutePath() + " non existant: création");
                isCreate = true;
                if (isDirectorie) {
                    file.mkdir();
                    return isCreate;
                }
                else {
                    file.createNewFile();
                    return isCreate;
                }
            }

            return isCreate;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
