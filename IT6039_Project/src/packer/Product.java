package packer;

/**
 *
 * @author I.M.Bad
 */
public class Product {

    private String name;
    private int weight;
    private boolean hazardous;
    private boolean fragile;

    /**
     * Product on the manifest list to be packed
     * @param name - Product name
     * @param weight - Product weight
     * @param hazardous - if Product is hazardous true or false
     * @param fragile - if Product is fragile true or false
     */
    public Product(String name, int weight, boolean hazardous, boolean fragile) {
        this.name = name;
        this.weight = weight;
        this.hazardous = hazardous;
        this.fragile = fragile;
    }


    /**
     * Get Weight: Returns the product's weight
     * @return weight
     */
    public int getWeight() {

        return weight;
    }


    /**
     * Get Name: Returns the product's name
     * @return name
     */
    public String getName() {

        return name;
    }


    /**
     * Is Hazardous: returns whether or not the product is hazardous
     * @return hazardous true or false
     */
    public boolean isHazardous() {

        return hazardous;
    }


    /**
     * Is Fragile: returns whether or not the product is
     * @return fragile true or false
     */
    public boolean isFragile() {

        return fragile;
    }


    /**
     * To String: Overrides the toString method to return name
     * @return product name
     */
    public String toString() {
        return this.getName();
    }
}
