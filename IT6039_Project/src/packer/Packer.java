package packer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bunta
 */
public class Packer {

    // Step 2 PACKING
    public static List<Box> packProducts(Customer c, Depot d, Manifest m, Integer cap) {

        List<Box> packedBoxes = new ArrayList<>(); // packed boxes
        Box b = null;

        while (!m.isEmpty()) { // repeat until all items are packed
            if (b == null) {

                //System.out.println("New Box"); // new box with new manifest
                b = new Box(c, d, cap);
            }

            // get heaviest item that will fit in remaining capacity
            Product prodToAdd = m.getHeaviestUnder(b.remainingCapacity());

            if (prodToAdd == null) {
                packedBoxes.add(b);      // if no more products pack box
                b = null;

            }
            else {
                b.addProduct(prodToAdd); // add product to box
                m.removeProduct(prodToAdd);  // remove product from manifest
            }
        }

        if (b != null) {
            packedBoxes.add(b);
        }
            //System.out.println("Packed:" + packedBoxes);
            return packedBoxes;

    }
}
