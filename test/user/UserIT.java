/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import clients.Remboursement;
import clients.Reclamation;
import clients.Client;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author k1fryouf
 */
public class UserIT {
    
    public UserIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getClient method, of class Client.
     */
    @Test
    public void testGetClient() {
        System.out.println("getClient");
        Client instance = new Client();
        String expResult = "";
        String result = instance.getClient();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setClient method, of class Client.
     */
    @Test
    public void testSetClient() {
        System.out.println("setClient");
        String client = "";
        Client instance = new Client();
        instance.setClient(client);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContrat method, of class Client.
     */
    @Test
    public void testGetContrat() {
        System.out.println("getContrat");
        Client instance = new Client();
        String expResult = "";
        char result = instance.getContrat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setContrat method, of class Client.
     */
    @Test
    public void testSetContrat() {
        System.out.println("setContrat");
        char contrat = 'z';
        Client instance = new Client();
        instance.setContrat(contrat);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMois method, of class Client.
     */
    @Test
    public void testGetMois() {
        System.out.println("getMois");
        Client instance = new Client();
        String expResult = "";
        String result = instance.getMois();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMois method, of class Client.
     */
    @Test
    public void testSetMois() {
        System.out.println("setMois");
        String mois = "";
        Client instance = new Client();
        instance.setMois(mois);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListReclam method, of class Client.
     */
    @Test
    public void testGetListReclam() {
        System.out.println("getListReclam");
        Client instance = new Client();
        List<Reclamation> expResult = null;
        List<Reclamation> result = instance.getListReclam();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListReclam method, of class Client.
     */
    @Test
    public void testSetListReclam() {
        System.out.println("setListReclam");
        List<Reclamation> reclamations = null;
        Client instance = new Client();
        instance.setListReclam(reclamations);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListRemb method, of class Client.
     */
    @Test
    public void testGetListRemb() {
        System.out.println("getListRemb");
        Client instance = new Client();
        List<Remboursement> expResult = null;
        List<Remboursement> result = instance.getListRemb();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListRemb method, of class Client.
     */
    @Test
    public void testSetListRemb() {
        System.out.println("setListRemb");
        List<Remboursement> remboursements = null;
        Client instance = new Client();
        instance.setListRemb(remboursements);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
