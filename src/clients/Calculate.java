/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clients;

/**
 *
 * @author k1fryouf
 */
public class Calculate {

    private static final int MASSOTHERAPIE = 0;
    private static final int OSTHEOPATIE = 100;
    private static final int PSYCOLOGIE_INDIVIDUELLE = 200;
    private static final int SOINS_DENTAIRES_MIN = 300;
    private static final int SOINS_DENTAIRES_MAX = 399;
    private static final int NATUROPATHIE_ACUPONCTURE = 400;
    private static final int CHIROPRATIE = 500;
    private static final int PHYSIOTHERAPIE = 600;
    private static final int ORTHOPONIE_ERGOTHERAPIE = 700;

    public static void calculateTotalRefunds(Client client) {

        for (int i = 0; i < client.getListReclam().size(); i++) {

            double remboursement = -1;

            switch (client.getContrat()) {

                case 'A':

                    remboursement = calculerCaseA(client.getListReclam().get(i).getSoin(), client.getListReclam().get(i).getMontant());
                    break;

                case 'B':

                    remboursement = calculerCaseB(client.getListReclam().get(i).getSoin(), client.getListReclam().get(i).getMontant());
                    break;

                case 'C':

                    remboursement = calculerCaseC(client.getListReclam().get(i).getSoin(), client.getListReclam().get(i).getMontant());
                    break;

                case 'D':

                    remboursement = calculerCaseD(client.getListReclam().get(i).getSoin(), client.getListReclam().get(i).getMontant());

            }

            client.getListRemb().get(i).setMontant(remboursement);
        }
    }

    public static Double calculerCaseA(int unSoin, Double unMontant) {

        Double remboursement = -1.00;

        if (unSoin >= MASSOTHERAPIE && unSoin <= PSYCOLOGIE_INDIVIDUELLE 
                || unSoin == CHIROPRATIE) {

            remboursement = unMontant * 0.25;

        } else if (unSoin >= SOINS_DENTAIRES_MIN && unSoin <= NATUROPATHIE_ACUPONCTURE 
                || unSoin == ORTHOPONIE_ERGOTHERAPIE) {

            remboursement = unMontant * 0;

        } else if (unSoin == CHIROPRATIE) {

            remboursement = unMontant * 0.40;

        }
        return remboursement;
    }

    public static Double calculerCaseB(int unSoin, Double unMontant) {

        Double remboursement = -1.00;

        if (unSoin == MASSOTHERAPIE || unSoin == OSTHEOPATIE || 
            (unSoin >= SOINS_DENTAIRES_MIN && unSoin <= SOINS_DENTAIRES_MAX) 
            || unSoin == CHIROPRATIE) {

            remboursement = unMontant * 0.50;

            if (unSoin == MASSOTHERAPIE && unMontant > 40) {

                remboursement = 40.00;

            } else if ((unSoin == OSTHEOPATIE || unSoin == CHIROPRATIE) && unMontant > 50) {

                remboursement = 50.00;
            }

        } else if (unSoin == PSYCOLOGIE_INDIVIDUELLE || unSoin == CHIROPRATIE) {

            remboursement = unMontant;

            if (unSoin == PSYCOLOGIE_INDIVIDUELLE && unMontant > 70) {

                remboursement = 70.00;
            }

        } else if (unSoin == CHIROPRATIE) {

            remboursement = unMontant * 0.40;
        }

        return remboursement;
    }

    public static Double calculerCaseC(int unSoin, Double unMontant) {

        Double remboursement;

        remboursement = unMontant * 0.90;

        return remboursement;
    }

    public static Double calculerCaseD(int unSoin, Double unMontant) {

        Double remboursement;

        remboursement = unMontant;

        if (unSoin == MASSOTHERAPIE && unMontant > 85) {

            remboursement = 85.00;

        } else if ((unSoin == OSTHEOPATIE || unSoin == CHIROPRATIE) && unMontant > 75) {

            remboursement = 75.00;

        } else if ((unSoin == PSYCOLOGIE_INDIVIDUELLE || unSoin == PHYSIOTHERAPIE) && unMontant > 100) {

            remboursement = 100.00;

        } else if (unSoin == NATUROPATHIE_ACUPONCTURE && unMontant > 65) {

            remboursement = 65.00;

        } else if (unSoin == ORTHOPONIE_ERGOTHERAPIE && unMontant > 90) {

            remboursement = 90.00;
        }

        return remboursement;
    }
}
