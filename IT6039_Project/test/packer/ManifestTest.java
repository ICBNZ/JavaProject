package packer;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Isla
 */
public class ManifestTest {

    // Test data
    Coordinates testCoordinates1 = new Coordinates(3,4);
    Address testAddress1 = new Address("1 First St", "", "Citadel City", "A111", testCoordinates1);
    Customer testCustomer1 = new Customer("Sally Perry", (testAddress1));
    Depot testDepot1 = new Depot("Test Depot", testAddress1);

    // Products
    Product p1 = new Product("Hammer", 3, false, false);
    Product p2 = new Product("Ladder", 15, false, false);
    Product p3 = new Product("Nails", 1, false, false);
    Product p4 = new Product("Saw", 5, false, false);
    Product p5 = new Product("Light Bulbs", 1, false, true);
    Product p6 = new Product("Weedkiller", 2, true, false);

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Box class...");
    }


    /**
     * Testing of addProduct method of Manifest Class.
     */
    @Test
    public void addProduct() {
        Manifest testManifest1;
        testManifest1 = new Manifest();
        testManifest1.addProduct(p2, 4);
        testManifest1.addProduct(p1, 10);
        assertEquals("Ladder x 4\n" + "Hammer x 10", testManifest1.toString());

        Manifest testManifest2;
        testManifest2 = new Manifest();
        testManifest2.addProduct(p1, 1);
        testManifest2.addProduct(p4, 2);
        testManifest2.addProduct(p5, 4);
        assertEquals("Hammer x 1\n" +
                "Saw x 2\n" +
                "Light Bulbs x 4", testManifest2.toString());




    }

    /**
     * Testing of removeProduct method of Manifest Class.
     */
    @Test
    public void removeProduct() {
        //Parameters:m Product

    }


    /**
     * Testing of getTotalWeight method of Manifest  class.
     */
    @Test
    public void getTotalWeight() {

    }


    /**

    @Test
    public void getHeaviestUnder() {

    }

    // Get Heaviest Under
    @Test
    public void hasFragileItems() {

    }

    // Get Heaviest Under
    @Test
    public void hasHazardousItems() {

    }
    **/


}
