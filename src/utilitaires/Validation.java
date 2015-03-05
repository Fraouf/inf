/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaires;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import clients.Client;

/**
 *
 * @author k1fryouf
 */
public class Validation {

    public static boolean validerClient(Client unUser) {

        return validerNumero(unUser) && validerContrat(unUser) && validerMois(unUser) && validerSoin(unUser);
    }
    

    private static boolean validerNumero(Client unUser) {

        return estNombre(unUser.getClient()) && unUser.getClient().length() == 6;
    }

    private static boolean validerContrat(Client unUser) {

        final String CONTRATS = "ABCD";

        return CONTRATS.indexOf(unUser.getContrat()) != 0 && Character.isUpperCase(unUser.getContrat());
    }

    private static boolean validerMois(Client unUser) {

        boolean valideFormat = false;
        boolean valideMois = true;

        for (int i = 0; i < unUser.getListReclam().size(); i++) {

            valideFormat = valideDateFormat(unUser.getListReclam().get(i).getDate());

        }
        for (int i = 0; i < unUser.getListReclam().size(); i++) {

            if(!unUser.getListReclam().get(i).getDate().substring(5, 7).equals(unUser.getMois().substring(5, 7))){
                valideMois = false;
            }

        }

        return valideFormat && valideMois;
    }

    private static boolean validerSoin(Client unUser) {

        
        boolean soinValide = true;
        
        for(int i = 0; i < unUser.getListReclam().size(); i++){
            
            int leSoin = unUser.getListReclam().get(i).getSoin();
            
            if(!(leSoin == 0 || leSoin == 100 || leSoin == 200 || leSoin == 400 || leSoin == 500 || leSoin == 600 || leSoin == 700 || (leSoin >=300 && leSoin <=400))){
                
                soinValide = false;
            }
            
          
        }
        
        return soinValide;
    }

    private static boolean estNombre(String var) {

        try {
            Double.parseDouble(var);

        } catch (NumberFormatException nfe) {

            return false;
        }
        return true;
    }

    private static boolean valideDateFormat(String uneDate) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        sdf.setLenient(false);
        try {
            sdf.parse(uneDate);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
    public static String messageErreur() {

        return "{\n\"données invalides\"\n}";
    }

}
