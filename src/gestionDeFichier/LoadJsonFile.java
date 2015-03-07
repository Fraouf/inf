/*
 * Cette classe contient la méthode qui charge les fichiers Json et elle enregistre 
 * les valeurs obtenues dans des variables.
 */
package gestionDeFichier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import clients.Reclamation;
import clients.Remboursement;
import clients.Client;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author k1fryouf
 */
public class LoadJsonFile {

    public static List<Remboursement> listRemb = new ArrayList<>();

    // Cette méthode  prend en paramétres un Objet de type JsonReader et retourne un
    // Objet Client.
    // @ JsonReader
    public static Client ParseJsonFile(String jsonTexte) throws IOException, IllegalArgumentException {

        JSONObject clientObj = JSONObject.fromObject(jsonTexte);

        String noClient = clientObj.getString("client");
        char contrat = clientObj.getString("contrat").charAt(0);
        String mois = clientObj.getString("mois");
        List<Reclamation> listReclam = readArray(clientObj);

        return new Client(noClient, contrat, mois, listReclam, listRemb);
    }

    public static List<Reclamation> readArray(JSONObject refundObj) throws IOException {

        List<Reclamation> listReclam = new ArrayList<>();
        JSONArray reclamationsJson = refundObj.getJSONArray("reclamations");

        for (int j = 0; j < reclamationsJson.size(); j++) {

            JSONObject uneReclamation = reclamationsJson.getJSONObject(j);
            int soin = uneReclamation.getInt("soin");
            String date = uneReclamation.getString("date");
            String montant = uneReclamation.getString("montant");

            listReclam.add(new Reclamation(soin, date, montant));
            // pour chaque réclamation on crée un remboursement ayant les mêmes attribus sauf le montant 
            listRemb.add(new Remboursement(soin, date, "-1"));
        }
        return listReclam;

    }

    public static String loadFileIntoString(String filePath, String fileEncoding) throws FileNotFoundException, IOException {
        return IOUtils.toString(new FileInputStream(filePath), fileEncoding);
    }

}
