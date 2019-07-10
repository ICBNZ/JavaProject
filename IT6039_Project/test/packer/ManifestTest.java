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
    Box testBox1 = new Box(testCustomer1,testDepot1, 20);

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Box class...");
    }


    /**
     * Testing of addProduct method of Manifest Class.
     */
    @Test
    public void addProduct() {
        //Parameters: Product, quantity


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
