package packer;

import java.util.*;

/**
 *
 * @author I.M.Bad
 */
public class Manifest {

    // This tracks the quantity of each product in the manifest
    private LinkedHashMap<Product, Integer> quantities;

    // This keeps a list of all products ordered by weight
    private Set<Product> byWeight;


    /**
     * Manifest containing:
     * HashMap of product quantities
     * TreeSet of Products by weight, ordered with ProductWeightComparator
     */
    public Manifest() {
        quantities = new LinkedHashMap<>();
        byWeight = new TreeSet<>(new ProductWeightComparator());
    }


    /**
     * Add Product: Adds products to initial manifest
     * Then called by Box class, adds products to each box with new manifest instance
     * @param p Product to be added
     * @param quantity Quantity of the product
     */
    public void addProduct(Product p, int quantity) {
        if (quantities.containsKey(p)) {
            quantities.put(p, quantities.get(p)+ quantity);

        } else {
            quantities.put(p, quantity);

            if (!byWeight.add(p) && !byWeight.contains(p)) {
                System.out.println("Couldn't add to Set");
            }
        }
    }


    /**
     * Remove Product: Reduces quantity of product by 1 once packed
     * Removes product from main manifest list once quantity of product is 0
     * @param p Product that has been packed
     */
    public void removeProduct(Product p) {
        if (quantities.containsKey(p) && quantities.get(p) > 0) {
            quantities.put(p,quantities.get(p)-1); // update product quantity -1

         }

        if (quantities.get(p) == null) {  // if quantities is null
            quantities.remove(p);         // remove product

        }
        if(quantities.containsKey(p) && quantities.get(p) == 0){
            byWeight.remove(p);

        }
    }

    /**
     * Get Total Weight: Returns the sum of weights of all products x quantities
     * @return total weight
     */
    public double getTotalWeight() {
        double weight = 0;
        for (Product p : quantities.keySet()) {
            weight += (quantities.get(p) * p.getWeight());

        }

        return weight;
    }

    /**
     * Get Heaviest Under: Returns heaviest item left in list to be packed
     * @param weight - remaining capacity of box
     * @return p: product that will fit, otherwise null
     */
    public Product getHeaviestUnder(double weight) {
        for (Product p : byWeight) {
            if (p.getWeight() <= weight) {
                return p;
            }
        }
        return null;
    }


    /**
     * Returns true if manifest is empty and all items packed
     * @return true or false
     */
    public boolean isEmpty() {
        return byWeight.isEmpty();
    }


    /**
     * Result String: Returns a string list of products and quantities
     * @return results
     */
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


    /**
     * Fragile Items: Returns true if the box has fragile products, otherwise false
     * @return true or false
     */
    public boolean hasFragileItems() {
        for (Product p : quantities.keySet()) {
            if (p.isFragile()) {
                return true;
            }
        }
        return false;
    }


    /**
     * Hazardous Items: Returns true if the box has hazardous items, otherwise false
     * @return true or false
     */
    public boolean hasHazardousItems() {
        for (Product p : quantities.keySet()) {
            if (p.isHazardous()) {
                return true;
            }
        }
        return false;
    }
}