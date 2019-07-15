package packer;

/**
 *
 * @author I.M.Bad
 */
public class Box {

    private Manifest contents;
    private Customer customer;
    private Depot depot;
    private int capacity;


    /**
     * Box which is packed with products from the manifest
     * @param customer the Customer whose manifest is being packed
     * @param depot the depot that is packing the boxes from the manifest
     * @param capacity the capacity of the box
     */
    public Box(Customer customer, Depot depot, Integer capacity) {
        this.customer = customer;
        this.depot = depot;
        this.capacity = capacity;
        contents = new Manifest();
    }


    /**
     * Get Label: returns string of the box packing label
     * @return string including closest of Customer addresses to the depot,
     * the products packed in the box, label if the box contains fragile or hazardous
     * products and heavy label if over 15kg.
     */
    public String getLabel() {
        StringBuilder label = new StringBuilder();

        // print to test box capacity
        //label.append("Capacity:");
        //label.append(capacity);
        label.append("\n");
        label.append(customer);
        label.append("\n");
        label.append(customer.getClosestAddressTo(depot));
        label.append("\n");
        label.append(contents.toString());
        if (this.isFragile()) {
            label.append("\nFRAGILE");   // Fragile
        }
        else if (this.isHazardous()) {
            label.append("\nHAZARDOUS"); // Hazardous
        }
        if (this.getWeight() > 15) {
            label.append("\nHEAVY");     // Heavy
        }
        return label.toString();
    }


    /**
     * To String: Returns box label
     * @return the label
     */
    public String toString() {
        return getLabel();
    }


    /**
     * Get Weight: Calls manifest method to get total weight of products in box
     * @return the box total weight of contents of the box
     */
    public double getWeight() {
        return contents.getTotalWeight();
    }


    /**
     * Add Product: Checks product weight with canFit method, then if under capacity
     * calls the manifest add product method with quantity of 1 which is added to the
     * box
     * @param product the product being packed
     */
    public void addProduct(Product product) {
        if (canFit(product)) {
            contents.addProduct(product, 1);
        }
    }


    /**
     * canFit: Checks if the product weight is within the capacity
     * @param p product being packed
     * @return true or false
     */
    public boolean canFit(Product p) {
        return p.getWeight() <= capacity;
    }


    /**
     * Remaining Capacity: Calculates remaining capacity in box
     * by calling the getWeight method to return total weight of packed products
     * then subtracting the result from the box capacity.
     * @return Remaining weight to be filled under box capacity.
     */
    public double remainingCapacity() {
        return capacity - this.getWeight();
    }


    /**
     * Fragile: Returns true if product is fragile
     * @return true or false
     */
    public boolean isFragile() {
        return contents.hasFragileItems();
    }


    /**
     * Hazardous: Returns true if product is hazardous
     * @return true or false
     */
    public boolean isHazardous() {
        return contents.hasHazardousItems();
    }
}
