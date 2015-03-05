/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionDeFichier;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import clients.Client;
import utilitaires.Validation;

/**
 *
 * @author k1fryouf
 */
public class SaveJsonFile {

    private static final String chemin = "/Users/k1fryouf/NetBeansProjects/Refund/src/";

    public static void save(Client customer, String fileName) {

        Gson gson = new Gson();

        // convert java object to JSON format,
        // and returned as JSON formatted string
        String json = gson.toJson(customer);

        json = json.replace("{", "{\n");
        json = json.replace("}", "\n}");
        json = json.replace("[", "[\n");
        json = json.replace("]", "\n]\n");
        json = json.replace(",", ",\n");

        //write converted json data to a file named "file.json"
        System.out.println("Execution terminé");
        try (FileWriter writer = new FileWriter(chemin + fileName)) {
            
            if(customer.isValide()){
                writer.write(json);
            }else{
                writer.write(Validation.messageErreur());
            }
            

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
