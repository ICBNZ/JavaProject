package packer;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Isla
 */
public class PackerTest {

    // TEST DATA
    // Depot
    Address depotAddress1 = new Address("111 Depot Rd", "Really", "Inn Town", "D444", new Coordinates(1102, 87));
    Depot testDepot1 = new Depot("Test Depot1", depotAddress1);

    // Customer Address
    Address customerAddress1 = new Address("321 Back St", "Christly", "Holly Oaks", "C333", new Coordinates(112, 90));
    //Address customerAddress2 = new Address("55 Some St", "Somewhere", "Elsewhere", "E555", new Coordinates(10, 100));
    // Customer
    Customer customer1 = new Customer("Customer1", customerAddress1);
    //Customer customer2 = new Customer("Customer2", customerAddress2);

    // Products
    Product p1 = new Product("Hammer", 3, false, false);
    Product p2 = new Product("Ladder", 15, false, false);
    Product p3 = new Product("Nails", 1, false, false);
    Product p4 = new Product("Saw", 5, false, false);
    Product p5 = new Product("Light Bulbs", 1, false, true);
    Product p6 = new Product("Weedkiller", 2, true, false);


    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Packer class..."); }


    /**
     * Test of packedBoxes method, of class Packer.
     */
    @Test
    public void packedBoxes() {

        System.out.println("Packed Boxes:");

        // Manifest 1
        System.out.println("Testing Manifest 1:");
        Manifest testManifest1;
        testManifest1 = new Manifest();
        testManifest1.addProduct(p2, 1);
        testManifest1.addProduct(p1, 1);

        List<Box> results1 = Packer.packProducts(customer1, testDepot1, testManifest1, 20);
        assertThat(results1.get(0).toString(), containsString(
                "Capacity:20\n" +
                        "Customer1\n" +
                        "321 Back St\n" +
                        "Christly\n" +
                        "Holly Oaks\n" +
                        "C333\n" +
                        "Hammer x 1\n" +
                        "Ladder x 1\n" +
                        "HEAVY"));

        // Manifest 2
        Manifest testManifest2;
        System.out.println("Testing Manifest 2:");
        testManifest2 = new Manifest();
        testManifest2.addProduct(p1, 2);
        testManifest2.addProduct(p2, 3);
        testManifest2.addProduct(p3, 3);

        List<Box> results2 = Packer.packProducts(customer1, testDepot1, testManifest2, 20);
        assertThat(results2.get(0).toString(), containsString(
                "Capacity:20\n" +
                        "Customer1\n" +
                        "321 Back St\n" +
                        "Christly\n" +
                        "Holly Oaks\n" +
                        "C333\n" +
                        "Nails x 2\n" +
                        "Hammer x 1\n" +
                        "Ladder x 1\n" +
                        "HEAVY"));

        assertThat(results2.get(1).toString(), containsString(
                "Capacity:20\n" +
                        "Customer1\n" +
                        "321 Back St\n" +
                        "Christly\n" +
                        "Holly Oaks\n" +
                        "C333\n" +
                        "Nails x 1\n" +
                        "Hammer x 1\n" +
                        "Ladder x 1\n" +
                        "HEAVY"));

        assertThat(results2.get(2).toString(), containsString(
                "Capacity:20\n" +
                        "Customer1\n" +
                        "321 Back St\n" +
                        "Christly\n" +
                        "Holly Oaks\n" +
                        "C333\n" +
                        "Ladder x 1"));


    }
}
