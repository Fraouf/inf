
import com.google.gson.stream.JsonReader;
import java.io.FileReader;
import clients.Calculate;
import gestionDeFichier.LoadJsonFile;
import gestionDeFichier.SaveJsonFile;
import clients.Client;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.

/**
 *
 * @author k1fryouf
 */
public class Main {

    public static void main(String[] args) {

        try {
            
            String clientFilesJson = args[0];

            //Lecture des fichiers source .json donn� par les arguments du main
            JsonReader file = new JsonReader(new FileReader(clientFilesJson));

            //r�cup�ration du fichier json de la classe JsonReader
            Client customer = LoadJsonFile.load(file);

            //on calcule si tout est valide
            if(customer.isValide()){
                Calculate.calculateTotalRefunds(customer);
            }

            //sauvegarde du fichier
            SaveJsonFile.save(customer, args[1]);

        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}
