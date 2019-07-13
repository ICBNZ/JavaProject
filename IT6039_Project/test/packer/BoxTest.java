package packer;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Isla
 */
public class BoxTest {

    // Test data
    Coordinates testCoordinates1 = new Coordinates(3,4);
    Coordinates testCoordinates2 = new Coordinates(30,100);

    Address testAddress1 = new Address("1 First St", "Lyall", "Citadel City", "A111", testCoordinates1);
    Address testAddress2 = new Address("10 Smith St", "Karori", "Smith City", "A242", testCoordinates2);

    Customer testC1 = new Customer("Sally Perry", testAddress1);
    Customer testC2 = new Customer("Sarah Kate", testAddress2);

    Address depotAddress = new Address("2 Depot St", "Kelburn", "Tall City", "A121", testCoordinates1);
    Depot testD1 = new Depot("Test Depot", depotAddress);

    Product p1 = new Product("Saw", 4, true, false);
    Product p2 = new Product("Ladder", 10, true, false);
    Product p3 = new Product("Level", 5, false, false);
    Product p4 = new Product("Tape Measure", 1, true, false);
    Product p5 = new Product("Hammer", 16, true, false);
    Product p6 = new Product("LightBulbs", 30, false, true);

    private Box testBox1;
    private Box testBox2;
    private Box testBox3;
    private Box testBox4;

    @Before
    public void setUpClass() { System.out.println("Testing Box class...");

        testBox1 = new Box(testC1, testD1, 20);
        testBox1.addProduct(p1);
        testBox1.addProduct(p2);

        testBox2 = new Box(testC2, testD1, 25);
        testBox2.addProduct(p2);
        testBox2.addProduct(p4);

        testBox3 = new Box(testC2, testD1, 20);
        testBox3.addProduct(p1);

        testBox4 = new Box(testC2, testD1, 30);

    }


    /**
     * Testing of addProduct method of Box class.
     */
    @Test
    public void addProduct() {

        System.out.println("Add Product");

        assertTrue(testBox1.getLabel().contains(p1.getName()));
        assertTrue(testBox1.getLabel().contains(p2.getName()));
        assertFalse(testBox1.getLabel().contains(p3.getName()));

        assertTrue(testBox2.getLabel().contains(p2.getName()));
        assertTrue(testBox2.getLabel().contains(p4.getName()));
        assertFalse(testBox2.getLabel().contains(p1.getName()));

        assertTrue(testBox3.getLabel().contains(p1.getName()));
        assertFalse(testBox3.getLabel().contains(p4.getName()));
        assertFalse(testBox3.getLabel().contains(p2.getName()));

    }


    /**
     * Testing of canFit method of Box class.
     */
    @Test
    public void testCanFit() {

        System.out.println("Can Fit");

        assertTrue(testBox1.canFit(p1));
        assertTrue(testBox1.canFit(p4));

        assertTrue(testBox2.canFit(p3));
        assertTrue(testBox2.canFit(p1));

        assertTrue(testBox3.canFit(p2));
        assertTrue(testBox3.canFit(p5));

        assertTrue(testBox4.canFit(p3));
        assertTrue(testBox4.canFit(p6));

    }

    /**
     * Testing of remainingCapacity method of Box class.
     */
    @Test
    public void testRemainingCapacity() {

        System.out.println("Remaining Capacity");

        assertEquals(6, testBox1.remainingCapacity(), 0);
        testBox1.addProduct(p1);
        assertEquals(2, testBox1.remainingCapacity(), 0);

        assertEquals(14, testBox2.remainingCapacity(), 0);
        testBox2.addProduct(p4);
        assertEquals(13, testBox2.remainingCapacity(), 0);

        assertEquals(16, testBox3.remainingCapacity(), 0);
        testBox3.addProduct(p2);
        assertEquals(6, testBox3.remainingCapacity(), 0);

        assertEquals(30, testBox4.remainingCapacity(), 0);
        testBox4.addProduct(p1);
        assertEquals(26, testBox4.remainingCapacity(), 0);

    }


    /**
     * Testing of getWeight method of box class
     */
    @Test
    public void testGetWeight() {

        System.out.println("Get Weight");

        assertEquals(14, testBox1.getWeight(), 0);
        testBox1.addProduct(p1);
        assertEquals(18, testBox1.getWeight(), 0);

        assertEquals(11, testBox2.getWeight(), 0);
        testBox2.addProduct(p3);
        assertEquals(16, testBox2.getWeight(), 0);

        assertEquals(4, testBox3.getWeight(), 0);
        testBox3.addProduct(p4);
        assertEquals(5, testBox3.getWeight(), 0);

        assertEquals(0, testBox4.getWeight(), 0);
        testBox4.addProduct(p2);
        assertEquals(10, testBox4.getWeight(), 0);
    }

}

