package packer;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Isla
 */
public class BoxTest {

    // Test data
    Coordinates testCoordinates1 = new Coordinates(3,4);
    Address testAddress1 = new Address("1 First St", "", "Citadel City", "A111", testCoordinates1);
    Customer testC1 = new Customer("Sally Perry", (testAddress1));
    Depot testD1 = new Depot("Test Depot", testAddress1);

    Product p1 = new Product("Saw", 4, true, false);
    Product p2 = new Product("Ladder", 10, true, false);
    Product p3 = new Product("Product1", 22, false, false);
    Product p4 = new Product("Product2", 10, true, false);
    Product p5 = new Product("LightBulbs", 2, false, true);

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Box class...");
    }


    /**
     * Testing of canFit method of Box class.
     */
    @Test
    public void testCanFit() {

        System.out.println("canFit: ");

        Box b1 = new Box(testC1, testD1, 20);
        b1.addProduct(p1);
        assertTrue(b1.canFit(p1));
        assertTrue(b1.canFit(p2));
        assertFalse(b1.canFit(p3));
        assertTrue(b1.canFit(p4));

    }


    /**
     * Testing of getWeight method of box class
     */
    @Test
    public void testGetWeight() {

        System.out.println("Weight: ");

        Box b1 = new Box(testC1, testD1, 20);

        b1.addProduct(p1);
        assertEquals(4, b1.getWeight(), 0);

        b1.addProduct(p2);
        assertEquals(14, b1.getWeight(), 0);

        b1.addProduct(p5);
        assertEquals(16, b1.getWeight(), 0);

    }


    /**
     * Testing of remainingCapacity method of Box class.
     */
    @Test
    public void testRemainingCapacity() {

        System.out.println("remainingCapacity: ");

        Box b1 = new Box(testC1, testD1, 20);

        b1.addProduct(p1);
        b1.addProduct(p2);
        assertEquals(6, b1.remainingCapacity(), 0);

        b1.addProduct(p5);
        assertEquals(4, b1.remainingCapacity(), 0);

    }
}
