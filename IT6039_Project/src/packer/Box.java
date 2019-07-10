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
     * Box: box being packed
     * @param customer
     * @param depot
     * @param capacity
     */
    public Box(Customer customer, Depot depot, Integer capacity) {
        this.customer = customer;
        this.depot = depot;
        this.capacity = capacity;
        contents = new Manifest();
    }


    /**
     * Get Label:
     * @return the box packing label
     */
    public String getLabel() {
        StringBuilder label = new StringBuilder();

        // print to test box capacity
        label.append("Capacity:");
        label.append(capacity);

        label.append("\n");
        label.append(customer);
        label.append("\n");
        label.append(customer.getClosestAddressTo(depot));
        label.append("\n");
        label.append(contents.toString());
        label.append("\n");
        if (this.isFragile()) {
            label.append("FRAGILE\n");   // Fragile
        }
        else if (this.isHazardous()) {
            label.append("HAZARDOUS\n");   // Hazardous
        }
        if (this.getWeight() > 15) {
            label.append("HEAVY\n");   // Heavy
        }
        return label.toString();
    }


    /**
     *
     * @return the label
     */
    public String toString() {
        return getLabel();
    }


    /**
     * Get Weight: calls manifest method to get total weight
     * @return the box total weight of contents
     */
    public double getWeight() {
        return contents.getTotalWeight();
    }


    /**
     * Add Product: Checks product weight with canFit then adds
     * 1 of the product to box
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
        return p.getWeight() < remainingCapacity();
    }


    /**
     * Remaining Capacity: Calculates remaining capacity in box
     * @return
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
