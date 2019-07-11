package packer;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


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

    private Manifest testManifest1;
    private Manifest testManifest2;
    private Manifest testManifest3;

    @Before
    public void setUpClass() {System.out.println("Testing Box class...");

        testManifest1 = new Manifest();
        testManifest1.addProduct(p2, 4);
        testManifest1.addProduct(p5, 2);

        testManifest2 = new Manifest();
        testManifest2.addProduct(p6, 2);
        testManifest2.addProduct(p1, 1);
        testManifest2.addProduct(p4, 10);

        testManifest3 = new Manifest();
        testManifest3.addProduct(p4, 1);
        testManifest3.addProduct(p2, 10);
        testManifest3.addProduct(p3, 2);
        testManifest3.addProduct(p6, 20);
    }


    /**
     * Testing of addProduct method of Manifest Class.
     */
    @Test
    public void addProduct() {

        assertEquals("Ladder x 4\n" +
                "Light Bulbs x 2", testManifest1.toString());
        assertEquals("Weedkiller x 2\n" + "Hammer x 1\n" +
                        "Saw x 10", testManifest2.toString());
        assertEquals("Saw x 1\n" + "Ladder x 10\n" + "Nails x 2\n" +
                        "Weedkiller x 20", testManifest3.toString());
    }


    /**
     * Testing of removeProduct method of Manifest Class.
     */
    @Test
    public void removeProduct() {

        testManifest1.removeProduct(p1);
        assertEquals("Ladder x 4\n" + "Light Bulbs x 2",
                testManifest1.toString());
        testManifest1.removeProduct(p2);
        assertEquals("Ladder x 3\n" + "Light Bulbs x 2",
                testManifest1.toString());


        testManifest2.removeProduct(p4);
        assertEquals("Weedkiller x 2\n" + "Hammer x 1\n" +
                "Saw x 9", testManifest2.toString());

        testManifest2.removeProduct(p5);
        assertEquals("Weedkiller x 2\n" + "Hammer x 1\n" +
                "Saw x 9", testManifest2.toString());
    }


    /**
     * Testing of getTotalWeight method of Manifest  class.
     */
    @Test
    public void getTotalWeight() {

        assertEquals(62, testManifest1.getTotalWeight(), 0);
        assertEquals(57, testManifest2.getTotalWeight(), 0);
        assertEquals(197, testManifest3.getTotalWeight(), 0);

    }



    @Test
    public void getHeaviestUnder() {

    }


    @Test
    public void hasFragileItems() {

    }


    @Test
    public void hasHazardousItems() {

    }



}
