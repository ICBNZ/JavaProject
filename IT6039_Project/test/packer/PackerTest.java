package packer;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import java.util.List;

/**
 *
 * @author Isla
 */
public class PackerTest {

    // Test Data
    Address depotAddress1 = new Address("111 Depot Rd", "Really", "Inn Town", "D444", new Coordinates(1102, 87));
    Depot testDepot1 = new Depot("Test Depot1", depotAddress1);

    Address customerAddress1 = new Address("321 Back St", "Campbell", "Holly Oaks", "C333", new Coordinates(112, 90));
    Address customerAddress2 = new Address("55 Some St", "Somewhere", "Elsewhere", "E555", new Coordinates(10, 100));

    Customer customer1 = new Customer("Shaun Davis", customerAddress1);
    Customer customer2 = new Customer("Craig Smith", customerAddress2);

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

        // Packing Manifest 1
        System.out.println("Testing Packed Boxes 1:");
        Manifest testManifest1;
        testManifest1 = new Manifest();
        testManifest1.addProduct(p2, 1);
        testManifest1.addProduct(p1, 1);

        List<Box> results1 = Packer.packProducts(customer1, testDepot1, testManifest1, 20);
        assertEquals(1, results1.size());

        assertEquals("\n"+"Shaun Davis\n" +
                        "321 Back St\n" +
                        "Campbell\n" +
                        "Holly Oaks\n" +
                        "C333\n" +
                        "Ladder x 1\n" +
                        "Hammer x 1\n" +
                        "HEAVY", results1.get(0).toString()
                );


        // Packing Manifest 2
        Manifest testManifest2;
        System.out.println("Testing Packed Boxes 2:");
        testManifest2 = new Manifest();
        testManifest2.addProduct(p1, 2);
        testManifest2.addProduct(p2, 3);
        testManifest2.addProduct(p3, 3);

        List<Box> results2 = Packer.packProducts(customer2, testDepot1, testManifest2, 20);
        assertEquals(3, results2.size());

        assertEquals("\n"+"Craig Smith\n" +
                        "55 Some St\n" +
                        "Somewhere\n" +
                        "Elsewhere\n" +
                        "E555\n" +
                        "Ladder x 1\n" +
                        "Hammer x 1\n" +
                        "Nails x 2\n" +
                        "HEAVY", results2.get(0).toString());

        assertEquals("\n"+"Craig Smith\n" +
                "55 Some St\n" +
                "Somewhere\n" +
                "Elsewhere\n" +
                "E555\n" +
                "Ladder x 1\n" +
                "Hammer x 1\n" +
                "Nails x 1\n" +
                "HEAVY", results2.get(1).toString());

        assertEquals("\n"+"Craig Smith\n" +
                "55 Some St\n" +
                "Somewhere\n" +
                "Elsewhere\n" +
                "E555\n" +
                "Ladder x 1", results2.get(2).toString());


        // Manifest 3
        Manifest testManifest3;
        System.out.println("Testing Manifest 3:");
        testManifest3 = new Manifest();
        testManifest3.addProduct(p5, 4); //5
        testManifest3.addProduct(p4, 5); //1
        testManifest3.addProduct(p6, 2); //2

        List<Box> results3 = Packer.packProducts(customer2, testDepot1, testManifest3, 15);
        assertEquals(3, results3.size());

        assertEquals("\n"+"Craig Smith\n" +
                "55 Some St\n" +
                "Somewhere\n" +
                "Elsewhere\n" +
                "E555\n" +
                "Saw x 3", results3.get(0).toString());

        assertEquals("\n"+"Craig Smith\n" +
                        "55 Some St\n" +
                        "Somewhere\n" +
                        "Elsewhere\n" +
                        "E555\n" +
                        "Saw x 2\n" +
                        "Weedkiller x 2\n" +
                        "Light Bulbs x 1\n" +
                        "FRAGILE", results3.get(1).toString());

        assertEquals("\n"+"Craig Smith\n" +
                "55 Some St\n" +
                "Somewhere\n" +
                "Elsewhere\n" +
                "E555\n" +
                "Light Bulbs x 3\n" +
                "FRAGILE", results3.get(2).toString());


    }
}