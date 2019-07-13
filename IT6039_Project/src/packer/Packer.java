package packer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bunta
 */
public class Packer {

    /**
     * Packer: Packs products to boxes within box capacity
     * @param c - Customer
     * @param d - Depot
     * @param m - Manifest
     * @param cap - Box Capacity
     * @return list of packed boxes
     */
    public static List<Box> packProducts(Customer c, Depot d, Manifest m, Integer cap) {

        List<Box> packedBoxes = new ArrayList<>(); // packed boxes
        Box b = null;

        while (!m.isEmpty()) { // repeat until all items are packed
            if (b == null) {
                b = new Box(c, d, cap);
            }

            // Get heaviest product that will fit in remaining capacity
            Product prodToAdd = m.getHeaviestUnder(b.remainingCapacity());

            if (prodToAdd == null) {
                packedBoxes.add(b);          // If no more products fit pack box
                b = null;
            }

            else {
                b.addProduct(prodToAdd);     // Add product to box
                m.removeProduct(prodToAdd);  // Remove product from manifest
            }
        }

        if (b != null) {
            packedBoxes.add(b);              // Add last packed box to list
        }
            return packedBoxes;              // Return list of packed boxes.
    }
}
