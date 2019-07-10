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
    Coordinates testCoordinates2 = new Coordinates(30,100);

    Address testAddress1 = new Address("1 First St", "", "Citadel City", "A111", testCoordinates1);
    Address testAddress2 = new Address("10 Smith St", "", "Campbell City", "A242", testCoordinates2);

    Customer testC1 = new Customer("Sally Perry", testAddress1);
    Customer testC2 = new Customer("Sarah Kate", testAddress2);

    Address depotAddress = new Address("2 Depot St", "Kelburn", "Tall City", "A121", testCoordinates1);
    Depot testD1 = new Depot("Test Depot", depotAddress);

    Product p1 = new Product("Saw", 4, true, false);
    Product p2 = new Product("Ladder", 10, true, false);
    Product p3 = new Product("Product1", 22, false, false);
    Product p4 = new Product("Toolbox", 6, true, false);
    Product p5 = new Product("LightBulbs", 2, false, true);


    Box b1 = new Box(testC1, testD1, 20);
    Box b2 = new Box(testC2, testD1, 30);

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Box class...");

    }


    /**
     * Testing of canFit method of Box class.
     */
    @Test
    public void testCanFit() {

        System.out.println("Can Fit");

        b1.addProduct(p1);
        assertTrue(b1.canFit(p1));
        assertFalse(b1.canFit(p3));
        assertTrue(b1.canFit(p4));

        b2.addProduct(p1);
        assertTrue(b1.canFit(p1));
        assertFalse(b1.canFit(p3));
        assertTrue(b1.canFit(p4));

    }

    /**
     * Testing of addProduct method of Box class.
     */
    @Test
    public void addProduct() {

        System.out.println("Add Product");

        b1.addProduct(p1);
        assertTrue(b1.getLabel().contains(p1.getName()));
        b1.addProduct(p2);
        assertTrue(b1.getLabel().contains(p2.getName()));
        b1.addProduct(p3);
        assertFalse(b1.getLabel().contains(p3.getName()));

        b2.addProduct(p2);
        assertTrue(b2.getLabel().contains(p2.getName()));
        b2.addProduct(p4);
        assertTrue(b2.getLabel().contains(p2.getName()));
        b2.addProduct(p1);
        assertTrue(b2.getLabel().contains(p2.getName()));

    }


    /**
     * Testing of getWeight method of box class
     */
    @Test
    public void testGetWeight() {

        System.out.println("Get Weight");

        b1.addProduct(p1);
        assertEquals(4, b1.getWeight(), 0);
        b1.addProduct(p2);
        assertEquals(14, b1.getWeight(), 0);
        b1.addProduct(p5);
        assertEquals(16, b1.getWeight(), 0);

        b2.addProduct(p4);
        assertEquals(6, b2.getWeight(), 0);
        b2.addProduct(p2);
        assertEquals(16, b2.getWeight(), 0);
        b2.addProduct(p1);
        assertEquals(20, b2.getWeight(), 0);

    }


    /**
     * Testing of remainingCapacity method of Box class.
     */
    @Test
    public void testRemainingCapacity() {

        System.out.println("Remaining Capacity");

        b1.addProduct(p1);
        b1.addProduct(p2);
        assertEquals(6, b1.remainingCapacity(), 0);
        b1.addProduct(p5);
        assertEquals(4, b1.remainingCapacity(), 0);

        b2.addProduct(p2);
        b2.addProduct(p4);
        assertEquals(14, b2.remainingCapacity(), 0);
        b2.addProduct(p1);
        assertEquals(10, b2.remainingCapacity(), 0);

    }

}

