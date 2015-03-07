import clients.Calculate;
import gestionDeFichier.LoadJsonFile;
import gestionDeFichier.SaveJsonFile;
import clients.Client;
import java.io.IOException;
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
            
            String jsonTexte = LoadJsonFile.loadFileIntoString( args[0], "utf-8");
            
            
            Client customer = LoadJsonFile.ParseJsonFile(jsonTexte);

            //on calcule si tout est valide
            if(customer.isValide()){
                Calculate.calculateTotalRefunds(customer);
            }

            //sauvegarde du fichier
            SaveJsonFile.save(customer, args[1]);

        } catch (IOException | IllegalArgumentException e) {
        }

    }
}
