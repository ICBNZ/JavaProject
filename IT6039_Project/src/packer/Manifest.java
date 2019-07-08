package packer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author I.M.Bad
 */
public class Manifest {

    // This tracks the quantity of each product in the manifest
    private Map<Product, Integer> quantities;

    // This keeps a list of all products ordered by weight
    private Set<Product> byWeight;

    public Manifest() {
        quantities = new HashMap<>();
        byWeight = new TreeSet<>(new ProductWeightComparator());
    }

    // Step 1 MANIFEST - Add products to manifest initial list
    // then use method for packing box with new manifest
    public void addProduct(Product p, int quantity) {

        if (quantities.containsKey(p)) {
            quantities.put(p,quantities.get(p)+quantity);
            //print to check list
            //System.out.println("\n product added, quantities:" + quantities.toString());


        } else {

            quantities.put(p, quantity);

            //print to check list
            //System.out.println("\n product added, quantities:" + quantities.toString());

            if (!byWeight.add(p)) {
                System.out.println("Couldn't add to Set");
            }
        }
    }


    // REMOVE product after packed (quantity is 1)
    public void removeProduct(Product p) {
        if (quantities.containsKey(p) && quantities.get(p) > 0) {
            quantities.put(p,quantities.get(p)-1); // update product quantity -1

            // print to check items removed
            //System.out.println("\nProduct removed weights" + byWeight.toString());
            //System.out.println("\nRemoved 1 from quantity: " + p + quantities.toString());
         }

        if (quantities.get(p) == null) {  // if quantities is null
            quantities.remove(p);  // remove product

            // print to check product removed
            //System.out.println("\nRemoved product: " + p + quantities.toString());

        }
        if(quantities.containsKey(p) && quantities.get(p) == 0){
            byWeight.remove(p);

            // print to check weights
            //System.out.println("Weight one removed:"+ p + byWeight.toString());
        }
    }

    // Get Weight
    public double getTotalWeight() {
        double weight = 0;
        for (Product p : quantities.keySet()) {
            weight += (quantities.get(p) * p.getWeight());

        }
        // print to check total weight
        //System.out.println("total box weight:" + weight);
        return weight;
    }

    public Product getHeaviestUnder(double weight) {
        for (Product p : byWeight) {
            if (p.getWeight() <= weight) {
                    //System.out.println("heaviest under(w/p):" + weight + p);
                return p;
            }
        }
        return null;
    }


    public boolean isEmpty() {
        return byWeight.isEmpty();
    }

    // Print Manifest
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Product p : quantities.keySet()) {
            result.append(p.getName());
            result.append(" x ");
            result.append(quantities.get(p));
            result.append("\n");
        }
        return result.substring(0, result.length()-1);
    }

    public boolean hasFragileItems() {
        for (Product p : quantities.keySet()) {
            if (p.isFragile()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasHazardousItems() {
        for (Product p : quantities.keySet()) {
            if (p.isHazardous()) {
                return true;
            }
        }
        return false;
    }
}