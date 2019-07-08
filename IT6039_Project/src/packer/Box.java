package packer;

/**
 *
 * @author I.M.Bad
 */
public class Box {


    private Manifest contents;
    private Customer customer;
    private Depot depot;

    public Box(Customer customer, Depot depot) {
        this.customer = customer;
        this.depot = depot;
        contents = new Manifest();
    }


    public String getLabel() {
        StringBuilder label = new StringBuilder();
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

    public String toString() {
        return getLabel();
    }

    public double getWeight() {
        return contents.getTotalWeight();
    }

    // Add product, quantity 1
    public void addProduct(Product product) {
        if (canFit(product)) {
            contents.addProduct(product, 1);
        }
    }

    public boolean canFit(Product p) {
        return p.getWeight() < 20;
    }

    public double remainingCapacity() {
        return 20 - this.getWeight();
    }

    public boolean isFragile() {
        return contents.hasFragileItems();
    }

    public boolean isHazardous() {
        return contents.hasHazardousItems();
    }
}
